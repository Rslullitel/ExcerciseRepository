package com.prokarma.ejercitacion.ej19;


import java.util.ArrayList;
import java.util.List;

import com.prokarma.ejercitacion.ej19.dao.MySqlTicketDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class CashBox {
	
	private List<Ticket> tickets;
	private MySqlTicketDAO ticketDAO;
	private int ticketNumber = 1000;
	
	public CashBox(MySqlTicketDAO ticketDAO) {
		this.tickets = new ArrayList<Ticket>();
		this.ticketDAO = ticketDAO;
	}

    public Ticket generateTicket(int amount, String typePay){
        Ticket ticket = new Ticket(ticketNumber++, amount, typePay);
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
