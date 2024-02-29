package demo.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import demo.springboot.model.MeetingDetails;
import demo.springboot.model.Signupmeeting;
import demo.springboot.repository.MeetingRepo1;
import demo.springboot.repository.MeetingRepo3;

@Service
public class meetingService 
{
       @Autowired MeetingRepo1 m2;
       @Autowired MeetingRepo3 m3;
    



//SignIn---------------------------------------------------------------------------------------------
       
public String authSignin(String username, String password) {
    Optional<Signupmeeting> userOptional = m2.authenticate(username, password);
    if (userOptional.isPresent()) {
        return "Login Successfully";
    } else {
        return "Invalid Username or Password";
    }
}



//SignUP Meeting----------------------------------------------------------------------------------------------

     public Signupmeeting signup(Signupmeeting s)
     {
            return m2.save(s);
     }

//Meeting_Details------------------------------------------------------------------------------------
      

   


    public List<MeetingDetails> getmeeting(int pageNo,int pageSize, String sortBy)
    {
        return m3.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC,sortBy)).getContent();
    }

    public Optional<MeetingDetails> findDetails(Long id)
    {
           return m3.findById(id);
    }


    public MeetingDetails putmeeting(Long id,MeetingDetails s)
    {
        MeetingDetails details=m3.findById(id).orElse(null);

        if(details!=null)
        {
            details.setDate(s.getDate());
            details.setDescription(s.getDescription());
            details.setDuration(s.getDuration());
            details.setLocation(s.getLocation());
            details.setTime(s.getTime());
        }
        return m3.saveAndFlush(details);
    }

    public String deletemeeting(long id)
    {
        m3.deleteById(id);
        return ("User Deleted");
    }

}
