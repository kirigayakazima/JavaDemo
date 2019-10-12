package com.bjsxt.vo;

public class User {
	private int uid;
	private String name;
	private double power;
	private double money;
	private String loca;
	private String dec;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getLoca() {
		return loca;
	}
	public void setLoca(String loca) {
		this.loca = loca;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", power=" + power
				+ ", money=" + money + ", loca=" + loca + ", dec=" + dec + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dec == null) ? 0 : dec.hashCode());
		result = prime * result + ((loca == null) ? 0 : loca.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(power);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + uid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dec == null) {
			if (other.dec != null)
				return false;
		} else if (!dec.equals(other.dec))
			return false;
		if (loca == null) {
			if (other.loca != null)
				return false;
		} else if (!loca.equals(other.loca))
			return false;
		if (Double.doubleToLongBits(money) != Double
				.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(power) != Double
				.doubleToLongBits(other.power))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	public User(int uid, String name, double power, double money, String loca,
			String dec) {
		super();
		this.uid = uid;
		this.name = name;
		this.power = power;
		this.money = money;
		this.loca = loca;
		this.dec = dec;
	}
	public User() {
	}
}
