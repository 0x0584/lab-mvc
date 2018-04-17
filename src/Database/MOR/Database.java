package Database.MOR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
	private Connection connection;
	private Statement state;

	public Database() {
		
	}
	
	public Database(Config cfg) throws SQLException, ClassNotFoundException {
		Class.forName(Config.driver);
		connection = DriverManager.getConnection(cfg.getConnectionString(),
				cfg.user, cfg.pwd);
		state = connection.createStatement();
	}

	public ResultSet exec(String query, boolean isupdate) throws SQLException {
		if (isupdate) {
			state.executeUpdate(query);
			return null;
		}

		return state.executeQuery(query);
	}

	public void publishQuote(String ida, String idu, String content)
			throws SQLException, ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = formatter.parse(new Date().toString());
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		
		String query = "INSERT INTO q_quote(idAuthor, "
				+ (idu == null ? "" : "idUser, ") + "created, content) VALUE ("
				+ ("'"+ida+"', ") + (idu == null ? "" : "'"+idu + "',")
				+ (sqlDate + ",") + ("'"+content+"'") + ")";
		exec(query, true);
	}
}
