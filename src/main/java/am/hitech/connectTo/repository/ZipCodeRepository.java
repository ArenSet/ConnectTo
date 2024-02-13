package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Integer> {

    List<ZipCode> findByStateId(int stateId);
}
