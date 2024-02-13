package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    State findByState(String state);
    List<State> findByCountryId(int countryId);
}
