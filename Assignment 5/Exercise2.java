import java.util.Comparator;
import java.util.Optional;

public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        countryDao.getAllContinents().stream()
                .forEach(continent -> {
                    Optional<City> maxCity = countryDao.findCountriesByContinent(continent).stream()
                            .flatMap(country -> country.getCities().stream())
                            .max(Comparator.comparingInt(City::getPopulation));

                    if (maxCity.isPresent()) {
                        System.out.println("Continent: " + continent + " Max City: " + maxCity.get().getName()
                                + ", Population: " + maxCity.get().getPopulation());
                    } else {
                        System.out.println("Continent: " + continent + " has no cities.");
                    }
                });

    }

}
