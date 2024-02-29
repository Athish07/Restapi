package demo.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.model.MeetingDetails;
import demo.springboot.model.Signupmeeting;
import demo.springboot.model.Useradmin;
import demo.springboot.service.meetingService;
import demo.springboot.service.membershipService;

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
    @Autowired membershipService mem;
//SignIn-----------------------------------------------------------------------------------------------

@GetMapping("/path/signin")
    public String authSignin(@RequestParam String username, @RequestParam String password) 
    {
        return meet.authSignin(username, password);
    }


//SignUP-----------------------------------------------------------------------------------------------

    @PostMapping("/path/signup")
    public ResponseEntity<Signupmeeting> postsSignupmeeting(@RequestBody Signupmeeting entity) {
        Signupmeeting savedEntity = meet.signup(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

//Meeting_Details------------------------------------------------------------------------------------------
   

   @PostMapping("/path/meetingdetails")
    public Useradmin postDetails(@RequestBody Useradmin entity) {
        
        return mem.postmeeting(entity);
    }

    @GetMapping("/path/getdetails")
    public List<MeetingDetails> getDetails(@RequestParam("pageNo") int pageNo , @RequestParam("pageSize") int pageSize ,@RequestParam("sortBy") String sortBy )
    {
        return meet.getmeeting(pageNo,pageSize,sortBy);
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



    @GetMapping("/path/getjoin")
    public List<Useradmin> getMethodName() {
        
        return mem.getDetails();
    }
    
    
}
