package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.mts.Exception.TicketBookingException;
import com.cg.mts.Repository.TicketBookingRepository;
import com.cg.mts.entities.Activity;
import com.cg.mts.entities.TicketBooking;

@Service
public class TicketBookingService {
	
	@Autowired
	TicketBookingRepository repository;
	public TicketBooking  addTicketBooking(TicketBooking TicketBooking) throws TicketBookingException
	{
		Optional<TicketBooking> findById = repository.findById(TicketBooking.getTicketBookingId());
		if(!findById.isPresent()) {
			return repository.save(TicketBooking);
		}
		else
			throw new TicketBookingException("TicketBooking already present");
	}
	
	public List<TicketBooking> getAllTicketBooking() throws TicketBookingException
	{
		if(repository.findAll().size()==0)
			throw new TicketBookingException(" list is blank");
		else
			return repository.findAll();
	}

	public TicketBooking updateTicketBooking(TicketBooking ticketBooking)
	{
		TicketBooking tb=repository.findById(ticketBooking.getTicketBookingId()).orElse(null);
		tb.setTicketBookingId(ticketBooking.getTicketBookingId());
		tb.setBill(ticketBooking.getBill());
		tb.setActivity(ticketBooking.getActivity());
		tb.setCustomer(ticketBooking.getCustomer());
		tb.setDateTime(ticketBooking.getDateTime());
		return repository.save(tb);
	}

}
