package AmaniAmdouni.Controllers;

import AmaniAmdouni.Entity.Contrat;
import AmaniAmdouni.Services.ContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
@RequiredArgsConstructor
public class ContratController {
    @Autowired
    ContratService contratService;

    @GetMapping("/getALLContrat")
    public List<Contrat> getAll() {
        return contratService.getAll();
    }

    @DeleteMapping("/{id}")
    private void retrieContrat(@PathVariable int id) {
        contratService.retrieContrat(id);
    }

    @PostMapping("/addContrat")
    public void addContrat(@RequestBody Contrat contrat) {
        contratService.addContrat(contrat);
    }

    @PutMapping("/modifyContrat")
    private Contrat updateContrat(@RequestBody Contrat contrat) {
        contratService.updateContrat(contrat);
        return contrat;
    }

    @PostMapping("/affectContratToEtudiant")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @RequestBody String nomE,@RequestBody String prenomE) {
        contratService.affectContratToEtudiant(ce, nomE, prenomE);
        return ce;
    }
    @GetMapping("/nombreContratV")
    public Integer nbContratsValides(Date startDate, Date endDate){
        return contratService.nbContratsValides(startDate,endDate);
    }

    @PostMapping("/retriveAndUpContrat")
    public String retrieveAndUpdateStatusContrat(){
        return contratService.retrieveAndUpdateStatusContrat();
    }
}
