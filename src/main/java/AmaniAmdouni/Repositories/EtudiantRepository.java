package AmaniAmdouni.Repositories;

import AmaniAmdouni.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EtudiantRepository extends JpaRepository <Etudiant,Integer> {
    // l objet eli bech yarjaa nemchi lele repo mteou w nekhdem fyh methode (affect contrat to etudiant)
    Etudiant findEtudiantByNomEtudiantAndAndPrenomEtudiant(String nomE, String prenomE);
    //jpql parameter par index (1,2)
    //obligatoirement par order on ne peut pas faire une permutation entre les param (loul b loul w theni b theni khater on a fixé par 1 et 2
    @Query("select e from Etudiant e where e.nomEtudiant=?1 and e.prenomEtudiant=?2 ")
    Etudiant getEtudiantByNomEtudiantAndPrenomEtudiant(String nom,String prenom);
    //named parameter
    //on peut faire une permutation entre les param
    @Query("select e from Etudiant e where e.nomEtudiant=:nom and e.prenomEtudiant=:prenom ")
    Etudiant getEtudiantByNomEtudiantAndPrenomEtudiant2(@Param("nom") String nom, @Param("prenom") String prenom);

}
