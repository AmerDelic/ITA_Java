package exercises.generics;

import java.util.ArrayList;
import java.util.List;

/* Exercise: 
 * A simple demonstration of a generic Bank class with an upper-bound type parameter */

public class Bank<T extends ICard> {

	List<T> cards = new ArrayList<T>();

	public Bank(T card) {
		addCard(card);
	}

	public void pay(int cardId, double amount) {
		cards.get(cardId).getMoney(amount);
	}

	public void addCard(T card) {
		cards.add(card);
	}

}
