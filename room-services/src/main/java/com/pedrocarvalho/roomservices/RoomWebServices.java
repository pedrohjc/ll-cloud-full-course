package com.pedrocarvalho.roomservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebServices {

    private final RoomRepository repository;

    public RoomWebServices(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Room> getAllReservations(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Room getReservation(@PathVariable("id")long id){
        return this.repository.findById(id).get();
    }
}
