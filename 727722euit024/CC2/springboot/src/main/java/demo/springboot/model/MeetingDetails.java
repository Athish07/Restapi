package demo.springboot.model;
import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="Meeting_Details")
public class MeetingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long meetingId;
    private Date date;
    private String description;
    private String location;
    private Time time;
    private float duration;
}
