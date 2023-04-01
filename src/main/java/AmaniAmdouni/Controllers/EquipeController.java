package AmaniAmdouni.Controllers;

import AmaniAmdouni.Entity.Equipe;
import AmaniAmdouni.Services.EquipeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    EquipeServices equipeServices;
    @GetMapping("/helloWorld!")
    public String helloWorld(){
        return "Mrs. Amdouni says hello to her co-workers";
    }
    @GetMapping("/getAllEquipe")
    public List<Equipe> getAllEquipe()
    {
        return equipeServices.getAll();
    }
    @GetMapping("/getById{id}")
    public Equipe getID(@PathVariable int id)
    {
        return equipeServices.getById(id);
    }
    @PostMapping("/addEquipe")
    public void addEquipe(@RequestBody Equipe equipe)
    {
        equipeServices.addEquipe(equipe);
    }

}
