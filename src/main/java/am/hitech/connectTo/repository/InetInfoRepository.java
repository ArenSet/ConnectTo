package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.InetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface InetInfoRepository extends JpaRepository<InetInfo, Integer> {

    InetInfo findByName(String name);

    @Modifying
    void deleteByName(String name);

}
