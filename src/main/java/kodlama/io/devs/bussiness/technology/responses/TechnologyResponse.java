package kodlama.io.devs.bussiness.technology.responses;

import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyResponse {
    private String name;

    private LanguageResponse languageResponse;

}
