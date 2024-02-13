package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.AreaDeals;
import am.hitech.connectTo.model.Country;
import am.hitech.connectTo.model.State;
import am.hitech.connectTo.service.AreaDealsService;
import am.hitech.connectTo.service.CountryService;
import am.hitech.connectTo.service.StateService;
import am.hitech.connectTo.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{country}")
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
    public ResponseEntity<?> getByCountry(@PathVariable(value = "country") String country){
        Country country1 = countryService.getByCountry(country);

        return ResponseEntity.ok(stateService.findByCountryId(country1.getId()));
    }

    @GetMapping("/{state}")
    public ResponseEntity<?> getByState(@PathVariable(value = "state") String state,
                                        @PathVariable(value = "country") String country){
        State state1 = stateService.findByState(state);

        return ResponseEntity.ok(zipCodeService.findByStateId(state1.getId()));
    }

    @PostMapping("/{state}/{zipCode}/{service}/{email}")
    public ResponseEntity<?> addNewArea(@PathVariable(value = "country") String country,
                                        @PathVariable(value = "state") String state,
                                        @PathVariable(value = "zipCode") String zopCode,
                                        @PathVariable(value = "service") String service,
                                        @PathVariable(value = "email") String email){
        areaDealsService.addNewDeal(country, state, zopCode, service, email);
        return ResponseEntity.ok().build();
    }
}
