package AmaniAmdouni.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int IdDepartement;
    private String nomDepartement;

    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;

}
