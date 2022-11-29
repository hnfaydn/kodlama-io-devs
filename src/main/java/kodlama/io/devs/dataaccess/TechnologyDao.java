package kodlama.io.devs.dataaccess;

import kodlama.io.devs.entities.Technology;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer> {


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM deletetest.public.languages_technologies WHERE technologies_technology_id = :id",nativeQuery = true)
    void deleteLanguageTechnologyById(@Param("id")int id);

}
