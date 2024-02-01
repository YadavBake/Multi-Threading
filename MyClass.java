class A {

		public synchronized void d1(B b){
			
			System.out.println("Thread one start execution d1() method");

				try {
					
				   Thread.sleep(5000);
				}catch(InterruptedException e){}
				
				System.out.println("Thread one trying to call B's last Method");
				b.last();
		}
		
		public synchronized void last(){
			
			System.out.println("Inside A's last() method");
		}
	}


	class B {
    
    	public synchronized void d2(A a){
    		
    		System.out.println("Thread two start execution d2() method");
    
    			try {
    				
    				Thread.sleep(5000);
				}catch(InterruptedException e){}
    			
    			System.out.println("Thread two trying to call A's last Method");
    			a.last();
    	}
    	
    	public synchronized void last(){
    		
    		System.out.println("Inside B's last() method");
    	}
    }
	
	
	public class MyClass extends Thread {					
		
			A a = new A();
			B b = new B();
			
			public void m1(){
				
				this.start();
				a.d1(b); 
				
			}
			
			public void run(){
				
				b.d2(a); 
			}
			
		 public static void main(String args[]) {
			
			MyClass d = new MyClass();
			d.m1();
			
		}
	}


	
	

















	