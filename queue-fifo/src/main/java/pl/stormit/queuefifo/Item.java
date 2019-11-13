package pl.stormit.queuefifo;

public class Item implements Comparable<Item> {

	private String name;

	private int value;

	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public int compareTo(Item o) {
		return Integer.compare(value, o.value);
	}

	@Override
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", value=" + value +
				'}';
	}
}
