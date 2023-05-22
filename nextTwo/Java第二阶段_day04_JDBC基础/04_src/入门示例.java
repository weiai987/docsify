import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL_QuickStart {

    public void hello() throws Exception {
        //1. ��������
        Class.forName("com.mysql.jdbc.Driver");
        //2. �������
        Connection conn = DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/dayxx", "root", "root");
        //3. ��дsql
        String sql = "select * from category";
        //4. ���ִ��sql���Ķ���
        Statement st = conn.createStatement();
        //5. ִ��sql��䣬�����ؽ��
        ResultSet rs = st.executeQuery(sql);
        //6. ������
        //�ж��Ƿ�����һ����¼
        while (rs.next()) {
            //������һ��,��ȡ������¼
            Integer cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + " , " + cname);
        }
        //7. �ͷ���Դ
        rs.close();
        st.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        MySQL_QuickStart t = new MySQL_QuickStart();
        t.hello();
    }
}