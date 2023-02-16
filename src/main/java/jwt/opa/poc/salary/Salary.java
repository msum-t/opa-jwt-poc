package jwt.opa.poc.salary;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private double amount;
}
