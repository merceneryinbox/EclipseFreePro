
/**
 * @author mercenery
 */
import java.sql.*;
import javax.naming.Context;
import javax.sql.DataSource;

public class DBMaster {
	static String postgresDriver = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5432/dictionary";
	static String dbName = "/dictionary";
	static String user = "postgres";
	static String pass = "postgres";

	static Context ctx;
	static DataSource ds;
	static Connection connect;
	static PreparedStatement ps;
	static ResultSet result;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(url, user, pass);
			PreparedStatement pr =connect.prepareStatement("select definition from word_define where UPPER(word) = UPPER( ? );");
			pr.setString(1, "icMp");
			// ps = connect.prepareStatement("select definition from word_define where UPPER(word) like UPPER(?);");
			result = pr.executeQuery();
			result.next();
				//String s1 = result.getString("word");
				String s2 = result.getString("definition");
				//System.out.println(s1 + " | " + s2);
				System.out.println(s2);
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
