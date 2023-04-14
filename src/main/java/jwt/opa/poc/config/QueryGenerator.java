package jwt.opa.poc.config;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QueryGenerator {
    @PersistenceContext
    private EntityManager entityManager;
    public  String generateSelectQuery(String tableName, String selectClause, Map<String, Object> conditions) {

        // Build the where clause
        List<String> whereClauses = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        int paramIndex = 1;
        if(conditions!=null) {
            for (Map.Entry<String, Object> entry : conditions.entrySet()) {
                String columnName = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    String paramName = "param" + paramIndex;
                    whereClauses.add(columnName + " = :" + paramName);
                    values.add(value);
                    paramIndex++;
                }
            }
        }
        String whereClause = whereClauses.isEmpty() ? "" : " WHERE " + String.join(" AND ", whereClauses);

        // Build the query
        String query = String.format("SELECT %s FROM %s%s", selectClause, tableName, whereClause);

        // Create a Query object and set the parameter values
        Query nativeQuery = entityManager.createNativeQuery(query);
        for (int i = 0; i < values.size(); i++) {
            nativeQuery.setParameter("param" + (i + 1), values.get(i));
        }

        // Get the generated SQL string from the Query object and return it
        return nativeQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    }
}
