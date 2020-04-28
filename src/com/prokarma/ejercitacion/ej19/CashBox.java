package com.prokarma.ejercitacion.ej19;


import com.prokarma.ejercitacion.ej19.bo.FacadeDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class CashBox {
	
	private FacadeDAO facade;
	
	public CashBox(FacadeDAO facade) {
		this.facade = facade;
	}

    public Ticket generateTicket(int amount, String typePay){
        Ticket ticket = new Ticket(amount, typePay);
        saveTicket(ticket);
        return ticket;
    }

    public void saveTicket(Ticket ticket){//insert ticket into database
        try {
			this.facade.addTicket(ticket);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
    }
    
  /*  public int calculateTotal(){
        int total = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
           total += tickets.get(i).getAmount();
        }
        return total;
    }*/
    
   /* public String toString() {
    	return "$ " + calculateTotal();
    }*/
}
