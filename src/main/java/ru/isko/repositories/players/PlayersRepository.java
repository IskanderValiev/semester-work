package ru.isko.repositories.players;


;import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.Country;
import ru.isko.models.Player;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByCountry(Country country);
}
