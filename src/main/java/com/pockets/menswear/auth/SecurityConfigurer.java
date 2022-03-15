package com.pockets.menswear.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

//    private String[] allowedOrigins = { "http://localhost:4200" };

    @Autowired
    private JwtRequestFilter requestFilter;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedHeader(CorsConfiguration.ALL);
//        corsConfig.addAllowedMethod(CorsConfiguration.ALL);
//
//        Stream.of(allowedOrigins).forEach(origin -> corsConfig.addAllowedOriginPattern(origin));
//
//        return request -> corsConfig;
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        if (allowedOrigins.length > 0) {
//            http.cors().configurationSource(corsConfigurationSource());
//        }
        http.csrf().disable().cors().and()
                .authorizeRequests()
//				.antMatchers("/teacher/**").hasAnyRole("ADMIN", "TEACHER")
                .antMatchers("/manageStock/**").hasRole("ADMIN")
                .antMatchers("/products/**").permitAll()
                .antMatchers("/authenticate/**").permitAll().anyRequest()
                .authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    public static String getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}
