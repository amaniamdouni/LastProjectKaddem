package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Departement;
import AmaniAmdouni.Repositories.DepartementRepository;
import AmaniAmdouni.Repositories.UniversiteRepository;
import AmaniAmdouni.Entity.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class UniversiteImp implements UniversiteServices {
    @Autowired
    private UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;

    public UniversiteImp(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }
    @Override
    public void addUniversite(Universite universite) {
        universiteRepository.save(universite);
    }

    @Override
    public void updateUniversite(Universite universite) {
    }

    @Override
    public List<Universite> getAll() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(Universite universite) {
       universiteRepository.delete(universite);
    }

    @Override
    public Universite getById(Integer id) {

        return universiteRepository.findById(id).get();
    }
    //@Transactional kif nhotou hethi me nhotouch (.save) idha me fama hata err t affecti idha fama err me taamel chy traja3 el 9dim eli aandna
    //taamel update entity
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);

        Assert.notNull(universite, "universite must not be null.") ;
        Assert.notNull(departement, "departement must not be null.") ;
         // get tjib liste l 9dima w tzid aliha bel add l affectaion l jdida
        universite.getDepartements().add(departement);
        // save hata me famech manager entity tansaa wehed jdid idha fama t affecti fyh
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.notNull(universite,"univ not null");
        return universite.getDepartements();
    }

}
