package com.pedrocarvalho.guestservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {
    private final GuestRepository repository;

    public GuestWebServices(GuestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Guest> getAllGuests(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id){
        return this.repository.findById(id).get();
    }

}
