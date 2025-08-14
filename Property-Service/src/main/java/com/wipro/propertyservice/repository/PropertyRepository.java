package com.wipro.propertyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.propertyservice.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	Property getPropertyById(Long id);

}
