package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.mts.Exception.TicketBookingException;
import com.cg.mts.Repository.TicketBookingRepository;
import com.cg.mts.entities.TicketBooking;

@Service
public class TicketBookingService {
	
	@Autowired
	TicketBookingRepository repository;
	@Autowired
	TicketBookingService service;
	public TicketBooking  insertTicketBooking(TicketBooking TicketBooking) throws TicketBookingException
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
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking, int id) {
		TicketBooking t = repository.findById(ticketBooking.getTicketBookingId()).orElse(null);
		t.setTicketBookingId(t.getTicketBookingId());
		t.setDateTime(ticketBooking.getDateTime());
		t.setActivity(ticketBooking.getActivity());
		t.setBill(ticketBooking.getBill());
		t.setCustomer(ticketBooking.getCustomer());
		return repository.save(t);
	}
	
	public String deleteTicket(@PathVariable int id)
	{
		TicketBooking tb=repository.findById(id).orElse(null);
	    repository.delete(tb);
	    return "Ticket deleted";
		
	}
}
