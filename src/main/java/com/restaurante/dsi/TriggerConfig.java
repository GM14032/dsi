package com.restaurante.dsi;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TriggerConfig {
    private final DataSource dataSource;

    public TriggerConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void executeTriggerScript() throws SQLException, IOException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlScript = getResourceContent("trigger.sql");
            statement.executeUpdate(sqlScript);
        }
    }

    private String getResourceContent(String resourceName) throws IOException {
        ClassPathResource resource = new ClassPathResource(resourceName);
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}