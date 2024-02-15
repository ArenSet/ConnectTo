package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Integer> {


    @Query(nativeQuery = true, value = "select * from `zip_code` where `state_id` = ?1 and `zip_code` like concat(?2,'%')")
    List<ZipCode> findByStateId(int stateId, String zipCode);

    /*ZipCode findById(int id);*/

    @Query(nativeQuery = true, value = "select * from `zip_code` where `id` = ?1")
    ZipCode getById(int id);
}
