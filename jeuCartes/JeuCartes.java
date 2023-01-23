package jeuCartes;
import java.util.Random;

public class JeuCartes {
	
	public static void main(String[] args) {
		
		//Initialisation de 4 valeurs aléatoires (2 pour la valeur et 2 pour la couleur)	
		Random [] randValue = {new Random(), new Random()};
		Random [] randColor = {new Random(), new Random()};
		
		//Récupération de façon aléatoire d'une valeur et d'une couleur pour chaque carte
		String [] valeurs = {Carte.value[randValue[0].nextInt(12)], Carte.value[randValue[1].nextInt(12)]};
		String [] couleurs = {Carte.color[randColor[0].nextInt(4)], Carte.color[randColor[1].nextInt(4)]};
		
		//Création des 2 cartes
		Carte [] cartes = new Carte [2]; 
		for (int i = 0; i < 2; i++) {
			cartes[i] = new Carte ( valeurs[i], couleurs[i]);
		}
		
		//Vérification que les 2 cartes soient bien différentes car il n'existe qu'une seule carte ayant la même valeur et la même couleur dans un jeu de 52 cartes
		while(randValue[0].equals(randValue[1]) && randColor[0].equals(randColor[1])) {
			cartes[1].setCouleur(Carte.color[randColor[1].nextInt(4)]);
		}
		
		//Affichage des 2 cartes en utilisant les méthodes getValeur et getCouleur
		for (int i = 0; i < 2; i++) {
			System.out.println("La carte N°" + (i+1) + " est : " + cartes[i].getValeur() + " de " + cartes[i].getCouleur());
		}
		
		//Appel de la méthode "comparer" pour comparer et afficher la carte la plus forte
		cartes[0].comparer(cartes[1]);
	}

}
