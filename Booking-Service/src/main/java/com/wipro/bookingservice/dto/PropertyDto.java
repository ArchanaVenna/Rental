package com.wipro.bookingservice.dto;

import lombok.Data;

@Data
public class PropertyDto {
	private Long id;
    private String name;
    private String location;
    private double price;
    private String facilities;
}
