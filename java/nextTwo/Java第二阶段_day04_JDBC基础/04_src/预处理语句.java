String sql = "select sid,sname,sage from student where sage=? and sname=?";
  PrepareStatement ps=con.prepareStatement(sql);//封装sql指令
  ps.setString(1, "22");//1为下标 22 为要插入的值
  ps.setString(2, "小志");
  rs=ps.executeQuery();//执行查询操作
  while(rs.next()){
      System.out.println(rs.getString("sid")+rs.getString("sname")+rs.getString("sage"));
  }
  
  String sql1 = "insert into student values(?,?,?)";
  ps=con.prepareStatement(sql1);
  ps.setString(1, "6");
  ps.setString(2, "韩雪");
  ps.setString(3, "26");
  ps.executeUpdate();//执行更新操作