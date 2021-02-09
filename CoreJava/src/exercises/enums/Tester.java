package exercises.enums;

import java.util.EnumSet;

public class Tester {
	
	public static void main(String[] args) {
		
		
		
		order("Wait");
		
		System.out.println("All enum values:\n");
		for(Order t : Order.values()) {
			System.out.println(t);
		}
		
		System.out.println("\nEnumSet values:\n");
		EnumSet<Order> range = EnumSet.range(Order.Wait, Order.Walk);
		for(Order t: range) {
			System.out.println(t);
		}
		
		System.out.println("\nEnum with constructor and fields:\n");
		for(State t : State.values()) {
			System.out.println(t.stateId + ", " + t.desc);
		}
		
		System.out.println("\n\t All game modes:\n");
		for(GameMode gm : GameMode.values()) {
			System.out.println(gm.getName() + " -- " + gm.getDesc());
		}
		
		System.out.println("\n\t Randomly chosen game mode:\n");
		GameMode randomMode = GameMode.RandomBattle;
		System.out.println("Game mode chosen: " + randomMode.getName() + "\n"
				+ "Description: " + randomMode.getDesc());
	}

	public static void order(String order) {
		switch (Order.valueOf(order)) {
		case Go:
			System.out.println("Go!");
			break;
		case Wait:
			System.out.println("Wait!");
			break;
		case Stop:
			System.out.println("Stop!");
		case Sit:
			System.out.println("Sit!");
			break;
		case Run:
			System.out.println("Run!");
			break;
		case Walk:
			System.out.println("Walk!");
			break;
		case Kneel:
			System.out.println("Kneel!");
			break;
		case Speak:
			System.out.println("Speak!");
			break;
		}
	}
}
