package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Departement;
import AmaniAmdouni.Repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentImp implements DepartementServices {
    @Autowired
    private DepartementRepository departementRepository;
    @Override
    public void addDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public List<Departement> getAll() {
        return departementRepository.findAll();
    }


    @Override
    public Departement getById(Integer id) {
        return null;
    }

}
