package AmaniAmdouni.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int IdDetailEquipe;
    private int Salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;
}
