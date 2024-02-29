package demo.springboot.model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "useradmin")
public class Useradmin {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String name;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "admin_id")
   private List<MeetingDetails> meetingDetails = new ArrayList<>();
}
