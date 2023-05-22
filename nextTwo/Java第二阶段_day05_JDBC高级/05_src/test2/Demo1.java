package test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo1 {
    public void test1() throws Exception {
        Connection conn = DruidUtil.getConnection();
        String sql = "select * from t_dict where dvalue=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "男");
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next() != false) {
            System.out.println("did=" + resultSet.getString("did"));
        }
        DruidUtil.close(resultSet, pstmt, conn);
    }

    public static void main(String[] args) throws Exception {
        Demo1 d = new Demo1();
        d.test1();
    }
}
