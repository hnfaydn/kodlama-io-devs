package kodlama.io.devs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "Lazy"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Technology> technologies;
}
