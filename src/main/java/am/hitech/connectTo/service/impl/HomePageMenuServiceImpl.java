package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.HomePageMenu;
import am.hitech.connectTo.model.dto.HomePageMenuRequestDto;
import am.hitech.connectTo.repository.HomePageMenuRepository;
import am.hitech.connectTo.service.HomePageMenuService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomePageMenuServiceImpl implements HomePageMenuService {

    @Autowired
    private HomePageMenuRepository homePageMenuRepository;

    @Override
    public HomePageMenu getByName(String name){
        HomePageMenu homePageMenu = homePageMenuRepository.findByName(name);

        return homePageMenu;
    }

    @Override
    @Transactional
    public void delete(int id){
        homePageMenuRepository.
                deleteById(id);
    }

    @Override
    @Transactional
    public void addNew(HomePageMenuRequestDto requestDto){
        homePageMenuRepository.save(dtoToModel(requestDto));
    }

    @Transactional
    @Override
    public void updateHomePageMenu(HomePageMenuRequestDto requestDto, int id) throws NotFoundException {
        HomePageMenu homePageMenu = homePageMenuRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no any menu element with that id"));
        if (requestDto.getName() != null){
            homePageMenu.setName(requestDto.getName());
        }
        if (requestDto.getPicture() != null){
            homePageMenu.setPicture(requestDto.getPicture());
        }
    }

    private HomePageMenu dtoToModel(HomePageMenuRequestDto requestDto){
        HomePageMenu homePageMenu = new HomePageMenu();
        homePageMenu.setName(requestDto.getName());
        homePageMenu.setPicture(requestDto.getPicture());

        return homePageMenu;
    }
}
