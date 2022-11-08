package kodlama.io.devs.api;

import kodlama.io.devs.bussiness.technology.TechnologyService;
import kodlama.io.devs.bussiness.technology.requests.CreateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.requests.UpdateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.responses.TechnologyListResponse;
import kodlama.io.devs.bussiness.technology.responses.TechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/technologies")
public class TechnologyApi {

  private TechnologyService technologyService;

  public TechnologyApi(TechnologyService technologyService) {
    this.technologyService = technologyService;
  }

  @PostMapping("/add")
  CreateTechnologyRequest add(@RequestBody CreateTechnologyRequest createTechnologyRequest)
      throws Exception {
    return this.technologyService.add(createTechnologyRequest);
  }

  @GetMapping("/getById")
  TechnologyResponse getById(@RequestParam int id) throws Exception {
    return this.technologyService.getById(id);
  }

  @DeleteMapping("/delete")
  String delete(@RequestParam int id) throws Exception {
    return this.technologyService.delete(id);
  }

  @PutMapping("/update")
  TechnologyResponse update(
      @RequestParam int id, @RequestBody UpdateTechnologyRequest updateTechnologyRequest)
      throws Exception {
    return this.technologyService.update(id, updateTechnologyRequest);
  }

  @GetMapping("/getAll")
  List<TechnologyListResponse> getAll() {
    return this.technologyService.getAll();
  }
}
