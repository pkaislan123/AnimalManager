package models;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class Animal {
	private String name;

	Animal(String name) {
		this.name = name;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
