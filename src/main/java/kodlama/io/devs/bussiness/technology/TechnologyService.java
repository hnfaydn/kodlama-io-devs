package kodlama.io.devs.bussiness.technology;

import kodlama.io.devs.bussiness.language.requests.CreateLanguageRequest;
import kodlama.io.devs.bussiness.language.requests.UpdateLanguageRequest;
import kodlama.io.devs.bussiness.language.responses.LanguageListResponse;
import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import kodlama.io.devs.bussiness.technology.requests.CreateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.requests.UpdateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.responses.TechnologyListResponse;
import kodlama.io.devs.bussiness.technology.responses.TechnologyResponse;
import kodlama.io.devs.entities.Technology;

import java.util.List;

public interface TechnologyService {

    CreateTechnologyRequest add(CreateTechnologyRequest createTechnologyRequest) throws Exception;

    TechnologyResponse getById(int id) throws Exception;

    String delete(int id) throws Exception;

    TechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    List<TechnologyListResponse> getAll();


}
