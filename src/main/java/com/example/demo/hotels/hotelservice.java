
package com.example.demo.hotels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotels.hotels;
import com.example.demo.hotels.RecordNotFoundException;
import com.example.demo.hotels.hotelrepository;

@Service
public class hotelservice {

    @Autowired
    hotelrepository repository;

    public List<hotels> getAllhotels()
    {
        List<hotels> hotelslist = repository.findAll();

        if(hotelslist.size() > 0) {
            return hotelslist;
        } else {
        	return new ArrayList<hotels>();
        }
    }
    
    public hotels gethotelById(Long id) throws RecordNotFoundException
    {
        Optional<hotels> hotel = repository.findById(id);

        if(hotel.isPresent()) {
            return hotel.get();
        } else {
            throw new RecordNotFoundException("No hotel record exist for given id");
        }
    }

    public hotels createhotel(hotels entity) throws RecordNotFoundException
    {
        return repository.save(entity);
    }
    
    public hotels updatehotel(Long id, hotels entityupdate) throws RecordNotFoundException
    {
    	Optional<hotels> checkhotel = repository.findById(entityupdate.getId());
    	if(checkhotel.isPresent()) 
        {
            hotels newEntity = checkhotel.get();
            newEntity.setId(entityupdate.getId());
            newEntity.setName(entityupdate.getName());
            newEntity.setprice(entityupdate.getprice());
            newEntity.setInventory(entityupdate.getInventory());
            newEntity = repository.save(newEntity);
            return newEntity;
        }
    	else {
    		 throw new RecordNotFoundException("No hotel record exist to update for given id");
    	}  	
    }

    public void deletehotelById(Long id) throws RecordNotFoundException
    {
        Optional<hotels> hotel = repository.findById(id);

        if(hotel.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No hotel record exist for given id");
        }
    }
}
