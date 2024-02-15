package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.AreaDeals;
import am.hitech.connectTo.model.Country;
import am.hitech.connectTo.model.State;
import am.hitech.connectTo.model.ZipCode;
import am.hitech.connectTo.service.AreaDealsService;
import am.hitech.connectTo.service.CountryService;
import am.hitech.connectTo.service.StateService;
import am.hitech.connectTo.service.ZipCodeService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @Autowired
    private ZipCodeService zipCodeService;

    @Autowired
    private AreaDealsService areaDealsService;

    @GetMapping
    public ResponseEntity<List<Country>> countries(){
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/state")
    public ResponseEntity<List<State>> states(@RequestParam int countryId){
        return ResponseEntity.ok(stateService.findByCountryId(countryId));
    }

    @GetMapping("/zip-code")
    public ResponseEntity<List<ZipCode>> zipCodes(@RequestParam int stateId,
                                                  @RequestParam(required = false) String zipCode){
        return ResponseEntity.ok(zipCodeService.findByStateId(stateId, zipCode));
    }

    @PostMapping
    public ResponseEntity<?> addNewArea(@RequestParam int countryId,
                                        @RequestParam int stateId,
                                        @RequestParam int zipCodeId,
                                        @RequestParam int serviceId,
                                        @RequestParam String email) throws NotFoundException {
        areaDealsService.addNewDeal(countryId, stateId, zipCodeId, serviceId, email);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id) throws NotFoundException {
        areaDealsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
