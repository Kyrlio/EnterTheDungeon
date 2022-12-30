package main;

import java.util.Scanner;

import etreVivants.heros.Heros;
import etreVivants.monstre.Monstre;
import objets.armes.Arme;
import objets.equipement.Equipement;

public class Main {

	public static void main(String[] args) {
		boolean inGame = true;
		
		
		System.out.println("\n----------BIENVENUE SUR MON PROJET ILU1----------\n");
		System.out.println("dans ce projet, vous incarnez un Héros.");
		
		
		System.out.println("Veuillez entrer le nom de votre Héros : ");
		Scanner scNomHeros = new Scanner(System.in);
		String nomHeros = scNomHeros.next();
		
		Heros heros = new Heros(10, nomHeros, 5, 10, 25);
		
		afficherMenu(heros);
		
		}
		
			
	
	public static void afficherMenu(Heros heros) {
		System.out.println("\n----------MENU----------");
		System.out.println("1. STATISTIQUES HEROS");
		System.out.println("2. SIMULATION COMBAT");
		System.out.println("3. GESTION EQUIPEMENT");
		System.out.println("4. QUITTER");
		
		Scanner scChoixMenu = new Scanner(System.in);
		int choixMenu = scChoixMenu.nextInt();
		if (choixMenu == 1) {
			afficherStat(heros);
		}
		if (choixMenu == 2) {
			SimuCombat(heros);
		}
		if (choixMenu == 3) {
			GestionInventaire(heros);
		}
		if (choixMenu == 4) {
			System.out.println("Merci d'avoir essayé mon projet !");
			System.out.println("Cédric ROUSSEL");
			System.exit(0);
		}
		else {
			afficherMenu(heros);
		}
	}


	private static void afficherStat(Heros heros) {
		System.out.println("\n\n----------STATISTIQUES HEROS----------");
		System.out.println("1. Afficher le toString");
		System.out.println("2. Afficher l'équipement");
		System.out.println("3. Afficher l'équipement détaillé");
		System.out.println("4. Retour au menu");
		Scanner scStat = new Scanner(System.in);
		int choixStat = scStat.nextInt();
		if (choixStat == 1) {
			System.out.println(heros.toString());
			afficherStat(heros);
		}
		if (choixStat == 2) {
			heros.getInventaire();
			afficherStat(heros);
		}
		if (choixStat == 3) {
			heros.getInventaireDetaille();
			afficherStat(heros);
		}
		if (choixStat == 4) {
			afficherMenu(heros);
		} 
		else {
			afficherMenu(heros);
		}
	}
	
	private static void SimuCombat(Heros heros) {
		System.out.println("\n\n----------SIMULATION COMBAT----------");
		System.out.println("1. Combattre contre un monstre");
		System.out.println("2. Retour au menu");
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		if (choix == 1) {
			System.out.println("\n\n---------------------------------------------");
			System.out.println("Lors d'un combat, dans le projet final, le Héros attaquera automatiquement l'ennemi qui arrive sur lui.");
			System.out.println("Si vous n'avez pas d'armes d'équipé, retournez au menu et allez vous en ajouter dans GESTION EQUIPEMENT.");
			System.out.println("Il y a un systeme d'esquive, quand le monstre attaque, le Héros a 25% d'esquiver (c'est une statistique qui peut etre modifiable)\n\n");
			Monstre monstre = new Monstre(5, "Monstre répugnant", 5, 10);
			monstre.parler("Je suis un monstre et je fonce sur le Héros");
			while (monstre.estEnvie() && heros.estEnvie()) {
				heros.attaquer(monstre);
				monstre.attaquer(heros);
				if (monstre.estEnvie() == false) {
					heros.gagnerXP();
				}
			}
		}
		if (choix == 2) {
			afficherMenu(heros);
		} 
		else {
			SimuCombat(heros);
		}
	}
	
	private static void GestionInventaire(Heros heros) {
		System.out.println("\n\n----------GESTION EQUIPEMENT----------");
		System.out.println("1. Ajouter EPEE");
		System.out.println("2. Ajouter CASQUE");
		System.out.println("3. Ajouter PLASTRON");
		System.out.println("4. Ajouter JAMBIERES");
		System.out.println("5. Ajouter ANNEAUX_DEGATS");
		System.out.println("6. Fusionner ARMES");
		System.out.println("7. Retour au MENU");
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		switch (choix) {
		case 1: {
			Arme epee = new Arme("Epee", 2, 5, 2);
			heros.ramasserObjet(epee);
			heros.getInventaireDetaille();
			GestionInventaire(heros);
		}
		case 2:{
			heros.ramasserObjet(Equipement.CASQUE);
			heros.getInventaireDetaille();
			GestionInventaire(heros);			
		}
		case 3: {
			heros.ramasserObjet(Equipement.PLASTRON);
			heros.getInventaireDetaille();
			GestionInventaire(heros);
		}
		case 4: {
			heros.ramasserObjet(Equipement.JAMBIERES);
			heros.getInventaireDetaille();
			GestionInventaire(heros);
		}
		case 5: {
			heros.ramasserObjet(Equipement.ANNEAUX_DEGATS);
			heros.getInventaireDetaille();
			GestionInventaire(heros);
		}
		case 6: {
			heros.fusionnerArme();
			GestionInventaire(heros);
		}
		case 7:{
			afficherMenu(heros);
		}
		default:
			GestionInventaire(heros);;
		}
		
	}
	
		



		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Arme epee = new Arme("Epee", 2, 1, 1);
//		Heros heros = new Heros(10, "Héros", 1, 7, 50);
//		heros.parler("Je suis le Héros, je vais tuer tous les monstres");
//		//System.out.println(heros.toString());
//		
//		Monstre monstre1 = new Monstre(2, "Monstre1", 1, 4);
//		monstre1.parler("Je suis le monstre1 et je fonce sur le Héros");
//		System.out.println(monstre1.toString());
//		System.out.println(monstre1.estEnvie());
//		
//		heros.attaquer(monstre1);
//		heros.parler("Je m'arme de mon épée");
//		heros.ramasserObjet(epee);
//		heros.attaquer(monstre1);
//		heros.gagnerXP();
//		heros.getInventaire();
//		
//		monstre1.attaquer(heros);
//		heros.attaquer(monstre1);
//		
//		//----------2eme monstre----------
//		System.out.println();
//		
//		Monstre monstre2 = new Monstre(5, "Monstre2", 2, 4);
//		monstre2.parler("Je suis le monstre2 et je fonce sur le Héros");
//		System.out.println(monstre2.toString());
//		System.out.println(monstre2.estEnvie());
//		
//		monstre2.attaquer(heros);
//		heros.attaquer(monstre2);
//		
//		Arme epee2 = new Arme("Epee", 2, 1, 1);
//		heros.ramasserObjet(epee2);
//		heros.fusionnerArme();
//		
//		//-----Ajout d'équipements-----
//		heros.ramasserObjet(Equipement.CASQUE);
//		heros.ramasserObjet(Equipement.ANNEAUX_DEGATS);
//		heros.ramasserObjet(Equipement.PLASTRON);
//		heros.getInventaire();
//		heros.getInventaireDetaille();
//		System.out.println(heros.toString());
//		
//		//-----3eme monstre-----
//		Monstre monstre3 = new Monstre(7, "Monstre3", 2, 4);
//		monstre3.parler("Je suis le monstre3 et je fonce sur le Héros");
//		monstre3.attaquer(heros);
//		heros.attaquer(monstre2);
//		monstre2.attaquer(heros);
//		heros.attaquer(monstre2);
//
