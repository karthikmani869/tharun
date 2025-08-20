package com.klu.Springdi;

public class Course {
	
	int cid;
	String cname;
	String grade;
	
	public Course() {
		super();
		
	}
	
	public Course(int cid, String cname, String grade) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", grade=" + grade + "]";
	}
	

}
