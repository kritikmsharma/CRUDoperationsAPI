package com.example.demo.hotels;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.demo.hotels.hotels;
import com.example.demo.hotels.RecordNotFoundException;
import com.example.demo.hotels.hotelservice;
 
@RestController
@RequestMapping("/hotels")
public class hotelcontroller 
{
    @Autowired
    hotelservice service;
 
    @GetMapping
    public ResponseEntity<List<hotels>> getAllhotels() {
        List<hotels> list = service.getAllhotels();
 
        return new ResponseEntity<List<hotels>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<hotels> gethotelById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        hotels entity = service.gethotelById(id);
 
        return new ResponseEntity<hotels>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<hotels> createhotel(@Valid @RequestBody hotels hotel)
                                                    throws RecordNotFoundException {
        hotels updated = service.createhotel(hotel);
        return new ResponseEntity<hotels>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<hotels> updatehotel(@PathVariable(value = "id") Long id ,@Valid @RequestBody hotels hotel)
            throws RecordNotFoundException {
    	hotels updated = service.updatehotel(id, hotel);
    	return new ResponseEntity<hotels>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deletehotelById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        service.deletehotelById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}