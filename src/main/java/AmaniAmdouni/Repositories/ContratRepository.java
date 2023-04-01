package AmaniAmdouni.Repositories;

import AmaniAmdouni.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat,Integer> {
     List<Contrat> findContratByDateDebutContratBetween(Date startDate, Date endDate);
    // List<Contrat> findContratByDateDebutContratBetween();
    // List<Contrat> findContratByDateFinContratAfterAndDateDebutContratBefore(Date startDate, Date endDate);
     ///List<Contrat> DateContrat();
    // List<Contrat> DateFinContrat();
     List<Contrat> findContratByArchiveIsFalse();
}

