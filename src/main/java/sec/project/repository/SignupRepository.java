package sec.project.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sec.project.domain.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

//    @Query("SELECT name, logo FROM SignUp WHERE name = ?1 AND logo IS NOT NULL")
//    public List<Signup> findLogos(String name);
}
