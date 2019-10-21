package com.qym.pojo;

public class People {
	private int id;
	private String name;
	private String job;
	private String spc;
	private String decs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSpc() {
		return spc;
	}
	public void setSpc(String spc) {
		this.spc = spc;
	}
	public String getDecs() {
		return decs;
	}
	public void setDecs(String decs) {
		this.decs = decs;
	}
	@Override
	public String toString() {
		return "people [id=" + id + ", name=" + name + ", job=" + job
				+ ", spc=" + spc + ", decs=" + decs + "]";
	}
	
}
