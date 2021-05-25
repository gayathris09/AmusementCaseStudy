package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cg.mts.Exception.TicketBookingException;
import com.cg.mts.Service.TicketBookingService;
import com.cg.mts.entities.Activity;
import com.cg.mts.entities.TicketBooking;

@RestController
@RequestMapping("/ticketbooking")
public class TicketBookingController {
	
	@Autowired
	TicketBookingService service;
	
	@GetMapping("/all")
	public List<TicketBooking> getAllTicketBooking() throws TicketBookingException{
		return service.getAllTicketBooking();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public TicketBooking saveCustomer(@RequestBody TicketBooking TicketBooking) throws TicketBookingException{
		return service.addTicketBooking(TicketBooking);
	}
	@PutMapping("/updateTicket")
	public TicketBooking updateTicket(@RequestBody TicketBooking TicketBooking )
	{
		return service.updateTicketBooking(TicketBooking);
	}


}
