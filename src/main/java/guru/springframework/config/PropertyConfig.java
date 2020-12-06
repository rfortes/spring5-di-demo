package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author rfortes on 06/12/20
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    private final Environment environment;

    public PropertyConfig(Environment environment) {
        this.environment = environment;
    }

    @Value("${logname}") //Environment variable
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(environment.getProperty("java.home")); // JAVA_HOME environment variable
        return fakeDataSource;
    }

}
