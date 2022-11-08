package kodlama.io.devs.bussiness.technology.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {

    private String name;

    private int languageId;
}
