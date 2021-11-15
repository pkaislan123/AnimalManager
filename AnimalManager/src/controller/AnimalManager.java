package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import models.Sheep;
import models.Wolf;

@SuppressWarnings("unchecked")
public class AnimalManager {

	Map animals = new HashMap();
	Random random = new Random();

	String sheeps_name[] = { "Margaret", "Gina", "Olive", "Max", "Partner", "Jonh", "Peter", "Charlee", "Guy", "Lady" };

	public void start() {
		Wolf wolf = new Wolf("Wolf"); // instancia um novo objeto da classe Wolf com nome, Wolf
		ArrayList sheeps = new ArrayList<Sheep>(10); // cria uma lista de sheeps

		for (int i = 0; i < 10; i++) {
			int indice_random = random.nextInt((9 - 0) + 1) + 0;
			Sheep new_sheep = new Sheep(sheeps_name[indice_random] + "_" + i);
			sheeps.add(new_sheep);
		}

		animals.put(wolf.getName(), wolf); // coloca o objeto wolf no hashmap usando o atributo nome como chave
		animals.put("Sheeps", sheeps); // coloca a lista de ovelhas no hashmap usando a palavra "Sheep como chave
	}

	public void newDay() {
		ArrayList<Sheep> sheeps = (ArrayList<Sheep>) animals.get("Sheeps");
		Wolf wolf = (Wolf) animals.get("Wolf");
		wolf.update(sheeps);

		ArrayList<Sheep> news_lamb = new ArrayList<>();

		for (Sheep sheep : sheeps) {
			Sheep lamb = sheep.update(sheeps);
			if (lamb != null)
				news_lamb.add(lamb);
		}

		sheeps.addAll(news_lamb);
	}

	public void printState() {

        int counter = 0;
        int counter3 = 0;
        
        ArrayList<Sheep> list_of_sheeps = (ArrayList<Sheep>) animals.get("Sheeps");
        
        
        
        Wolf wolf = (Wolf) animals.get("Wolf");
        
        for(int i = 0; i < wolf.getEaten(); i++) {
            counter3++;
        }
        System.out.print("No momento há " + list_of_sheeps.size() + " ovelhas no mundo, são elas:\n");
        for(Sheep sheep : list_of_sheeps) {
        	
        	String sex = "";
        	if(sheep.isFemale())
        		sex = "Femea";
        	else
        		sex = "Macho";
        	
        	String estado_civil = "";
        	if(sheep.getPartner() != null && !sheep.getPartner().isDead()) 
        		estado_civil = "Em comunhão com " + sheep.getPartner().getName();
        	else
        		estado_civil = "Solteira";
        	
        	System.out.println("Nome: " + sheep.getName() + " Idade: " + sheep.getAge() + " Num Filhos: " + sheep.getLambCount() + " Sexo: " + sex + " Estado Civil: " + estado_civil );
        }
      
        
        System.out.println("O lobo comeu " + counter3 + " ovelhas\n\n\n");
        
    }

}
