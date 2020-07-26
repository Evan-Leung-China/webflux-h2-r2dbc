package com.evan.demo.webflux.webfluxh2r2dbc.configuration;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
@Configuration
@EnableR2dbcRepositories
public class R2dbcInitializerConfiguration {
    /**
     * TODO: sql文件
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public ConnectionFactoryInitializer h2Initializer(ConnectionFactory connectionFactory) {
        // 初始化数据库

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        // 这里的语句在每次应用启动的时候都会执行，所以请确保SQL可重复执行而不会影响使用
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("db/db-schema.sql")));
//        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("com/foo/sql/test-data1.sql")));
        initializer.setDatabasePopulator(populator);

        return initializer;
    }


}
