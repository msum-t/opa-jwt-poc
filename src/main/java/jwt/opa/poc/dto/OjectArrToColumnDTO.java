package jwt.opa.poc.dto;


import org.springframework.web.bind.annotation.Mapping;


public interface OjectArrToColumnDTO {

    ColumnDTO toProductDTO(Object[] row);
}
