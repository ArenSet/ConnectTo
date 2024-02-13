package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findByCountry(String country);
}
