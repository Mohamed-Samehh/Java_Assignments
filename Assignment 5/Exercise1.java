import java.util.Comparator;
import java.util.Optional;

public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao = InMemoryWorldDao.getInstance();

      countryDao.findAllCountries().stream()
            .forEach(country -> {
               Optional<City> maxCity = country.getCities().stream()
                     .max(Comparator.comparingInt(City::getPopulation));

               if (maxCity.isPresent()) {
                  System.out.println("Country: " + country.getName() + ", City: " + maxCity.get().getName()
                        + ", Population: " + maxCity.get().getPopulation());
               } else {
                  System.out.println("Country: " + country.getName() + " has no cities.");
               }
            });
   }

}