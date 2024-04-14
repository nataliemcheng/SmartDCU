package com.example.grpee417.Customer2;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer6")
public class Customer2 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

	@JsonProperty("campus")
    @Column(name = "campus")
    private String campus;
	
	@JsonProperty("mobileNumber")
    @Column(name = "phone_number")
    private String mobileNumber;

	@JsonProperty("date")
    @Column(name = "date_time")
    private String date;

	@JsonProperty("roomNumber")
    @Column(name = "room_number")
    private String roomNumber;

	@JsonProperty("occupantName")
    @Column(name = "occupant_name")
    private String occupantName;
	
	@JsonProperty("purpose")
    @Column(name = "purpose")
    private String purpose;
	
	@JsonProperty("duration")
    @Column(name = "duration") 
    private Integer duration;

 
}
