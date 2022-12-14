package kodlama.io.devs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "Lazy"})
public class Technology {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "technology_id")
  private int id;

  @Column(name = "name")
  private String name;
}
