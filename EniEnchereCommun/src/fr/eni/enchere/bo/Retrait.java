package fr.eni.enchere.bo;

public class Retrait {

	private String nomRue;
	private int codePostal;
	private String ville;
	
	public Retrait() {
		super();
	}
	
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Retrait [nomRue=" + nomRue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
}
