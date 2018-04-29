package com.example.oauthserver.config.social;


import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.github.connect.GitHubConnectionFactory;

import javax.sql.DataSource;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오전 10:55
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSouce;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new GitHubConnectionFactory(
                environment.getProperty("spring.social.github.appId"),
                environment.getProperty("spring.social.github.appSecret")
        ));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSouce,connectionFactoryLocator, Encryptors.noOpText());
        return repository;
    }

    @Bean
    public ConnectController getConnectController(ConnectionFactoryLocator connectionFActoryLocator, ConnectionRepository connectionRepository){
        return new ConnectController(connectionFActoryLocator,connectionRepository);
    }

    @Bean
    public ProviderSignInUtils getProviderSignInUitls(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository){
        return new ProviderSignInUtils(connectionFactoryLocator,usersConnectionRepository);
    }
}
