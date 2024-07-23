package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Continent> continents;

    public World() {
        this.continents = new ArrayList<>();
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void main(String[] args) {

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

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        // Displaying total population
        System.out.println("Total world population: " + world.getPeopleQuantity());
    }
}
