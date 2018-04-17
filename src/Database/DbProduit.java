package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.MOR.Config;
import Database.MOR.Database;
import Metier.Produit;

public class DbProduit {
	private static Database db;
	private static String query;

	public DbProduit() throws ClassNotFoundException, SQLException {
		db = new Database(Config.d_cfg);
	}

	public static void addProduit(Produit p) throws SQLException {
		query = "insert into Product(design, prix, qte) values (" + p.getDes()
				+ "," + p.getPrix() + "," + p.getQte() + ")";
		db.exec(query, true);
	}

	public static ArrayList<Produit> getProduits() throws SQLException {
		ArrayList<Produit> list = new ArrayList<Produit>();

		query = "SELECT * FROM Product";
		ResultSet res = db.exec(query, false);

		while (res.next()) {
			list.add(new Produit(res.getLong("ref"), res.getString("design"),
					res.getFloat("prix"), res.getInt("qte")));
		}
		return list;
	}

	@Override
	public String toString() {
		return "DbProduit [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
