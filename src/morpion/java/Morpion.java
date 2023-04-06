package morpion.java;
import java.util.Scanner;
import java.util.Random;

public class Morpion {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       char[][] grille = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
       char joueur = 'X';
       int ligne, colonne;

       while(true) {
           System.out.println("Grille de Morpion:");
           System.out.println("---------------");
           for(int i=0; i<3; i++) {
               for(int j=0; j<3; j++) {
                   System.out.print("| " + grille[i][j] + " ");
               }
               System.out.println("|");
               System.out.println("---------------");
           }

           if (joueur == 'X') {
        	   System.out.println("Joueur " + joueur + ", veuillez entrer la ligne (1-3) de votre prochaine marque:");
               ligne = sc.nextInt() - 1;
               System.out.println("Joueur " + joueur + ", veuillez entrer la colonne (1-3) de votre prochaine marque:");
               colonne = sc.nextInt() - 1;
               
               if(grille[ligne][colonne] == ' ') {
                   grille[ligne][colonne] = joueur;
               } else {
                   System.out.println("Case déjà occupée. Veuillez choisir une autre case.");
                   continue;
               }
           }
           else {
        	   Random rand = new Random();
        	    ligne = rand.nextInt(3);
        	    colonne = rand.nextInt(3);
        	    if(grille[ligne][colonne] == ' ') {
                    grille[ligne][colonne] = joueur;
                } else {
                    System.out.println("Case déjà occupée. Veuillez choisir une autre case.");
                    continue;
                }
        	    
        	    
           }
       

           if(gagne(grille, joueur)) {
               System.out.println("Félicitations, joueur " + joueur + ", vous avez gagné!");
               break;
           }

           if(grillePleine(grille)) {
               System.out.println("Match nul.");
               break;
           }

           if(joueur == 'X') {
               joueur = 'O';
           } else {
               joueur = 'X';
           }
       }
   }

   public static boolean gagne(char[][] grille, char joueur) {
       for(int i=0; i<3; i++) {
           if(grille[i][0] == joueur && grille[i][1] == joueur && grille[i][2] == joueur) {
               return true;
           }
           if(grille[0][i] == joueur && grille[1][i] == joueur && grille[2][i] == joueur) {
               return true;
           }
       }
       if(grille[0][0] == joueur && grille[1][1] == joueur && grille[2][2] == joueur) {
           return true;
       }
       if(grille[0][2] == joueur && grille[1][1] == joueur && grille[2][0] == joueur) {
           return true;
       }
       return false;
   }

   public static boolean grillePleine(char[][] grille) {
       for(int i=0; i<3; i++) {
           for(int j=0; j<3; j++) {
               if(grille[i][j] == ' ') {
                   return false;
               }
           }
       }
       return true;
   }
}