package jwt.opa.poc.prodreg;

import jwt.opa.poc.config.RoleBaseColumnValue;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdregCustom {

    List<Object> findAllWithSalesColumnValues(String columnValue ,Class dtoClass);
}
