package demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.model.MeetingDetails;
import demo.spring.model.Siginmeeting;
import demo.spring.repository.MeetingRepo1;
import demo.spring.repository.MeetingRepo3;

@Service
public class meetingService 
{
       @Autowired MeetingRepo1 m1;
       @Autowired MeetingRepo3 m3;



//SignIn---------------------------------------------------------------------------------------------
       
public Optional<Siginmeeting> authSignin(String emailId, String password) {
    
    return m1.authenticate(emailId, password);
}



public Siginmeeting siginmeet(Siginmeeting s)
{
       return m1.save(s);
}


//Meeting_Details------------------------------------------------------------------------------------
      

    public MeetingDetails postmeeting(MeetingDetails s)
    {
        return m3.save(s);
    }


    public List<MeetingDetails> getmeeting()
    {
        return m3.findAll();
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
