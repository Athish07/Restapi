package demo.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.springboot.model.Signupmeeting;

@Repository
public interface MeetingRepo1 extends JpaRepository<Signupmeeting,String>
{

    @Query("SELECT s FROM Signupmeeting s WHERE s.username = :username AND s.password = :password")
    Optional<Signupmeeting> authenticate(@Param("username") String username, @Param("password") String password);
}
