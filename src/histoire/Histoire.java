package histoire;

import etreVivants.heros.Heros;
import etreVivants.monstre.Monstre;

public class Histoire {

	public static void main(String[] args) {
		Heros heros = new Heros(10, "Héros", 0, 7);
		heros.parler("Je suis le Héros, je vais tuer tous les monstres");
		System.out.println(heros.toString());
		
		Monstre monstre1 = new Monstre(2, "Monstre1", 1, 4);
		monstre1.parler("Je suis un monstre et je fonce sur le Héros");
		System.out.println(monstre1.toString());
		System.out.println(monstre1.estEnvie());
		
		heros.attaquer(monstre1);
		monstre1.attaquer(heros);
		heros.attaquer(monstre1);

	}

}
