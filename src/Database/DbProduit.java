package Database;

import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Produit;

public class DbProduit {
	private static Database db;

	public DbProduit() throws ClassNotFoundException, SQLException {
		db = new Database(Config.d_cfg);
	}

	public static void addProduit(Produit p) throws SQLException {
		String query = "insert into Product(design, prix, qte) values ("
				+ p.getDes() + "," + p.getPrix() + "," + p.getQte() + ")";
		db.exec(query, true);
	}

	public static ArrayList<Produit> getProduits() {
		return null;
	}

	@Override
	public String toString() {
		return "DbProduit [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
