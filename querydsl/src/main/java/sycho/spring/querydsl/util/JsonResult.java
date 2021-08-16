package sycho.spring.querydsl.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonResult {
    private boolean success;
    private Object data;
    private String message;

    public static JsonResult success() {
        return success(null);
    }

    public static JsonResult success(Object data) {
        JsonResult result = new JsonResult();
        result.success = true;
        result.data = data;
        result.message = null;

        return result;
    }

    public static JsonResult failure(String message) {
        JsonResult result = new JsonResult();
        result.success = false;
        result.data = null;
        result.message = message;

        return result;
    }
}
