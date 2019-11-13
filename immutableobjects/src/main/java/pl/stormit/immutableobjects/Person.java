package pl.stormit.immutableobjects;

import java.util.Collections;
import java.util.List;

public final class Person {
	private final String name;
	private final int age;
	private final List<Pet> pets;

	private Person(String name, int age, List<Pet> pets) {
		this.name = name;
		this.age = age;
		this.pets = Collections.unmodifiableList(pets);
	}

	public static Person makeInstance(String name, int age, List<Pet> pets){
		return new Person(name, age, pets);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<Pet> getPets() {
		return pets;
	}
}
