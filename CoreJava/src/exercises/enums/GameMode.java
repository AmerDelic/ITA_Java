package exercises.enums;

// Exercise: create an enum representing a list of available game modes;

public enum GameMode {
	RandomBattle((int) (Math.random() * (5 - 2 + 1)) + 2, "Random Battle",
			"Randomly selects any of the six available battle modes"),
	TeamBattle(2, "Team Battle", "Work together with you team to achive absolute victory!"),
	TankCompany(3, "Tank Company", "Join the fight as part of a tank company"),
	Strongholds(4, "Strongholds", "Conquer the enemy team's stronghold while defending your own"),
	Special(5, "Special Battle", "Customize a battle to your liking"),
	TeamTraining(6, "Team Training", "Practice team coordination"),
	BattleTraining(7, "Battle Training", "Sharpen your combat skills in this combat-focused training mode");

	public int id;
	public String name;
	public String desc;

	private GameMode(int id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

}
