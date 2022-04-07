package com.example.qr_receipt.controller;


import com.example.qr_receipt.exception.UserDoesNotExistException;
import com.example.qr_receipt.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;


    @GetMapping("/login/{userName}conf{password}")
    public RedirectView fetchAppUserByUsernameAndPassword
            (@PathVariable ("userName") String username,@PathVariable ("password") String password)
            throws UserDoesNotExistException {
        new ResponseEntity<>(loginService.fetchAppUserByUsernameAndPassword(username, password), HttpStatus.OK);
        return new RedirectView("/homePage");
    }

    @DeleteMapping("/user/{id}")
    public String deleteAppUser(@PathVariable ("id") Long userId ){
        loginService.deleteAppUserById(userId);
        return "Deleted Successfully";
    }

}
