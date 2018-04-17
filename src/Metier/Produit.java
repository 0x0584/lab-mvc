package Metier;

public class Produit {
	private Long ref;
	private String des;
	private float prix;
	private int qte;
	
	public Produit(Long ref, String des, float prix, int qte) {
		super();
		this.ref = ref;
		this.des = des;
		this.prix = prix;
		this.qte = qte;
	}

	public Produit() {
		super();
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", des=" + des + ", prix=" + prix
				+ ", qte=" + qte + ", getRef()=" + getRef() + ", getDes()="
				+ getDes() + ", getPrix()=" + getPrix() + ", getQte()="
				+ getQte() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
