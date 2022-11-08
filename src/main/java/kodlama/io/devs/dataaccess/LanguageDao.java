package kodlama.io.devs.dataaccess;

import kodlama.io.devs.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends JpaRepository<Language,Integer> {

    //boolean existsByName(String name);
//    boolean existsById(int id);
    //boolean existsByNameContainingIgnoreCase(String name);
}
