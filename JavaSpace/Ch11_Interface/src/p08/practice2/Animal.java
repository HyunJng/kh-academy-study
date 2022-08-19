package p08.practice2;

public abstract class Animal {
	private double weight;

	public Animal() {
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract String sound();

}
