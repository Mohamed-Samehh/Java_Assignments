import java.util.Objects;
import java.util.Comparator;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        countryDao.findAllCountries().stream()
                .map(Country::getCapital)
                .map(cityDao::findCityById)
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(City::getPopulation))
                .ifPresent(System.out::println);
    }

}