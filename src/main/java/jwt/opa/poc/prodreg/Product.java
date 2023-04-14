package jwt.opa.poc.prodreg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_tble")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String saleColumn1;
    private String saleColumn2;
    private String saleColumn3;
    private String approverColumn4;
    private String approverColumn5;
    private String approverColumn6;
    private String dealerColumn7;
    private String dealerColumn8;
    private String dealerColumn9;
    private String opsColumn10;
    private String opsColumn11;
    private String opsColumn12;

}
