package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Etudiant;

import java.util.List;

public interface EtudiantServices {
    void addEtudiant(Etudiant e);
    void updateEtudiant(Etudiant e);
    List<Etudiant> getAll();
    void deleteEtudiant(Etudiant etudiant);
    Etudiant getById(Integer id);
    void assignEtudiantToDepartement(Integer etudiantId, Integer departemenId);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
