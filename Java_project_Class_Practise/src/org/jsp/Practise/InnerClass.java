package org.jsp.Practise;

public class InnerClass {
	private int var1=100;//is outer class private varible
	//instance method
	void test() {
		System.out.println("Starting test() method");
		
		// Local inner Class
		class Sample1{
	int x=10;
//			static int y=20;// is not suport in java 1.8 vwesion 
			//it will suport in latest versions only
			private int var2=200;
			void disp() {
				System.out.println("rinning disp()....");
				System.out.println(var1+" is the outer class varible");
			}
		}
		Sample1 s=new Sample1();
		System.out.println(s.x);
//		System.out.println(Sample1.y);
		System.out.println(s.var2);
		s.disp();
		System.out.println("Ending test() method");
	}

}
