package com.join.database.controller;

import com.join.database.entity.Address;
import com.join.database.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> findAllAddress(){
        return addressService.findAddresses();
    }
    @GetMapping("/address/{id}")
    public Address findAddressById(@PathVariable int id){
        return addressService.findById(id);
    }
    @PutMapping("/address")
    public Address updateAddress(@RequestBody Address address){
        return addressService.update(address);
    }
    @DeleteMapping("/address/{id}")
    public String deleteAddress(@PathVariable int id){
        return addressService.deleteById(id);
    }
}
