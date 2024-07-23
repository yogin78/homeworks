package com.kodilla.testing.world;

import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.World;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        // Tworzenie krajów
        Country poland = new Country("Poland", new BigDecimal("38386000"));
        Country germany = new Country("Germany", new BigDecimal("83149300"));
        Country france = new Country("France", new BigDecimal("67081000"));
        Country spain = new Country("Spain", new BigDecimal("47329000"));

        Country nigeria = new Country("Nigeria", new BigDecimal("206139589"));
        Country egypt = new Country("Egypt", new BigDecimal("102334404"));
        Country southAfrica = new Country("South Africa", new BigDecimal("59308690"));
        Country morocco = new Country("Morocco", new BigDecimal("36910560"));

        Country china = new Country("China", new BigDecimal("1444216107"));
        Country india = new Country("India", new BigDecimal("1393409038"));
        Country japan = new Country("Japan", new BigDecimal("126010000"));
        Country southKorea = new Country("South Korea", new BigDecimal("51709098"));

        // Tworzenie kontynentów
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(spain);

        Continent africa = new Continent("Africa");
        africa.addCountry(nigeria);
        africa.addCountry(egypt);
        africa.addCountry(southAfrica);
        africa.addCountry(morocco);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(japan);
        asia.addCountry(southKorea);

        // Tworzenie świata
        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        // Sprawdzanie całkowitej populacji świata
        BigDecimal expectedTotalPopulation = new BigDecimal("38386000")
                .add(new BigDecimal("83149300"))
                .add(new BigDecimal("67081000"))
                .add(new BigDecimal("47329000"))
                .add(new BigDecimal("206139589"))
                .add(new BigDecimal("102334404"))
                .add(new BigDecimal("59308690"))
                .add(new BigDecimal("36910560"))
                .add(new BigDecimal("1444216107"))
                .add(new BigDecimal("1393409038"))
                .add(new BigDecimal("126010000"))
                .add(new BigDecimal("51709098"));

        assertEquals(expectedTotalPopulation, world.getPeopleQuantity());
    }
}
