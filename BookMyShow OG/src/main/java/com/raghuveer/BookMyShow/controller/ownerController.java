package com.raghuveer.BookMyShow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghuveer.BookMyShow.entity.owner;
import com.raghuveer.BookMyShow.service.ownerService;

@RestController
@RequestMapping("/bms/owner")
public class ownerController {
    
    @Autowired
    ownerService ownerService;

    @PostMapping
    public owner saveOwner(@RequestBody owner owenrs){
        return ownerService.save(owenrs);
    }

    @GetMapping
    public Iterable<owner> getAllOwners(){
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<owner> getOwnerById(@PathVariable("id") Long id){
        return ownerService.findById(id);
    }

    @PutMapping("/{id}")
    public owner updateowner(@PathVariable("id") Long id, @RequestBody owner owners){
        owners.setMovieId(id);
        return ownerService.save(owners);
    }

    @DeleteMapping("/{id}")
    public void deleteowner (@PathVariable("id") Long id){
        ownerService.deleteById(id);
    }
}