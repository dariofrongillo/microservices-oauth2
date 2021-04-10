package it.italiancoders.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;



@Configuration
public class SecurityConfig {

    @Autowired
    private ReactiveClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authorizeExchange(exchange -> exchange.matchers(EndpointRequest.toAnyEndpoint()).permitAll()
                        .anyExchange().authenticated())
                .oauth2Login(oauth2 -> oauth2.clientRegistrationRepository(clientRegistrationRepository))
                .build();
    }
}
