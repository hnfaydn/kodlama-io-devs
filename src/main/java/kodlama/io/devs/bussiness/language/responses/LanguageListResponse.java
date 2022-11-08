package kodlama.io.devs.bussiness.language.responses;

import kodlama.io.devs.bussiness.technology.responses.TechnologyListResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageListResponse {

    private int id;
    private String name;
}
