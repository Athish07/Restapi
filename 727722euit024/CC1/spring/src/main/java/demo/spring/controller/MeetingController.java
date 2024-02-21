package demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.model.MeetingDetails;
import demo.spring.model.Siginmeeting;
import demo.spring.service.meetingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
public class MeetingController 
{
    @Autowired meetingService meet;
//SignIn-----------------------------------------------------------------------------------------------

@PostMapping("/path/sigin/add")
public void postsSiginmeeting(@RequestBody Siginmeeting entity) {
    meet.siginmeet(entity);
}

@GetMapping("/path/sigin")

public ResponseEntity<String> authSignin(
            @RequestParam("emailId") String emailId, 
            @RequestParam("password") String password) {
        
        if (meet.authSignin(emailId, password).isPresent()) {
            return ResponseEntity.ok("Login Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }
    }



//Meeting_Details------------------------------------------------------------------------------------------
   

   @PostMapping("/path/meetingdetails")
    public MeetingDetails postDetails(@RequestBody MeetingDetails entity) {
        
        return meet.postmeeting(entity);
    }

    @GetMapping("/path/getdetails")
    public ResponseEntity<List<MeetingDetails>> getDetails() {
        try {
            List<MeetingDetails> meetingDetails = meet.getmeeting();
            return ResponseEntity.ok().body(meetingDetails);
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/path/getdetails/{id}")
    public Optional<MeetingDetails> getMethodName(@PathVariable Long id) {
        return meet.findDetails(id);
    }
    
    @PutMapping("/path/editmeeting/{id}")
    public MeetingDetails putDetails(@PathVariable Long id, @RequestBody MeetingDetails entity) {
        
        return meet.putmeeting(id,entity);
    }

    @DeleteMapping("/path/deletemeeting/{id}")

    public String dMeetingDetails(@PathVariable Long id)
    {
        return meet.deletemeeting(id);
    }
    
}
