package ru.isko.repositories.countries;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.Country;

public interface CountriesRepository extends JpaRepository<Country, Long> {
//    Country findCountryByName(String name);
//    List<Country> findALL();
//    String getColumnByName(String columnName, String name);
}
