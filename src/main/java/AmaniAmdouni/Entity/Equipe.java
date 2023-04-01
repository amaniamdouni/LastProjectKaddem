package AmaniAmdouni.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int IdEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToOne
    private DetailEquipe detailEquipe;

    @ManyToMany(mappedBy = "equipes")
    private List<Etudiant> etudiants;
}
