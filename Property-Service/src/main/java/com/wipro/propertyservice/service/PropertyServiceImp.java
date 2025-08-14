package com.wipro.propertyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.propertyservice.client.UserClient;
import com.wipro.propertyservice.dt.PropertyResponse;
import com.wipro.propertyservice.dt.UserDto;
import com.wipro.propertyservice.entities.Property;
import com.wipro.propertyservice.repository.PropertyRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImp implements PropertyService {
	@Autowired
	private PropertyRepository propertyRepo;
	private final UserClient userClient;

	@Override
	public Property saveProperty(Property property) {
		return propertyRepo.save(property);
	}

	@Override
	public List<Property> getAllProperties() {
		return propertyRepo.findAll();
	}

	

	

	@Override
	public Property updateProperty(Long id,  Property property) {
		Property place =propertyRepo.findById(id)
			    .orElseThrow(() -> new RuntimeException("Property not found with id " + id));
        place.setName(property.getName());
        place.setLocation(property.getLocation());
        place.setPrice(property.getPrice());
        place.setFacilities(property.getFacilities());
        return propertyRepo.save(place);
		
	}

	@Override
	public PropertyResponse getPropertyWithUser(Long id) {
		
//		return propertyRepo.getPropertyById(id);
		Property property = propertyRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Property not found"));

	        UserDto user = null;
	        if (property.getUserId() != null) {
	            user = userClient.getUserById(property.getUserId());
	        }

	        return new PropertyResponse(
	            property.getId(),
	            property.getName(),
	            property.getLocation(),
	            property.getPrice(),
	            property.getFacilities(),
	            user);
	}

	@Override
	public void deleteProperty(Long id) {
		propertyRepo.deleteById(id);
		
	}

	@Override
	public Page<Property> findAllPropertyPage(Pageable pageable) {
		
		return propertyRepo.findAll(pageable);
	}
    
	


	
	
	

}
