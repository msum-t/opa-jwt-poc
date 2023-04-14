package jwt.opa.poc.config;

import jwt.opa.poc.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleBaseColumnConfig {

    @Autowired
    private ColumnConfig columnConfig;
    public RoleBaseColumnValue generateColumnValue() {

        List<String> authorities = SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toUnmodifiableList());

        Set<String> roleBasedColumnValues = new HashSet<>();

        if (authorities.contains("ROLE_SALES")) {
            roleBasedColumnValues.add(columnConfig.getSales());
        }

        if (authorities.contains("ROLE_APPROVER")) {
            roleBasedColumnValues.add(columnConfig.getApprover());
        }

        if (authorities.contains("ROLE_DEALER")) {
            roleBasedColumnValues.add(columnConfig.getDealer());
        }

        if (authorities.contains("ROLE_OPS")) {
            roleBasedColumnValues.add(columnConfig.getOps());
        }

        String concatenatedColumnValue = String.join(",", roleBasedColumnValues);
        return RoleBaseColumnValue.builder()
                .columnValue(concatenatedColumnValue)
                .build();

    }
}
