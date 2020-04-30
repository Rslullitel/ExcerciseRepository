package com.prokarma.ejercitacion.ej19;


import java.util.ArrayList;
import java.util.List;

import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class CashBox {
	
	private List<Ticket> tickets;
	private DAO ticketDAO;
	
	public CashBox(DAO ticketDAO) {
		this.tickets = new ArrayList<Ticket>();
		this.ticketDAO = ticketDAO;
	}

    public Ticket generateTicket(int amount, String typePay){
        Ticket ticket = new Ticket(amount, typePay);
        saveTicket(ticket);
        return ticket;
    }

    public void saveTicket(Ticket ticket){//insert ticket into database
    	try {
			this.ticketDAO.insert(ticket);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
    }
    
    public int calculateTotal(){
        int total = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
           total += tickets.get(i).getAmount();
        }
        return total;
    }
    
    public String toString() {
    	return "$ " + calculateTotal();
    }
}
