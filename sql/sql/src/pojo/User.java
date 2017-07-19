package pojo;

import java.io.Serializable;

public class User implements Serializable{
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User(String name, String password, String address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}
	public int id = 1;
	public String name;
	private String password;
	public String getAddress() {
		return address;
	}
	public User(int id, String name, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, String password, String address, int age) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.age = age;
	}
	private int age;
}
