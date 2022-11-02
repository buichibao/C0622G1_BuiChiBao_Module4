package com.example.controller;

import com.example.model.SmartPhone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartPhone")
public class SmartPhoneController {

    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping
    public ResponseEntity<List<SmartPhone>> findAllBlog(){
        List<SmartPhone> smartPhones = (List<SmartPhone>) iSmartphoneService.findAll();
        if (smartPhones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> addPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        return new ModelAndView("list","phones",  iSmartphoneService.findById(id).get());
    }
    @PatchMapping("/saveEditing")
    public ResponseEntity<SmartPhone> updatePhone(@RequestBody SmartPhone phone){
        return new ResponseEntity<>(iSmartphoneService.save(phone),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SmartPhone> deletePhone(@PathVariable Long id) {
        Optional<SmartPhone> phoneOptional = iSmartphoneService.findById(id);
        if (phoneOptional.isPresent()) {
            iSmartphoneService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
