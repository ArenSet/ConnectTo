package am.hitech.connectTo.service;

import am.hitech.connectTo.model.HomePageMenu;
import am.hitech.connectTo.model.dto.HomePageMenuRequestDto;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface HomePageMenuService {
    HomePageMenu getByName(String name);

    void delete(int id);

    @Transactional
    void addNew(HomePageMenuRequestDto requestDto);

    @Transactional
    void updateHomePageMenu(HomePageMenuRequestDto requestDto, int id) throws NotFoundException;
}
