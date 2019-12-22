package sec.project.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sec.project.domain.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

    Signup findByName(String name);
    Signup findById(Long id);
    
    @Query("SELECT s FROM Signup s WHERE name=?1 AND logo IS NOT NULL")
    public List<Signup> findLogos(String name);
}
