package jwt.opa.poc.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDTO {
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

    public ColumnDTO(String opsColumn10, String opsColumn11, String opsColumn12) {

        this.opsColumn10 = opsColumn10;
        this.opsColumn11 = opsColumn11;
        this.opsColumn12 = opsColumn12;
    }
}

