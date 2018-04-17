package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.MOR.Database;
import Metier.Produit;

/* this is a direct connection between the tp_db */
public class DbProduit {
	private static String query;

	public DbProduit() throws ClassNotFoundException, SQLException {
	}
	/* product2row */
	public static void addProduit(Produit p) throws SQLException, ClassNotFoundException {
		query = "insert into Product(design, prix, qte) values ('" + p.getDes()
				+ "'," + p.getPrix() + "," + p.getQte() + ")";
		new Database().exec(query, true);
	}

	public static ArrayList<Produit> getProduits() throws SQLException, ClassNotFoundException {
		ArrayList<Produit> list = new ArrayList<Produit>();

		query = "SELECT * FROM Product";
		ResultSet res = new Database().exec(query, false);

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
