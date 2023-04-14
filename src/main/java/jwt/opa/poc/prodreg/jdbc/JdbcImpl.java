package jwt.opa.poc.prodreg.jdbc;

import jwt.opa.poc.config.QueryGenerator;
import jwt.opa.poc.config.RoleBaseColumnConfig;
import jwt.opa.poc.dto.ColumnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcImpl {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private QueryGenerator queryGenerator;

    @Autowired
    private RoleBaseColumnConfig roleBaseColumnConfig;

    @PreAuthorize("@opaClientProdReg.allow(T(java.util.Map).of('columnValue', (T(java.util.Arrays).#columnValue.split(','))))")
    public List<ColumnDTO> retrieveDynamical(String columnValue) {
        String sql = queryGenerator.generateSelectQuery("product_tble",columnValue, null);
        return template.query(sql, BeanPropertyRowMapper.newInstance(ColumnDTO.class));
    }

}
