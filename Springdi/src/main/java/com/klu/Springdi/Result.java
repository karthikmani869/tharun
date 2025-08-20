package com.klu.Springdi;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Result {
       List<Course> l;
       Set<Course> s;
       Map<Integer,Course> m;
       Properties p;
       
	public List<Course> getL() {
		return l;
	}
	public void setL(List<Course> l) {
		this.l = l;
	}
	public Set<Course> getS() {
		return s;
	}
	public void setS(Set<Course> s) {
		this.s = s;
	}
	public Map<Integer, Course> getM() {
		return m;
	}
	public void setM(Map<Integer, Course> m) {
		this.m = m;
	}
	public Properties getP() {
		return p;
	}
	public void setP(Properties p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Result [l=" + l + ", s=" + s + ", m=" + m + ", p=" + p + "]";
	}
       
}
