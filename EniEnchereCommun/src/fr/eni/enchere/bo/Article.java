package fr.eni.enchere.bo;

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private String datedebutEncheres;
	private String dateFinEncheres;
	private int miseAPrix;
	private String prixVente;
	private String etatVente;
	private Utilisateur utilisateur;
	private Retrait retrait;
	
	public Article() {
		super();
	}
	
	public Article(String nomArticle, String description, String datedebutEncheres, String dateFinEncheres, int miseAPrix)
	{
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.datedebutEncheres = datedebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
	}
	
	public Article(int noArticle, String nomArticle, String description, String datedebutEncheres, String dateFinEncheres, int miseAPrix) {
		super();
		this.noArticle=noArticle;
		this.nomArticle=nomArticle;
		this.description=description;
		this.datedebutEncheres=datedebutEncheres;
		this.dateFinEncheres=dateFinEncheres;
		this.miseAPrix=miseAPrix;
	}
	
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatedebutEncheres() {
		return datedebutEncheres;
	}
	public void setDatedebutEncheres(String datedebutEncheres) {
		this.datedebutEncheres = datedebutEncheres;
	}
	public String getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(String dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public String getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(String string) {
		this.prixVente = string;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", datedebutEncheres=" + datedebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	
}
