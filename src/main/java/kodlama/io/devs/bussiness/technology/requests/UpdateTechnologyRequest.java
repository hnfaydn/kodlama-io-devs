package kodlama.io.devs.bussiness.technology.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
    private String name;
    private int languageId;

}
