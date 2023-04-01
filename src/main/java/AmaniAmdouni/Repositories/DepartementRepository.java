package AmaniAmdouni.Repositories;

import AmaniAmdouni.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    //list de depaartement par universite
    //
    @Query("select u.departements from Universite u where u.nomUniversite=?1")
    List<Departement> getAllDepartement(String nomU);

    //sql
    @Query(value = "select * from Departement d " +
            "inner join universite_departements ud " +
            "on ud.departements_id_departement=d.id_departement " +
            "inner join Universite u " +
            "on u.id_universite=universite_id_universite " +
            "where u.nom_universite=?1",nativeQuery = true)
    List<Departement> getAllDepartementSQL(String nomU);
    //list de department ordonne par nombre des etudiants
    @Query(value = "select * from Departement d " +
            "order by (select count (*) from etudiant e " +
            "where d.id_departement= e.departements_id_departement",nativeQuery = true)
    List<Departement>getListDepartementSQL();
}
