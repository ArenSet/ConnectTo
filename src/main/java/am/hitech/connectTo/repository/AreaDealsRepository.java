package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.AreaDeals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDealsRepository extends JpaRepository<AreaDeals, Integer> {

}
