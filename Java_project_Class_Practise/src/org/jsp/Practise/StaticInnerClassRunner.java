package org.jsp.Practise;

public class StaticInnerClassRunner {
	public static void main(String[] args) {
		
	
	System.out.println("main method Started");
	System.out.println("Outer class varibles------");
	System.out.println("x value is: "+StaticInnerClass.x);
	StaticInnerClass.test();
	System.out.println("inner class varibles-----");
	System.out.println("z value is: "+StaticInnerClass.Sample2.z);
	StaticInnerClass.Sample2.m1();
	StaticInnerClass.Sample2 s1=new StaticInnerClass.Sample2();
	System.out.println("u value is :"+s1.u);
	s1.m2();
	System.out.println("main method Ended");
	}
}
