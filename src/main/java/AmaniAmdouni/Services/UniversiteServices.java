package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Departement;
import AmaniAmdouni.Entity.Universite;

import java.util.List;

public interface UniversiteServices {
    void addUniversite(Universite universite);
    void updateUniversite(Universite universite);
    List<Universite> getAll();
    void deleteUniversite(Universite universite);
    Universite getById(Integer id);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
