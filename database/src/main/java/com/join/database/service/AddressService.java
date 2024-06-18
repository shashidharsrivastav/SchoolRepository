package com.join.database.service;

import com.join.database.entity.Address;
import com.join.database.repository.AddressRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public List<Address> findAddresses() {
        return repository.findAll();
    }

    public Address update(Address address) {
        Address add= repository.findById(address.getId()).orElse(null);
        if (add != null) {
            add.setMothersName(address.getMothersName());
            add.setFathersName(address.getFathersName());
            add.setVillage(address.getVillage());
            add.setPost(address.getPost());
            add.setDistrict(address.getDistrict());
            add.setMobileNumber(address.getMobileNumber());
            add.setZipcode(address.getZipcode());
        }
        return repository.save(add);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "Delete Successfully:"+id;
    }

    public Address findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
