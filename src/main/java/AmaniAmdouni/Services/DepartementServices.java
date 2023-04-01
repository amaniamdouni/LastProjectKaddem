package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Departement;

import java.util.List;

public interface DepartementServices {
    void addDepartement(Departement departement);
    List<Departement> getAll();
    Departement getById(Integer id);
}
