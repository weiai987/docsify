public class JDBCUtil {
	// 1.将固定字符串定义为常量
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///dayxx";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	// 2.在静态代码块中注册驱动(只注册一次)
	// 当这个类加载到内存的时候就走这个静态代码块,再去触发Driver类中的静态代码块,主动注册
	static {
        /* 可以将四个参数抽取为一个jdbc.properties文件，放置在src目录下，
      	   然后通过Properties对象getProperty()方法获取每个值 */
      	InputStream is = JDBCUtil.class.getClassLoader()
            .getResourceAsStream("jdbc.properties");
		Properties pp = new Properties();
		pp.load(is);
        String driver_class = pp.getProperty("DRIVER_CLASS");
        //如果dirver_class确实配置了值，则
        if(driver_class != null && !driver_class.trim().equals("")) {
            DRIVER_CLASS = driver_class;
        }        
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {}
	}
	
	// 3.提供一个获取连接的方法static Connection getConneciton();
	// 我们面向JDBC编程
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);      
      	/* 可以将四个参数抽取为一个jdbc.properties文件，放置在src目录下，
      		然后通过Properties对象getProperty()方法获取每个值 */
      	InputStream is = JDBCUtil.class.getClassLoader()
            .getResourceAsStream("jdbc.properties");
		Properties pp = new Properties();
		pp.load(is);
        String driver_name = properties.getProperty("DRIVER_NAME");
        if(driver_name != null && !driver_name.trim().equals("")) {
            DRIVER_NAME = driver_name;
        }
			
		return conn;
	}
	
	// 5.重载关闭方法close(Connection conn, Statement stmt)
	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
	
	// 4.定义关闭资源的方法close(Connection conn, Statement stmt, ResultSet rs)
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}