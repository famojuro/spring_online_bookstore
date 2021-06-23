package com.innovativeapps.bookstoremanager.config;

import com.innovativeapps.bookstoremanager.util.exception.GeneralAppExceptionMapper;
import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(com.innovativeapps.employeeManager.cors.CorsFilter.class);
        register(GeneralAppExceptionMapper.class);
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {

                // context
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/bookstorecms");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");

                resource.setProperty("url", "jdbc:mysql://localhost:3306/spring_book_store?useSSL=false");
                resource.setProperty("username", "root");
                resource.setProperty("password", "password");
                context.getNamingResources()
                        .addResource(resource);
            }
        };
    }
}
