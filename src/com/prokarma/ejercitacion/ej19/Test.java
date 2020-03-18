package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	volatile static boolean stop = true;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		
        int cantClients = clientsRandom();
        BlockingQueue<Order> orders = new ArrayBlockingQueue<Order>(1024);
        BlockingQueue<Client> clients = new ArrayBlockingQueue<Client>(1024);

        ClientGenerator generator = new ClientGenerator(clients, cantClients);
        Cashier cashier = new Cashier(orders, clients, generateStocks(), generateSandwiches(), cantClients);
        Preparer preparer = new Preparer(orders, cantClients);

        generator.start();
    	cashier.start();
    	preparer.start();

	}	

    private static int clientsRandom() {
        return (int)(Math.random()*(40-1+1)+1);
    }


    public static Map<Integer, Stock> generateStocks(){
        Map<Integer, Stock> stocks = new TreeMap<Integer, Stock>();
        stocks.put(1, new Stock(1, 10));//0 posicion = get(i)
        stocks.put(2, new Stock(2, 10));//1
        stocks.put(3, new Stock(3, 7));//2
        stocks.put(4, new Stock(4, 5));//3
        stocks.put(5, new Stock(5, 5));//4
        return stocks;
    }

    public static Map<Integer, Sandwich> generateSandwiches(){
        Map<Integer, Sandwich> sandwiches = new TreeMap<Integer, Sandwich>();
        sandwiches.put(1, new Sandwich(1, 150, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("rawHam"), new Ingredient("danbo")))));
        sandwiches.put(2, new Sandwich(2, 200, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("rawHam"), new Ingredient("cheddar")))));
        sandwiches.put(3, new Sandwich(3, 170, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("cookedHam"), new Ingredient("cheddar")))));
        sandwiches.put(4, new Sandwich(4, 120, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("cookedHam"), new Ingredient("danbo")))));
        sandwiches.put(5, new Sandwich(5, 100, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("salami"), new Ingredient("danbo")))));
        return sandwiches;
    }
	
}
