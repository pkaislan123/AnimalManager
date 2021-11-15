package view;

import controller.AnimalManager;

public class Main {

	public static void main(String[] args) {
        try{
            AnimalManager am = new AnimalManager();
            am.start();
            System.out.println("Programa Iniciado!");
            
           for(int i = 0; i < 6; i++) {
                am.printState();
                am.newDay();
            }
           am.printState();

           
         
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

	
}
