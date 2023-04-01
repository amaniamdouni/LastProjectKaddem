package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Contrat;

import java.util.*;

public interface ContratService {
    void addContrat(Contrat contrat);
    void updateContrat(Contrat contrat);
    List<Contrat> getAll();
    void   retrieContrat (Integer id);
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);
    Integer nbContratsValides(Date startDate, Date endDate);
   String retrieveAndUpdateStatusContrat();
}
