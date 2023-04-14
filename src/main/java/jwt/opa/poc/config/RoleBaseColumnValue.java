package jwt.opa.poc.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleBaseColumnValue {
    private String columnValue;
    private Class dtoClass;
}
