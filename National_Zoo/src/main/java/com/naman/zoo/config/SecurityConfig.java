//package com.naman.zoo.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//public class SecurityConfig {
//	
//	@Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors(cors -> cors.configurationSource(apiConfigurationSource()))
//            .csrf(csrf -> csrf.disable())
//            .formLogin(form -> form.disable())
//            .authorizeHttpRequests(request -> request
//                .requestMatchers("/api/auth/user/login",  "/api/auth/user/create", "/api/zoo/countries", "/api/zoo/state/*", "/api/zoo/cities/*",  "/")
//                .permitAll()
//                
//                .anyRequest()
//                .authenticated()
//            )
//            
//            
//        return http.build();
//    }
//	
//	@Bean
//    UrlBasedCorsConfigurationSource apiConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        // Allow specific origin
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true); // If you need to allow credentials (cookies, etc.)
//        
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//}
