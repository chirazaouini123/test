package com.example.heldeskapplication.service;

import com.example.heldeskapplication.exception.ResourcesNotfoundException;
import com.example.heldeskapplication.model.TicketModel;
import com.example.heldeskapplication.repository.TicketRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TicketServiceImpl implements TicketServiceInterface{
    private TicketRipository ticketRepository;
    @Autowired
    public TicketServiceImpl(TicketRipository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketModel> findAllTickets() {
        return ticketRepository.findAll();
    }
    @Override
    public TicketModel AddTicket( TicketModel ticket){
        return ticketRepository.save(ticket);
    }
    @Override
    public TicketModel findTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Tickets doesn't exist with id:"+ id));


    }
    @Override
    public TicketModel updateTicket(Long id,  TicketModel ticketDetails){
        TicketModel ticket1=findTicketById(id);
        ticket1.setTitle(ticketDetails.getTitle());
        ticket1.setSubject(ticketDetails.getSubject());
        ticket1.setPriority(ticketDetails.getPriority());
        ticket1.setCategory(ticketDetails.getCategory());
        ticket1.setStatus(ticketDetails.getStatus());

        return  ticketRepository.save(ticket1);

    }

    @Override
    public Map<String,Boolean> deleteTicket(Long id){
        TicketModel ticket1=findTicketById(id);
        ticketRepository.delete(ticket1);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
    public String getStatusTitle(Long id){
        TicketModel ticketModel=findTicketById(id);
        return  ticketModel.getStatus();


    }

    @Override
    public String getCategoryTitle(Long id) {
        TicketModel ticketModel=findTicketById(id);
        return ticketModel.getCategory();
    }

    @Override
    public void updateStatus(Long id, String status) {
        TicketModel ticketModel=findTicketById(id);
        ticketModel.setStatus(status);
    }


}
