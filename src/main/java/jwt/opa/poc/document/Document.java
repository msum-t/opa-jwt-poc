package jwt.opa.poc.document;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String owner;


}
