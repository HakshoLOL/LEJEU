import java.util.ArrayList;

/**
 * Classe représentant la grille de jeu contenant les cases
 * 
 * @author Adrien
 *
 */
public class Grille {

	/**
	 * Liste des cases
	 */
	private Case[][] lcase;
	
	/**
	 * Contruit une nouvelle grille
	 * avec 2 cases de 0 ou 4 en valeur
	 * 
	 */
	public Grille() {
		// a changer par des randoms
		this.lcase=new Case[4][4];
		for (int i=0;i<5;i++) {
			double ale=(Math.random());
			int val;
			if (ale <= 0.6) { // 60% 2
				val=2;
			} else { // 40% 4
				val=4;
			}
			ajouteCase(new Case(val));
		}
	}
	
	/**
	 * retourne dle tableau des cases des cases 
	 * @return liste des cases
	 */
	public Case[][] getLiCases() {
		return this.lcase;
	}
	
	public void ajouteCase(Case c){
		ArrayList vide = this.caseVides();
		int rand = (int)(Math.random()*(vide.size()));
		int[] indice= (int[]) vide.get(rand);
		this.lcase[indice[0]][indice[1]] = c;
	}
	
	public Position[] caseVides() {
		Position[] listeVide = null;
		int idx=0;
		for (int i=0;i<this.lcase.length;i++){
			for (int j=0;j<this.lcase[i].length;j++) {
				if(this.lcase[i][j]== null ) {
					listeVide[++idx]=lcase[i][j].getPos();
				}
				
			}
		}
		return listeVide;
		
	}
	
	public ArrayList casePleine() {
		ArrayList lvide = new ArrayList();
		for (int i=0;i<this.lcase.length;i++) {
			for(int j=0;j<this.lcase[i].length;j++) {
				if (this.lcase[i][j] != null) {
					int[] tt = {i,j};
					lvide.add(tt);
				} 
			}
			
		}
		return lvide;	
	}
	
	public void mvntDroite() {
		ArrayList pleine = this.casePleine();
		
		for (int i=0;i<pleine.size();i++) {
			int [] ligne = (int [])pleine.get(i);
			System.out.println(ligne[0]+"  "+ligne[1]);
			
		}
			
	}

	
	
}


