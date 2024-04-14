package com.example.grpee417.Customer;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer5")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

	@JsonProperty("name")
    @Column(name = "customer_name")
    private String name;
	
	@JsonProperty("campus")
    @Column(name = "campus")
    private String campus;

	@JsonProperty("mobileNumber")
    @Column(name = "phone_number")
    private String mobileNumber;

	@JsonProperty("date")
    @Column(name = "date_time")
    private String date;

	@JsonProperty("duration")
    @Column(name = "duration") 
    private Integer duration;

	@JsonProperty("vehiclePlate")
    @Column(name = "vehicle_plate")
    private String vehiclePlate;

	@JsonProperty("vehicleType")
    @Column(name = "vehicle_type")
    private String vehicleType;

 
}