package Database.MOR;

/* this is the configuration class this is basically a way to connect
 * to a database easily; this class holds some useful variables */
public class Config {
	public static String driver = "com.mysql.jdbc.Driver";
	public static String format = "jdbc:mysql://%s:%s/%s";
	public static String server = "localhost", port = "3306";
	public String user = "root", pwd = "";
	public String dbname;
	public static Config d_cfg = new Config("tp_db");

	@Override
	public String toString() {
		return "Config [user=" + user + ", pwd=" + pwd + ", dbname=" + dbname
				+ ", getConnectionString()=" + getConnectionString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Config(String dbname) {
		this.dbname = dbname;
	}

	public Config(String user, String pwd, String dbname) {
		this.dbname = dbname;
		this.user = user;
		this.pwd = pwd;
	}

	public String getConnectionString() {
		return String.format(format, server, port, dbname);
	}

}
