public class Demo03 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql:///mysqltest", "root", "root");
		System.out.println(conn);

		// ���������õ�һ��Statement����
		Statement stmt = conn.createStatement();

		// 1.�����¼
		String sql = "INSERT INTO category (cname) VALUES ('�ֻ�');";
		int i = stmt.executeUpdate(sql);
		System.out.println("Ӱ�������:" + i);

		// 2.�޸ļ�¼
		sql = "UPDATE category SET cname='����' WHERE cid=4;";
		i = stmt.executeUpdate(sql);
		System.out.println("Ӱ�������:" + i);

		// 3.ɾ����¼
		sql = "DELETE FROM category WHERE cid=1;";
		i = stmt.executeUpdate(sql);
		System.out.println("Ӱ�������:" + i);
		
		// �ͷ���Դ
		stmt.close();
		conn.close();
	}
}