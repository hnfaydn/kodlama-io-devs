package kodlama.io.devs.bussiness.language.responses;

import kodlama.io.devs.bussiness.technology.responses.TechnologyListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageListResponse {

  private int id;
  private String name;

  List<TechnologyListResponse> technologyListResponses;
}
