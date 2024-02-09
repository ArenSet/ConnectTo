package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.HomePageMenu;
import am.hitech.connectTo.model.dto.HomePageMenuRequestDto;
import am.hitech.connectTo.service.HomePageMenuService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home-page-menu")
public class HomePageMenuController {

    @Autowired
    private HomePageMenuService homePageMenuService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable(value = "name") String name){

        HomePageMenu homePageMenu = homePageMenuService.getByName(name);
        return ResponseEntity.ok(homePageMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        homePageMenuService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody HomePageMenuRequestDto requestDto){
        homePageMenuService.addNew(requestDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int id,
                                    @RequestBody HomePageMenuRequestDto requestDto) throws NotFoundException {

        homePageMenuService.updateHomePageMenu(requestDto, id);

        return ResponseEntity.ok().build();
    }
}
