package com.wipro.propertyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.propertyservice.dt.PropertyResponse;
import com.wipro.propertyservice.entities.Property;
import com.wipro.propertyservice.service.PropertyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/createproperty")
    public Property createProperty(@RequestBody Property property) {
        return propertyService.saveProperty(property);
    }
	
	 @GetMapping("/getAll")
	  public List<Property> getAllProperties() {
	        return propertyService.getAllProperties();
	  }
	 
	 @GetMapping("/{id}")
		public PropertyResponse getPropertyById(@PathVariable Long id){
			return propertyService.getPropertyWithUser(id);
		}
	 @GetMapping("/page")
	 public Page<Property> getAllProperty(Pageable pageable)
	 {
           return propertyService.findAllPropertyPage(pageable);
     }
	 @PutMapping("/update/{id}")
	    public Property updateProperty(@PathVariable Long id, @Valid @RequestBody Property property) {
	        return propertyService.updateProperty(id,property);
	    }
	 @DeleteMapping("/deleteProperty/{id}")
		public void deleteProperty(@PathVariable Long id) {
			propertyService.deleteProperty(id);
		}

}
