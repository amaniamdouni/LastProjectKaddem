package AmaniAmdouni.Controllers;

import AmaniAmdouni.Entity.Etudiant;
import AmaniAmdouni.Services.EtudiantServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "test")
@RestController//pour dire asna3li instance men service
@RequestMapping("etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantServices etudiantServices;
    @GetMapping("/HelloStud")
    public String Student()
    {
        return "Hello Students";
    }
    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant(){
        return etudiantServices.getAll();
    }
    @GetMapping("/getById{id}")
    public Etudiant getID(@PathVariable int id)
    {
        return etudiantServices.getById(id);
    }
    @PostMapping("/addEtudiant")
    public void addEtudiants(@RequestBody Etudiant etudiant)
    {
        etudiantServices.addEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtud")

    public void deleteEtudiant(@RequestBody Etudiant etudiant){
        etudiantServices.deleteEtudiant(etudiant);
    }
    @PutMapping("/UpEtud")
    public void updateEtudiant(@RequestBody Etudiant e){
        etudiantServices.updateEtudiant(e);
    }
    @PostMapping("/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable Integer idContrat, @PathVariable Integer idEquipe) {
        return etudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);

    }
    @PostMapping("/addEtudToDep")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId, @PathVariable Integer departemenId){
        etudiantServices.assignEtudiantToDepartement(etudiantId,departemenId);
    }
    @GetMapping("/getEtudByDep")
    List<Etudiant> getEtudiantsByDepartement (@PathVariable Integer idDepartement){
        return etudiantServices.getEtudiantsByDepartement(idDepartement);

    }

}
