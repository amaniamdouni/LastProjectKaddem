package AmaniAmdouni.Controllers;

import AmaniAmdouni.Entity.Departement;
import AmaniAmdouni.Repositories.UniversiteRepository;
import AmaniAmdouni.Services.UniversiteServices;
import AmaniAmdouni.Entity.Universite;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteController {
    @Autowired
    UniversiteServices universiteServices;
    private final UniversiteRepository universiteRepository;
    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome In My Unisersity";
    }
    @GetMapping("/getListUniv")
    public List<Universite> getAllUniversites()
    {
       return universiteServices.getAll();
    }
    @GetMapping("/getUnivByID{id}")
    public Universite getID(@PathVariable int id)
    {
        return universiteServices.getById(id);
    }

    @PutMapping("/UpUniv")
    public void updateUniversite(@RequestBody Universite universite){
        universiteServices.updateUniversite(universite);
    }
    @DeleteMapping("/deleteUniv")
    public void deleteUniversite(@RequestBody Universite universite){
        universiteServices.deleteUniversite(universite);
    }
    @PostMapping("/addNewUniv")
    public void addUniversite(@RequestBody Universite universite)
    {
        universiteServices.addUniversite(universite);
    }

    @PutMapping("/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite, @PathVariable Integer idDepartement) {
        universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @GetMapping
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite){
        return universiteServices.retrieveDepartementsByUniversite(idUniversite);
    }

}
