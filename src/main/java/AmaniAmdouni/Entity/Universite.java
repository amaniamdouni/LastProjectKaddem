package AmaniAmdouni.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int IdUniversite;
    private String nomUniversite;

    @OneToMany
    private List<Departement> departements;
}
