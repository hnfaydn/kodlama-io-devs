package kodlama.io.devs.bussiness.language.requests;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {

    private String name;
    private List<Integer> technologyIds;

}
