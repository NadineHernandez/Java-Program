package com.trilogyed.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)throws Exception{
        clients.inMemory()
                .withClient("html5")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$oWohTOARsntm7aXUrzEhdO0M0EVX9Htmfng8wNbt3qt3ZCzP8peKm")
                .and()

                .withClient("android")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$S8BGtsSCgS47avbXfwJbEuBF7bJ63u4BkKVIHslCQHnwJccf6mRCS")
                .and()

                .withClient("iphone")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$i8wmxNSJAcd.HP0fziiRVeQGAo1YOErFEvOpheRt1ojTAT4MhlTEG");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints.authenticationManager(this.authenticationManager);
    }
}
