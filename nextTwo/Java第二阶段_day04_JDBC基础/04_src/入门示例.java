import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL_QuickStart {

    public void hello() throws Exception {
        //1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得连接
        Connection conn = DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/dayxx", "root", "root");
        //3. 编写sql
        String sql = "select * from category";
        //4. 获得执行sql语句的对象
        Statement st = conn.createStatement();
        //5. 执行sql语句，并返回结果
        ResultSet rs = st.executeQuery(sql);
        //6. 处理结果
        //判断是否还有下一条记录
        while (rs.next()) {
            //若有下一条,获取此条记录
            Integer cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + " , " + cname);
        }
        //7. 释放资源
        rs.close();
        st.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        MySQL_QuickStart t = new MySQL_QuickStart();
        t.hello();
    }
}