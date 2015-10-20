package com.example.sandbox.mains;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	
	public static void main(String[] args){
		
		List<CoffeeMaker> coffeeMakers = new ArrayList<CoffeeMaker>();
		List<? extends CoffeeMaker> something = coffeeMakers;
	}
}
