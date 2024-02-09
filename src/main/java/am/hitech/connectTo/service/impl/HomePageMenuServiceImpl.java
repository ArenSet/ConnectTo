package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.HomePageMenu;
import am.hitech.connectTo.model.dto.HomePageMenuRequestDto;
import am.hitech.connectTo.model.dto.HomePageResponseDto;
import am.hitech.connectTo.repository.HomePageMenuRepository;
import am.hitech.connectTo.service.HomePageMenuService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<HomePageResponseDto> getAll(){
        List<HomePageMenu> homePageMenus = homePageMenuRepository.findAll();
        List<HomePageResponseDto> responseDto = new ArrayList<>();
        for (int i = 0; i < homePageMenus.size(); i++){
            HomePageMenu homePageMenu = homePageMenus.get(i);
            responseDto.add(modelToDto(homePageMenu));

            HomePageResponseDto homePageResponseDto = responseDto.get(i);
            if ((i + 1) % 3 == 0){
                homePageResponseDto.setPicture(null);
            }
        }
        return responseDto;
    }

    @Override
    public List<HomePageResponseDto> authenticated(){
        List<HomePageMenu> homePageMenus = homePageMenuRepository.findAll();
        List<HomePageResponseDto> responseDto = new ArrayList<>();
        for (int i = 0; i < homePageMenus.size(); i++){
            HomePageMenu homePageMenu = homePageMenus.get(i);

            if ((i + 1) % 2 == 1){
                responseDto.add(modelToDto(homePageMenu));
            }

        }
        for (int i = 0; i < responseDto.size(); i ++){
            if ((i + 1) % 3 == 0){
                HomePageResponseDto homePageResponseDto = responseDto.get(i);
                homePageResponseDto.setPicture(null);
            }
        }
        return responseDto;
    }

    @Override
    public List<HomePageResponseDto> notAuthenticated(){
        List<HomePageMenu> homePageMenus = homePageMenuRepository.findAll();
        List<HomePageResponseDto> responseDto = new ArrayList<>();
        for (int i = 0; i < homePageMenus.size(); i++){
            HomePageMenu homePageMenu = homePageMenus.get(i);

            if ((i + 1) % 2 == 0){
                responseDto.add(modelToDto(homePageMenu));
            }
        }
        for (int i = 0; i < responseDto.size(); i ++){
            if ((i + 1) % 3 == 0){
                HomePageResponseDto homePageResponseDto = responseDto.get(i);
                homePageResponseDto.setPicture(null);
            }
        }
        return responseDto;
    }

    private HomePageMenu dtoToModel(HomePageMenuRequestDto requestDto){
        HomePageMenu homePageMenu = new HomePageMenu();
        homePageMenu.setName(requestDto.getName());
        homePageMenu.setPicture(requestDto.getPicture());

        return homePageMenu;
    }

    private HomePageResponseDto modelToDto(HomePageMenu homePageMenu){
        HomePageResponseDto responseDto = new HomePageResponseDto();
        responseDto.setId(homePageMenu.getId());
        responseDto.setName(homePageMenu.getName());
        responseDto.setPicture(homePageMenu.getPicture());

        return responseDto;
    }
}
