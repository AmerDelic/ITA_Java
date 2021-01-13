package exercises.cordinatesgame;

import java.util.Scanner;

public class Executor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player name: ");
		String name = sc.nextLine();

		Player p1 = new Player(name);
		Opponent pc = new Opponent();
		p1.arrangeShips();
		pc.arrangeShips();

		Board game = new Board(p1, pc);

		boolean on = true;
		int px = 0;
		int py = 0;

		a: while (on) {
			b: while (!game.isOver()) {
				System.out.print("\nEnter X (1-10):");
				px = sc.nextInt();
				if(px < 1 || px > 10) {
					System.out.println("X must be within 1-10");
					interval();
					continue b;
				}
				System.out.println("X: " + px);
				System.out.print("\nEnter Y (1-5):");
				py = sc.nextInt();
				if(py < 1 || py > 5) {
					System.out.println("Y must be within 1-5");
					interval();
					continue b;
				}
				System.out.println("Y: " + py);
				interval();
				game.shoot(px, py);
				if(game.isOver()) {
					continue b;
				}
				interval();
				game.pcShoot();
				interval();
			}
			System.out.println("\t\tGameover!");
			String msg = String.format("\n\t %s score: %d" + "\n\t Computer score: %d \n\t Play another round? Y/N : ",
					p1.getName(), p1.getScore(), pc.getScore());
			System.out.println(msg);

			String yn = sc.next().toLowerCase();
			if (yn.equals("y")) {
				game.resetMap();
				px = 0;
				py = 0;
				p1.arrangeShips();
				pc.arrangeShips();
				continue a;
			} else {
				on = false;
				sc.close();
				System.out.println("Shutting down ...");
			}
		}

	}

	public static void interval() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
