package am.hitech.connectTo.controller;

import am.hitech.connectTo.model.InetInfo;
import am.hitech.connectTo.service.InetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home-page")
public class HomePageController {

    @Autowired
    private InetInfoService inetInfoService;

    @GetMapping("/account")
    public ResponseEntity<?> account(){
        return null;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Void> signIn(){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(){
        return null;
    }

    @GetMapping("/account-overview")
    public ResponseEntity<?> accountOverview(){
        return null;
    }

    @PatchMapping("/manage-profile")
    public ResponseEntity<?> manageProfile(){
        return null;
    }

    @PostMapping("/pay-without-sign-in")
    public ResponseEntity<?> payWithoutSignIn(){
        return null;
    }

    @GetMapping("/view-and-pay")
    public ResponseEntity<?> viewAndPay(){
        return null;
    }

    @PatchMapping("/account-type")
    public ResponseEntity<?> accountType(){
        return null;
    }

    @GetMapping("/help")
    public ResponseEntity<?> help(){
        return null;
    }

    @GetMapping("/shop")
    public ResponseEntity<?> shop(){
        return null;
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(){
        return null;
    }

    @GetMapping("/menu")
    public ResponseEntity<?> menu(){
        return null;
    }

    @PostMapping("/back-to-home-page")
    public ResponseEntity<?> backToHomePage(){
        return null;
    }

    @GetMapping("/go-to-tv")
    public ResponseEntity<?> goToTv(){
        return null;
    }

    @GetMapping("/get-mobile-service")
    public ResponseEntity<?> getMobileService(){
        return null;
    }

    @PostMapping("/turn-on-security-alarm")
    public ResponseEntity<?> turnOnSecurityAlarm(){
        return null;
    }

    @GetMapping("/get-deals")
    public ResponseEntity<?> getDeals(){
        return null;
    }

    @GetMapping("/get-bundles")
    public ResponseEntity<?> getBundles(){
        return null;
    }

    @GetMapping("/get-quotes")
    public ResponseEntity<?> getQuotes(){
        return null;
    }

    @GetMapping("/inet-10mb")
    public ResponseEntity<?> inetUpTo10Mb(){
        InetInfo inetInfo = inetInfoService.getInfo("inet_10mb_info");
        return ResponseEntity.ok(inetInfo);
    }

    @GetMapping("/phone-service")
    public ResponseEntity<?> phoneService(){
        InetInfo inetInfo = inetInfoService.getInfo("phone_service_info");
        return ResponseEntity.ok(inetInfo);
    }

    @GetMapping("/inet-100mb")
    public ResponseEntity<?> inetUpTo100Mb(){
        InetInfo inetInfo = inetInfoService.getInfo("inet_100mb_info");
        return ResponseEntity.ok(inetInfo);
    }

    /*@GetMapping("/iphone")
    public ResponseEntity<?> iphone(){
        return null;
    }

    @GetMapping("/new-phones")
    public ResponseEntity<?> newPhones(){
        return null;
    }*/

    @GetMapping("/view-all-deals")
    public ResponseEntity<?> viewAllDeals(){
        return null;
    }

    @GetMapping("/check-availability")
    public ResponseEntity<?> checkAvailability(){
        return null;
    }

    @GetMapping("/add-a-friend")
    public ResponseEntity<?> addAFriend(){
        return null;
    }

    @GetMapping("/apply-all-included-package")
    public ResponseEntity<?> applyAllIncludedPackage(){
        return null;
    }

    @PostMapping("/submit-address")
    public ResponseEntity<?> submitAddress(){
        return null;
    }

    @PostMapping("/start-chat")
    public ResponseEntity<?> startChat(){
        return null;
    }

    @PostMapping("/go-to-map")
    public ResponseEntity<?> goToMap(){
        return null;
    }

    @GetMapping("/call")
    public ResponseEntity<?> call(){
        return null;
    }

    @GetMapping("/email-write")
    public ResponseEntity<?> emailWrite(){
        return null;
    }

    @GetMapping("/order-status")
    public ResponseEntity<?> orderStatus(){
        return null;
    }

    @GetMapping("/basket")
    public ResponseEntity<?> basket(){
        return null;
    }

    @GetMapping("/go-to-business")
    public ResponseEntity<?> goToBusiness(){
        return null;
    }
}
