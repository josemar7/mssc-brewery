package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.client.BreweryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/users")
@RestController
public class BeerController {

    private final BreweryClient breweryClient;

    public BeerController(BreweryClient breweryClient) {
        this.breweryClient = breweryClient;
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<Object> getUser(@PathVariable("userId") String userId){

        return new ResponseEntity<>(breweryClient.getUser(Integer.valueOf(userId)), HttpStatus.OK);
    }

}
