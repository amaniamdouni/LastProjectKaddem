package AmaniAmdouni.Services;

import AmaniAmdouni.Entity.Equipe;

import java.util.List;

public interface EquipeServices {
    void addEquipe(Equipe equipe);
    List<Equipe> getAll();
    Equipe getById(Integer id);
}
