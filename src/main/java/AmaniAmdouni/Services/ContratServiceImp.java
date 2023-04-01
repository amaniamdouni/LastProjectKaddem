package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Contrat;
import AmaniAmdouni.Entity.Etudiant;
import AmaniAmdouni.Repositories.ContratRepository;
import AmaniAmdouni.Repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ContratServiceImp implements ContratService{
    @Autowired
    private final ContratRepository contratRepository;
    private final EtudiantRepository etudiantRepository;
    @Override
    public void addContrat(Contrat contrat) {
      contratRepository.save(contrat);
    }

    @Override
    public void updateContrat(Contrat contrat) {
       contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }

    @Override
    public void retrieContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant= etudiantRepository.findEtudiantByNomEtudiantAndAndPrenomEtudiant(nomE, prenomE);
        if (etudiant!=null && etudiant.getContrats().size()<5)
        {
           ce.setEtudiant(etudiant);
           contratRepository.save(ce);
        }
        return ce;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        log.info("in method nbContratsValides");
       List<Contrat> contrats=contratRepository.findContratByDateDebutContratBetween(startDate,endDate);
       Integer compteur = 0;
        for (Contrat contrat : contrats)
        {
            if (contrat.getDateDebutContrat().before(endDate) && contrat.getDateFinContrat().after(startDate)) {
                compteur++;
            }
        }
        log.info("out of method nbContratsValides");
        return compteur;

        //2eme methode avec keyword
       /// List<Contrat> contrats = contratRepository.findContratByDateFinContratAfterAndDateDebutContratBefore(startDate,endDate);
       // return contrats.size();
    }

    @Scheduled(cron = "0 0 13 * * *")
    //@Scheduled(fixedDelay = 60000*5)
    @Override
    public String retrieveAndUpdateStatusContrat() {
        Date date = new Date();
        Date MaxDate = DateUtils.addDays(date, 15);

        List<Contrat> allContrats = contratRepository.findContratByArchiveIsFalse();
        List<Contrat> expiringContrats = new ArrayList<>();

        for (Contrat contrat : allContrats) {
            if (contrat.getDateFinContrat().before(date)) {
                contrat.setArchive(true);
                contratRepository.save(contrat);
            } else if (contrat.getDateFinContrat().after(date) && contrat.getDateFinContrat().before(MaxDate)) {
                expiringContrats.add(contrat);
            }
        }
        return expiringContrats.toString();
    }
}
