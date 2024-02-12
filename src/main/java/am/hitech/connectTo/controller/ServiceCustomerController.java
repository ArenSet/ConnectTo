package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.dto.ServiceCustomerRequestDto;
import am.hitech.connectTo.service.ServiceCustomerService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-service")
public class ServiceCustomerController {

    @Autowired
    private ServiceCustomerService serviceCustomerService;

    @GetMapping("/{position}")
    public ResponseEntity<?> getByPosition(@PathVariable(value = "position") int position){
        return ResponseEntity.ok(serviceCustomerService.getByPosition(position));
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody ServiceCustomerRequestDto requestDto){
        serviceCustomerService.addNew(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        serviceCustomerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(serviceCustomerService.getAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int id,
                                    @RequestBody ServiceCustomerRequestDto requestDto) throws NotFoundException {

        serviceCustomerService.update(requestDto, id);

        return ResponseEntity.ok().build();
    }
}
