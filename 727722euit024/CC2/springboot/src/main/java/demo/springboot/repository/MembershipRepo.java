package demo.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import demo.springboot.model.Useradmin;
import java.util.List;

@Repository
public interface MembershipRepo extends JpaRepository<Useradmin, Integer> {
    @Query(value = "SELECT * FROM useradmin u JOIN meeting_details d ON u.id = d.admin_id",nativeQuery = true)
    List<Useradmin> selectJoin();
}
