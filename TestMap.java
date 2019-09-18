package cn.test.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的用法
 * @author dell
 *
 */

public class TestMap {
	public static void main(String[] args) {
		/*Map<Integer,String> m1=new HashMap();
		Map<Integer,String> m2=new HashMap();
		m1.put(1, "aaa");
		m1.put(2, "bbb");
		m1.put(3, "ccc");
		m2.put(1, "one");
		m2.put(2, "two");
		System.out.println(m1.get(1));
		m1.remove(2);
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("ddd"));
		m1.putAll(m2);
		//map中的键是不能重复的，重复后老的会覆盖旧的，判断是否重复用equals方法来判断。
		System.out.println(m1);*/
		Employee e1=new Employee(1001,"one",5000);
		Employee e2=new Employee(1002,"two",5000);
		Employee e3=new Employee(1003,"tree",5000);
		Employee e4=new Employee(1001,"four",5000);
		
		Map<Integer, Employee> map=new HashMap();
		map.put(1001, e1);
		map.put(1002, e2);
		map.put(1003, e3);
		map.put(1001, e4);
		Employee emp=map.get(1001);
		System.out.println(emp);
		System.out.println(map);
		
		
	}
}
class Employee{
	private int id;
	private String ename;
	private double salary;
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	public String toString() {
		return "[id:"+id+" name:"+ename+" salary:"+salary+"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
