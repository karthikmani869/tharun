package com.klu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
  
  JdbcTemplate jt;

  public JdbcTemplate getJt() {
    return jt;
  }

  public void setJt(JdbcTemplate jt) {
    this.jt = jt;
  }
  
  public void insert(Student s) {
    String qry = "insert into stu_s36 values (" + s.getId() + ", '" + s.getName() + "')";
    int r = jt.update(qry);
    System.out.println(r);
  }
  
  public void update(Student s) {
    String qry = "update stu_s36 set name = '" + s.getName() + "' where id = " + s.getId();
    int r = jt.update(qry);
    System.out.println(r);
  }
  public void delete(int id)
  {
	  String qry="delete from stu_s36 where id = " + id;
	  int r = jt.update(qry);
	  System.out.println(r);
  }
  public List<Student> retrieve(){
	 List<Student> l = jt.query("select * from stu_s36", new RowMapper<Student>() {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s =new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getNString("name"));
			return s;
		}
		  
	  });
	 return l;
  }
      
}