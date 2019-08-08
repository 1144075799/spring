package config;


import org.springframework.context.annotation.*;


/**
 * 该类是一个配置类
 * 他的作用是跟application.xml一样
 */
@ComponentScan("com.spring")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {



}
