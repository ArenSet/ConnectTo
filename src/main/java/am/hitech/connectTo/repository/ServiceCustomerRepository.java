package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.ServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCustomerRepository extends JpaRepository<ServiceCustomer, Integer> {

    ServiceCustomer findByPosition(int position);

    List<ServiceCustomer> findAll();
}
