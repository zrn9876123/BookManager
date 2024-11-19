package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository(DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        //在启动时自动在数据库中创建存储记住我信息的表，仅第一次需要，后续不需要
//        repository.setCreateTableOnStartup(true);
        repository.setDataSource(dataSource);
        return repository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,PersistentTokenRepository tokenRepository) throws Exception {
        return http
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/static/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin( formLogin -> {
                    formLogin.loginPage("/login");
                    formLogin.loginProcessingUrl("/doLogin");
                    formLogin.usernameParameter("username");
                    formLogin.passwordParameter("password");
                    formLogin.defaultSuccessUrl("/");
                    formLogin.failureUrl("/login?failure=true");
                    formLogin.permitAll();
                })
                .logout( logout -> {
                    logout.logoutUrl("/doLogout");
                    logout.logoutSuccessUrl("/login");
                    logout.permitAll();
                })
                .rememberMe( rememberMe -> {
                    rememberMe.rememberMeParameter("remember");
                    rememberMe.tokenValiditySeconds(3600*24*7);
                    rememberMe.tokenRepository(tokenRepository);
                })
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }


}
