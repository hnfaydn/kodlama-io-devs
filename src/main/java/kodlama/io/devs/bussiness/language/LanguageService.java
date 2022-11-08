package kodlama.io.devs.bussiness.language;

import kodlama.io.devs.bussiness.language.requests.CreateLanguageRequest;
import kodlama.io.devs.bussiness.language.requests.UpdateLanguageRequest;
import kodlama.io.devs.bussiness.language.responses.LanguageListResponse;
import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import kodlama.io.devs.entities.Language;

import java.util.List;

public interface LanguageService {

  CreateLanguageRequest add(CreateLanguageRequest createLanguageRequest) throws Exception;

  LanguageResponse getById(int id) throws Exception;

  String delete(int id) throws Exception;

  LanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) throws Exception;

  List<LanguageListResponse> getAll() throws Exception;

  Language getLanguageById(int id);
}
