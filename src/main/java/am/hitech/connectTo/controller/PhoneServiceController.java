package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.PhoneService;
import am.hitech.connectTo.model.dto.PhoneServiceRequestDto;
import am.hitech.connectTo.service.PhoneServiceService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone-service")
public class PhoneServiceController {

    @Autowired
    private PhoneServiceService phoneServiceService;

    @GetMapping
    public ResponseEntity<?> getPhoneService(@RequestParam String name) throws NotFoundException {
        PhoneService phoneService = phoneServiceService.getByName(name);
        return ResponseEntity.ok(phoneService);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNew(@RequestBody PhoneServiceRequestDto requestDto){
        phoneServiceService.addNew(requestDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        phoneServiceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PhoneServiceRequestDto requestDto,
                                    @PathVariable(value = "id") int id) throws NotFoundException {
        phoneServiceService.updatePhoneService(requestDto, id);

        return ResponseEntity.ok().build();
    }

}
