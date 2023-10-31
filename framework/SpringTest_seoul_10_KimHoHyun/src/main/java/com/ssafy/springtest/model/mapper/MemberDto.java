package com.ssafy.springtest.model.mapper;

public class MemberDto {
	String id;
	String pw;
	String position;
	String usernumber;
	String name;
	String rname;
	int rclass;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRclass() {
		return rclass;
	}
	public void setRclass(int rclass) {
		this.rclass = rclass;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", position=" + position + ", usernumber=" + usernumber
				+ ", name=" + name + ", rname=" + rname + ", rclass=" + rclass + "]";
	}
}
