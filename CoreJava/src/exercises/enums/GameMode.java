package exercises.enums;

// Exercise: create an enum representing a list of available game modes;

public enum GameMode {
	RandomBattle((int) (Math.random() * (6 - 1 + 1) + 1)), TeamBattle(1), TankCompany(2), Strongholds(3), Special(4),
	TeamTraining(5), BattleTraining(6);

	private String name;
	private String desc;

	private GameMode(int id) {
		switch (id) {
		case 1:
			this.desc = "Work together with you team to achive absolute victory!";
			this.name = "Team Battle";
			break;
		case 2:
			this.desc = "Join the fight as part of a tank company";
			this.name = "Tank Company";
			break;
		case 3:
			this.desc = "Conquer the enemy team's stronghold while defending your own";
			this.name = "Strongholds";
			break;
		case 4:
			this.desc = "Customize a battle to your liking";
			this.name = "Special Battle";
			break;
		case 5:
			this.desc = "Practice team coordination";
			this.name = "Team Training";
			break;
		case 6:
			this.desc = "Sharpen your combat skills in this combat-focused training mode";
			this.name = "Battle Training";
			break;
		}
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

}
