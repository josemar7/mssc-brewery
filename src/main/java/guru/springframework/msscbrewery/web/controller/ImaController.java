package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.client.TokenClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ima")
@RestController
public class ImaController {

    private final TokenClient tokenClient;

    public ImaController(TokenClient tokenClient) {
        this.tokenClient = tokenClient;
    }

    @GetMapping({"/token"})
    public ResponseEntity<Object> getUser(){

        return new ResponseEntity<>(tokenClient.getToken(), HttpStatus.OK);
    }
}
