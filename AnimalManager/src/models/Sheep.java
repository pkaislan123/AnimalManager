package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class Sheep extends Animal {

	private int age = 0;
	private boolean alone = true;
	private int lambCount = 0;
	private boolean dead = false;
	private Sheep partner = null;
	private boolean female;
    Random random = new Random();

	public Sheep(String name) {
		super(name);
		
		int indice_sex = random.nextInt(2);
		if(indice_sex == 0)
			this.female = true;
		else
			this.female = false;

	}


	public Sheep makeLamb(ArrayList<Sheep> sheeps, Sheep mom) {
		
		this.lambCount++;
		
		return new Sheep("Lamb " + sheeps.size() + " son of " + mom.getName());
		
	}

	public Sheep update(ArrayList<Sheep> sheeps) {
		Sheep lamb = null;
		if (!this.isDead()) {
			if (this.isAlone()) {

				// se a ovelha esta sozinha, procurar um parceiro
				for (Sheep sheep : sheeps) {
					if (sheep.isAlone()) {
						
						
						if(this.female && !sheep.female || !this.female && sheep.female) {
							sheep.setAlone(false);
							sheep.setPartner(this);
							sheep.setAge(sheep.getAge() + 1);

							this.setPartner(sheep);
							this.setAlone(false);
							this.setAge(this.getAge() + 1);
							break;
						}
						
						
						
						
					}
				}

			} else {
				if (this.partner != null && !this.partner.isDead()) {
					if(this.female) {
					 lamb = this.makeLamb(sheeps, this);
					 
					 this.getPartner().setLambCount(this.getPartner().getLambCount() + 1);
					 
					 this.setAge(this.getAge() + 1);

					 if (this.lambCount > 3) {
						// ovelha morre, deixa o parceiro sozinho
						this.setDead(true);
						this.getPartner().setPartner(null);
						this.setPartner(null);

					}
					}else {
						if(this.getAge() > 4) {
							this.setDead(true);
							if(!this.isAlone()) {
								if(this.getPartner() != null) {
									if(!this.getPartner().isDead()) {
										this.getPartner().setAlone(true);
										this.getPartner().setPartner(null);
									}
								}
							}
						}
					}
					
				}
			}

		}
		return lamb;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLambCount() {
		return lambCount;
	}

	public void dead() {
		this.dead = true;
	}

	boolean isAlone() {
		return alone;
	}

	public void setLambCount(int lambCount) {
		this.lambCount = lambCount;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void setAlone(boolean alone) {
		this.alone = alone;
	}

	public Sheep getPartner() {
		return partner;
	}

	public void setPartner(Sheep partner) {
		this.partner = partner;
	}


	public boolean isFemale() {
		return female;
	}


	public void setFemale(boolean female) {
		this.female = female;
	}

	
	
}
