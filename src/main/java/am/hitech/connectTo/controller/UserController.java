package am.hitech.connectTo.controller;

import am.hitech.connectTo.service.InetInfoService;
import am.hitech.connectTo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/account")
    public ResponseEntity<?> account(){
        return null;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Void> signIn(){
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

    @PatchMapping("/account-type")
    public ResponseEntity<?> accountType(){
        return null;
    }
}
