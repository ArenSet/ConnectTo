package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.PhoneService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneServiceRepository extends JpaRepository<PhoneService, Integer> {

    PhoneService findByServiceName(String serviceName);
}
