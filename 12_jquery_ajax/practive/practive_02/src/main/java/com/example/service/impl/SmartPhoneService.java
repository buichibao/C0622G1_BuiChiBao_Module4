package com.example.service.impl;

import com.example.model.SmartPhone;
import com.example.repository.ISmartPhoneRepository;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SmartPhoneService implements ISmartphoneService {

    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;
    @Override
    public List<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
       iSmartPhoneRepository.deleteById(id);
    }
}
