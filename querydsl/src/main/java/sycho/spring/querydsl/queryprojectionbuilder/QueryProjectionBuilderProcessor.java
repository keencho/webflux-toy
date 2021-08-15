package sycho.spring.querydsl.queryprojectionbuilder;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SupportedAnnotationTypes("sycho.spring.querydsl")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class QueryProjectionBuilderProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement annotation : set) {
            Element type = roundEnvironment.getElementsAnnotatedWith(annotation).stream().findFirst().orElseGet(null);
            String classFullName = type.toString();
            String packageName = classFullName.substring(0, classFullName.lastIndexOf("."));
            String className = classFullName.substring(packageName.length() + 1);
            String newClassName = className + "WithGetter";

            StringBuilder code = new StringBuilder();
            code.append("package ").append(packageName).append(";\n\n");
            code.append("public class ").append(newClassName).append(" {\n");

            type.getEnclosedElements().stream()
                    .filter(e -> e.getKind() == ElementKind.FIELD)
                    .forEach(field -> {
                        code.append("    ");

                        Optional<Modifier> modifier = field.getModifiers().stream().findFirst();
                        modifier.ifPresent(value -> code.append(value.toString().toLowerCase()).append(" "));

                        code.append(field.asType().toString()).append(" ").append(field.toString()).append(";\n\n");

                        code.append("    ").append("public ").append(field.asType().toString()).append(" ").append(field.toString()).append("() {\n");
                        code.append("        ").append("return ").append(field.toString()).append(";\n");
                        code.append("    }\n");
                    });

            code.append("}\n");

            try  {
                JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + newClassName);

                try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
                    out.println(code);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
