package jwt.opa.poc.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tble")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String emailId;

    private String role;

}
