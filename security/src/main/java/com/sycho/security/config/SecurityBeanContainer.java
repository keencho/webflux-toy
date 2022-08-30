package com.sycho.security.config;

import com.keencho.lib.spring.common.config.KcGlobalExceptionHandler;
import com.keencho.lib.spring.security.provider.KcAuthenticationProviderManager;
import com.keencho.lib.spring.security.provider.KcAuthenticationProviderManagerImpl;
import com.keencho.lib.spring.security.provider.KcUserDetailsAuthenticationProvider;
import com.sycho.security.manager.AdminLoginManager;
import com.sycho.security.manager.UserLoginManager;
import com.sycho.security.model.AdminAccount;
import com.sycho.security.model.UserAccount;
import com.sycho.security.repository.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ConditionalOnMissingBean(annotation = ControllerAdvice.class)
public class SecurityBeanContainer {

    @Autowired
    AdminAccountRepository adminAccountRepository;

    @Autowired
    AdminLoginManager adminAccountLoginManager;

    @Autowired
    UserLoginManager userLoginManager;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public KcGlobalExceptionHandler globalExceptionHandler() {
        return new KcGlobalExceptionHandler() {};
    }

    @Bean
    public KcAuthenticationProviderManager authenticationProviderManager() {
        var authenticationProviderManager = new KcAuthenticationProviderManagerImpl();

        authenticationProviderManager.addAuthenticationProvider(
                AdminAccount.class,
                new KcUserDetailsAuthenticationProvider(this.bCryptPasswordEncoder(), this.adminAccountLoginManager)
        );

        authenticationProviderManager.addAuthenticationProvider(
                UserAccount.class,
                new KcUserDetailsAuthenticationProvider(this.bCryptPasswordEncoder(), this.userLoginManager)
        );

        return authenticationProviderManager;
    }
}
