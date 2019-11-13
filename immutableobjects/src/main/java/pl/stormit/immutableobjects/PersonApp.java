package pl.stormit.immutableobjects;

import java.util.ArrayList;

public class PersonApp {
	public static void main(String[] args) {
		Person person = Person.makeInstance("Tomek", 100, new ArrayList<>());

		person.getPets().add(new Pet("Kot"));

	}
}
