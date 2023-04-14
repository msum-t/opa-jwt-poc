package jwt.opa.poc.prodreg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SaleDTOAvroWrapper {
    private List<Object> objectList;

}
