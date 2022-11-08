package kodlama.io.devs.bussiness.language;

import kodlama.io.devs.bussiness.language.requests.CreateLanguageRequest;
import kodlama.io.devs.bussiness.language.requests.UpdateLanguageRequest;
import kodlama.io.devs.bussiness.language.responses.LanguageListResponse;
import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import kodlama.io.devs.bussiness.technology.TechnologyService;
import kodlama.io.devs.dataaccess.LanguageDao;
import kodlama.io.devs.entities.Language;
import kodlama.io.devs.entities.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {

  private LanguageDao languageDao;
  private TechnologyService technologyService;


  public LanguageManager(LanguageDao languageDao, TechnologyService technologyService) {
    this.languageDao = languageDao;
    this.technologyService = technologyService;
  }

  @Override
  public CreateLanguageRequest add(CreateLanguageRequest createLanguageRequest) throws Exception {

    //
    checkNameDuplication(createLanguageRequest.getName());
    checkNameEmptyControl(createLanguageRequest.getName());
    ArrayList<Technology> technologies = new ArrayList<>();


    Language language = new Language();
    language.setId((int) Math.random());
    language.setTechnologies(technologies);
    language.setName(createLanguageRequest.getName());
    this.languageDao.save(language);
    return createLanguageRequest;
  }

  private void checkNameEmptyControl(String name) throws Exception {
    if(name == null || name==""){
      throw new Exception("name cannot null");
    }
  }

  private void checkNameDuplication(String name) throws Exception {
    //       if(this.languageDao.existsByName(createLanguageRequest.getName())){
    //            throw new Exception("this name is already using");
    //        }

    List<Language> languageList = this.languageDao.findAll();
    for (Language languageForeach : languageList) {
      if (languageForeach.getName().equalsIgnoreCase(name)) {
        throw new Exception("this name is already using");
      }
    }
  }

  @Override
  public LanguageResponse getById(int id) throws Exception {
    checkIfIdDoesNotExist(id);
    checkIfIdValid(id);
    Optional<Language> language = this.languageDao.findById(id);
    LanguageResponse languageResponse = new LanguageResponse();
    languageResponse.setName(language.get().getName());
    return languageResponse;
  }

  private void checkIfIdValid(int id) throws Exception {
    if(id<=0){
      throw new Exception("please enter an valid id");
    }
  }

  private void checkIfIdDoesNotExist(int id) throws Exception {
    List<Language> languageList = this.languageDao.findAll();

    for (Language languageForeach:languageList){
      if(languageForeach.getId()!=id){
        throw new Exception("there is no language with following id: "+id);
      }
    }
  }
  @Override
  public String delete(int id) throws Exception {
    checkIfIdDoesNotExist(id);
    checkIfIdValid(id);
    this.languageDao.deleteById(id);
    return "Delete operation has successfully done";
  }

  @Override
  public LanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) throws Exception {
    checkIfIdDoesNotExist(id);
    checkNameDuplication(updateLanguageRequest.getName());
    checkNameEmptyControl(updateLanguageRequest.getName());
    checkIfIdValid(id);

    Optional<Language> language = this.languageDao.findById(id);
    LanguageResponse languageResponse = new LanguageResponse();
    languageResponse.setName(updateLanguageRequest.getName());
    language.get().setName(updateLanguageRequest.getName());
    this.languageDao.save(language.get());
    return languageResponse;
  }

  @Override
  public List<LanguageListResponse> getAll() {
    List<Language> languageList = this.languageDao.findAll();
    List<LanguageListResponse> languageListResponses = new ArrayList<>();
    for (Language language : languageList) {
      LanguageListResponse languageListResponse = new LanguageListResponse();
      languageListResponse.setId(language.getId());
      languageListResponse.setName(language.getName());
      languageListResponses.add(languageListResponse);
    }
    return languageListResponses;
  }

  @Override
  public Language getLanguageById(int id) {

    Optional<Language> language = this.languageDao.findById(id);
    return language.get();
  }
}
