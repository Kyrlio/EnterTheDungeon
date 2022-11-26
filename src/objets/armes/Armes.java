package objets.armes;

public class Armes {
	private float degats;
	private float range;

	public Armes(float degats, float range) {
		this.degats = degats;
		this.range = range;
	}

	public float getDegats() {
		return degats;
	}

	public float getRange() {
		return range;
	}
	
}
