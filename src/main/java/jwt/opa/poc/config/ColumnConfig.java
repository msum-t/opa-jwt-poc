package jwt.opa.poc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "role-base-column-value")
@Data
public class ColumnConfig {

    private String sales;
    private String approver;

    private String ops;
    private String dealer;

    private Class classType;
}
