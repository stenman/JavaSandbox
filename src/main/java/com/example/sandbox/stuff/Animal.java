package com.example.sandbox.stuff;

public abstract class Animal {

	private String name;
	private double height;
	private int weight;
	private String favouriteFood;
	private double speed;
	private String sound;

	public Animal() {
		System.out.println("LOL!");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0) {
			this.height = height;
		} else {
			System.out.println("Height must be larger than 0.");
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Weight must be larger than 0.");
		}
	}

	public String getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

}
