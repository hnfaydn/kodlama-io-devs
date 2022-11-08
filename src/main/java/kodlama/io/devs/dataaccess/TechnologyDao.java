package kodlama.io.devs.dataaccess;

import kodlama.io.devs.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyDao extends JpaRepository<Technology,Integer> {
}
