package com.example.CRUD.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.CRUD.AuthenticationSuccessHandler;
import com.example.CRUD.JwtAuthenticationFilter;
import com.example.CRUD.model.MyUserDetailService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        System.err.println("reached somewhere");
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home", "/register/**").permitAll();
                    registry.requestMatchers("/authenticate/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                // .formLogin(httpSecurityFormLoginConfigurer -> {
                //     httpSecurityFormLoginConfigurer
                //             .loginPage("/login")
                //             .successHandler(new AuthenticationSuccessHandler())
                //             .permitAll();
                // })
                .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails normalUser = User
    //             .builder()
    //             .username("nu")
    //             // password -1234
    //             .password("$2a$12$lCWy./YvV2uOgvVcE6rnBuTp20BhkAVacfgbIC762rg1XjDGokIP2")
    //             .roles("USER")
    //             .build();
    //     UserDetails adminUser = User.builder()
    //             .username("au")
    //             // admin password - 5678
    //             .password("$2a$12$dTD9PFAMHAiR1O1sY7iw6.aZ7UjJFVCZeac6FaMnZFlcY164HFK3S")
    //             .roles("ADMIN", "USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(normalUser, adminUser);
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return  provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(authenticationProvider());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
