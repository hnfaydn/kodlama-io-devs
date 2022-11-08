package kodlama.io.devs.api;

import kodlama.io.devs.bussiness.language.LanguageService;
import kodlama.io.devs.bussiness.language.requests.CreateLanguageRequest;
import kodlama.io.devs.bussiness.language.requests.UpdateLanguageRequest;
import kodlama.io.devs.bussiness.language.responses.LanguageListResponse;
import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import kodlama.io.devs.entities.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageApi {

  private LanguageService languageService;

  public LanguageApi(LanguageService languageService) {
    this.languageService = languageService;
  }

  @PostMapping("/add")
  CreateLanguageRequest add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
    return this.languageService.add(createLanguageRequest);
  }

  @GetMapping("/getById")
  LanguageResponse getById(@RequestParam int id) throws Exception {
      return this.languageService.getById(id);
  }

  @DeleteMapping("/delete")
  String delete(@RequestParam int id) throws Exception {
      return this.languageService.delete(id);
  }

  @PutMapping("/update")
  LanguageResponse update(@RequestParam int id,@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
      return this.languageService.update(id,updateLanguageRequest);
  }

  @GetMapping("/getAll")
  List<LanguageListResponse> getAll(){
      return this.languageService.getAll();
  }
}
