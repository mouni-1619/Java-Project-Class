package org.jsp.Practise;

public class StaticInnerClass {
	static int x=100;
	static private int y=500;
	static void test() {
		System.out.println("running test() Methode");
	}
	static class Sample2{
		static int z=200;
		int u=300;
		Sample2(){
			System.out.println("Creating Sample2 instance");
		}
		static void m1() {
			System.out.println("running m1() method");
		}
		void m2() {
		  System.out.println(" running non-static m2() method");
		  System.out.println("y is outer privayte static varible:"+y);
		}
	}
}
