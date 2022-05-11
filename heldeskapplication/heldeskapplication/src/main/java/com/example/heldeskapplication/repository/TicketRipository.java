package com.example.heldeskapplication.repository;

import com.example.heldeskapplication.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRipository extends JpaRepository<TicketModel,Long> {

}
