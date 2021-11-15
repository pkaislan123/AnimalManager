
package models;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Wolf extends Animal {
	private int eaten = 0;

	public Wolf(String name) {
		super(name);
	}

	public void update(ArrayList<Sheep> sheep) {
		int index = sheep.size() - 1;
		sheep.get(index);
		kill((Sheep) sheep.get(index));
		setEaten(getEaten() + 1);
		sheep.remove(index);
	}

	void kill(Sheep sheep) {
		sheep.dead();
	}

	public int getEaten() {
		return eaten;
	}

	public void setEaten(int eaten) {
		this.eaten = eaten;
	}
}
