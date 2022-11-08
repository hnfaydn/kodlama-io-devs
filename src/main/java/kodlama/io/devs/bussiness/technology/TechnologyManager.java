package kodlama.io.devs.bussiness.technology;

import kodlama.io.devs.bussiness.language.LanguageService;
import kodlama.io.devs.bussiness.language.responses.LanguageResponse;
import kodlama.io.devs.bussiness.technology.requests.CreateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.requests.UpdateTechnologyRequest;
import kodlama.io.devs.bussiness.technology.responses.TechnologyListResponse;
import kodlama.io.devs.bussiness.technology.responses.TechnologyResponse;
import kodlama.io.devs.dataaccess.TechnologyDao;
import kodlama.io.devs.entities.Language;
import kodlama.io.devs.entities.Technology;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TechnologyManager implements TechnologyService{

    private TechnologyDao technologyDao;
    @Lazy
    private LanguageService languageService;

    public TechnologyManager(TechnologyDao technologyDao,@Lazy LanguageService languageService) {
        this.technologyDao = technologyDao;
        this.languageService = languageService;
    }

    @Override
    public CreateTechnologyRequest add(CreateTechnologyRequest createTechnologyRequest) throws Exception {

        Technology technology = new Technology();
        technology.setId((int) Math.random());
        technology.setLanguage(this.languageService.getLanguageById(createTechnologyRequest.getLanguageId()));
        technology.setName(createTechnologyRequest.getName());
        this.technologyDao.save(technology);
        return createTechnologyRequest;
    }

    @Override
    public TechnologyResponse getById(int id) throws Exception {

        Optional<Technology> technology = this.technologyDao.findById(id);
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setName(technology.get().getName());
        return technologyResponse;
    }

    @Override
    public String delete(int id) throws Exception {
        this.technologyDao.deleteById(id);
        return "technology deleted successfully";
    }

    @Override
    public TechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        Optional<Technology> technology = this.technologyDao.findById(id);
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setName(updateTechnologyRequest.getName());
        technology.get().setName(updateTechnologyRequest.getName());
        this.technologyDao.save(technology.get());
        return technologyResponse;
    }

    @Override
    public List<TechnologyListResponse> getAll() {
        List<Technology> technologyList = this.technologyDao.findAll();
        List<TechnologyListResponse> technologyListResponses = new ArrayList<>();

        LanguageResponse languageResponse = new LanguageResponse();
        for (Technology technology : technologyList) {
            TechnologyListResponse technologyListResponse = new TechnologyListResponse();
            technologyListResponse.setId(technology.getId());
            technologyListResponse.setName(technology.getName());
            technologyListResponses.add(technologyListResponse);
            String name = this.languageService.getLanguageById(technology.getLanguage().getId()).getName();
            languageResponse.setName(name);
            technologyListResponse.setLanguageResponse(languageResponse);
        }
        return technologyListResponses;
    }

}
