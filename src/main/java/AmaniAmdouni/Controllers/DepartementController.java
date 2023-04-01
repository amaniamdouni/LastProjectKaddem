package AmaniAmdouni.Controllers;

import AmaniAmdouni.Entity.Departement;
import AmaniAmdouni.Services.DepartementServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/departmenet")
public class DepartementController {
    @Autowired
    DepartementServices departementServices;
    @GetMapping("/Bonjour")
    public String Bonjour(){
        return "Welcome to IT Departement";
    }
    @GetMapping("/getAlDep")
    public List<Departement> getAllDemartement()
    {
        return departementServices.getAll();
    }
    @GetMapping("/getById{id}")
    public Departement getID(@PathVariable int id)
    {
        return departementServices.getById(id);
    }
    @PostMapping("/addDep")
    public void addDepartement(@RequestBody Departement departement)
    {
        departementServices.addDepartement(departement);
    }
}
