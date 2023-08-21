public class JDBCUtil {
	// 1.���̶��ַ�������Ϊ����
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///dayxx";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	// 2.�ھ�̬�������ע������(ֻע��һ��)
	// ���������ص��ڴ��ʱ����������̬�����,��ȥ����Driver���еľ�̬�����,����ע��
	static {
        /* ���Խ��ĸ�������ȡΪһ��jdbc.properties�ļ���������srcĿ¼�£�
      	   Ȼ��ͨ��Properties����getProperty()������ȡÿ��ֵ */
      	InputStream is = JDBCUtil.class.getClassLoader()
            .getResourceAsStream("jdbc.properties");
		Properties pp = new Properties();
		pp.load(is);
        String driver_class = pp.getProperty("DRIVER_CLASS");
        //���dirver_classȷʵ������ֵ����
        if(driver_class != null && !driver_class.trim().equals("")) {
            DRIVER_CLASS = driver_class;
        }        
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {}
	}
	
	// 3.�ṩһ����ȡ���ӵķ���static Connection getConneciton();
	// ��������JDBC���
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);      
      	/* ���Խ��ĸ�������ȡΪһ��jdbc.properties�ļ���������srcĿ¼�£�
      		Ȼ��ͨ��Properties����getProperty()������ȡÿ��ֵ */
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
	
	// 5.���عرշ���close(Connection conn, Statement stmt)
	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
	
	// 4.����ر���Դ�ķ���close(Connection conn, Statement stmt, ResultSet rs)
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