package demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.springboot.model.MeetingDetails;

@Repository
public interface MeetingRepo3 extends JpaRepository<MeetingDetails,Long>
{
     
}
