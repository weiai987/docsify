String sql = "select sid,sname,sage from student where sage=? and sname=?";
  PrepareStatement ps=con.prepareStatement(sql);//��װsqlָ��
  ps.setString(1, "22");//1Ϊ�±� 22 ΪҪ�����ֵ
  ps.setString(2, "С־");
  rs=ps.executeQuery();//ִ�в�ѯ����
  while(rs.next()){
      System.out.println(rs.getString("sid")+rs.getString("sname")+rs.getString("sage"));
  }
  
  String sql1 = "insert into student values(?,?,?)";
  ps=con.prepareStatement(sql1);
  ps.setString(1, "6");
  ps.setString(2, "��ѩ");
  ps.setString(3, "26");
  ps.executeUpdate();//ִ�и��²���