package com.wipro.propertyservice.dt;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponse {
	private Long id;
    private String name;
	
	
	private String location;
	private double price;
	
	private String facilities;
	
	 private UserDto userId; 

}
