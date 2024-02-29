package demo.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "SignUp_Details")
public class Signupmeeting 
{
 
    @Id
    String username;
    String email;
    String password;
    

}
