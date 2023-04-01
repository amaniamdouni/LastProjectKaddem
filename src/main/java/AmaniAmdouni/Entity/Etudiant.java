package AmaniAmdouni.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEtudiant;
    private String prenomEtudiant;
    private String nomEtudiant;
    @Enumerated(EnumType.STRING)
    private Option option;

    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;

    @ManyToOne
    private Departement departement;

    @ManyToMany
    private List<Equipe> equipes;

    @OneToOne
    private DetailEquipe detailEquipe;
}
