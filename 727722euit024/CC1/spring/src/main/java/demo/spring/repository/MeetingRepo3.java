package demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.spring.model.MeetingDetails;

@Repository
public interface MeetingRepo3 extends JpaRepository<MeetingDetails,Long>
{
     
}
