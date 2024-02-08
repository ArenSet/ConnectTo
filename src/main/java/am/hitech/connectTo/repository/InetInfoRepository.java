package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.InetInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InetInfoRepository extends JpaRepository<InetInfo, Integer> {

    InetInfo findByName(String name);
}
