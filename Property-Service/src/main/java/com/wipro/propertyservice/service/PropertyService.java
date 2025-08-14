package com.wipro.propertyservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.propertyservice.dt.PropertyResponse;
import com.wipro.propertyservice.entities.Property;

import jakarta.validation.Valid;

public interface PropertyService {

	Property saveProperty(Property property);

	List<Property> getAllProperties();



	
	

	 PropertyResponse getPropertyWithUser(Long id);

	 Property updateProperty(Long id, @Valid Property property);

	 void deleteProperty(Long id);

	 Page<Property> findAllPropertyPage(Pageable pageable);
		

	

}
