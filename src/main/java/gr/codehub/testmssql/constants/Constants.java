package gr.codehub.testmssql.constants;

public class Constants {




    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DB_BASE_URL = "jdbc:sqlserver://localhost:1433;";
    public static final String DB_SCHEMA = "accenture";
    public static final String DB_URL = String.format(DB_BASE_URL, DB_SCHEMA);

    // Database credentials
    public static final String USER = "sa";
    public static final String PASS = "passw0rd";


}
