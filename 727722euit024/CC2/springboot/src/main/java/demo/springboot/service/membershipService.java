package demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.model.Useradmin;
import demo.springboot.repository.MembershipRepo;

@Service
public class membershipService 
{
   @Autowired MembershipRepo m;

   
   public List<Useradmin>getDetails()
   {
      return m.selectJoin();
   }

   public Useradmin postmeeting(Useradmin s)
   {
       return m.save(s);
   }

}
