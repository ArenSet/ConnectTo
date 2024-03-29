package am.hitech.connectTo.repository;

import am.hitech.connectTo.model.HomePageMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageMenuRepository extends JpaRepository<HomePageMenu, Integer> {

    HomePageMenu findByName(String name);

    List<HomePageMenu> findAll();
}
