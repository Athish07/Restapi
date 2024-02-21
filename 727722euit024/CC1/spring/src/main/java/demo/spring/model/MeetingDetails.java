package demo.spring.model;



import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Meeting_Details")
public class MeetingDetails 
{
    @Id
    long meetingId;
    Date date;
    String Description;
    String Location;
    LocalTime Time;
    float Duration;


    public long getMeetingId() {
        return meetingId;
    }
    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public LocalTime getTime() {
        return Time;
    }
    public void setTime(LocalTime time) {
        Time = time;
    }
    public float getDuration() {
        return Duration;
    }
    public void setDuration(float duration) {
        Duration = duration;
    }

    
}
