package demo.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.spring.model.Siginmeeting;
@Repository
public interface MeetingRepo1 extends JpaRepository<Siginmeeting, String> {

    @Query("SELECT s FROM Siginmeeting s WHERE s.emailId = :emailId AND s.password = :password")
    Optional<Siginmeeting> authenticate(@Param("emailId") String emailId, @Param("password") String password);
}
