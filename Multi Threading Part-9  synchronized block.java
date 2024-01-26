
																			Multi Threading Part-9 || synchronized block
																		==================================================

--------------------
 synchronized Block 
--------------------
	
 -> If very few lines of code required a synchronization then it is not recomanded to declare entire method as synchronized we have to enclose those few lines of the code by using synchronized 
	block.
	
-> The main advantage of synchronized block over synchronized method is it reduaces waiting time of thread and improves performance of the system.


-> We can declare synchronized block as follows 

 -> To get Lock of current object :									-> To get lock of particular object 'b':				-> To get class level lock :
                                                                                                                            
							|--->// Get lock of current object 			                                                    	
		1. synchronized (this){                                     		synchronized(b)                                 	synchronized(Display.class) 
			// if a thread got lock current object                  		{                                               	{
			//then only allowed to execute this area                			                                            		// If a thread got class level 
		}                                                           			// If a thread got lock particular          		// lock of 'Display' class then 
		                                                            			//object 'b' then on it is allowed          		// only it is allowed to execute
                                                                    			// to execute this area.                    		// this area.
																			}                                               	}

- Without synchronization we will get In-regualr output and use object level lock .

	class Display {												class MyThread extends Thread {						class SynchronizedDemo {
		                                                        	                                                	
		public void wish(String name){                          	Display d;                                      	public static void main(String args[]) {
			                                                    	String name;                                    		
			;;;;;;;; //1 lack lines of code                     	MyThread (Display d, String name){              		Display d = new Display();
			for(int i =0; i<10; i+=) {                          		this.d=d;                                   		MyThread t1 = new MyThread(d,"Dhoni");
				                                                		this.name=name;                             		MyThread t2 = new MyThread(d,"Yuraj");
				System.out.print("Good Morrning");              	}                                               		t1.start();
			try {                                               	public void run() {                             		t2.start();
				Thread.sleep(2000);                             		                                            	}
			}catch(InterruptedException e){}                    		d.wish(name);                               }
			Systen.out.println(name);                           	}
		}                                                       }

		;;;;;;;;// another 1 lack line of code 																				------------------
	}                                                                                                                       |  Display		 |<------------------t1.displayn()
}                                                                                                                           |  Object 		 |
                                                                                                                            |                |<----------t2.display();
	                                                                                                                        ------------------
	
-> With synchronized block we will get regular output and object level lock .	

	
	class Display {										class MyThread extends Thread {						class SynchronizedDemo {			
		                                             		                                                	
		public void wish(String name){               		Display d;                                      	public static void main(String args[]) {
			                                         		String name;                                    		
			;;;;;;;; //1 lack lines of code             	MyThread (Display d, String name){              		Display d = new Display();
			synchronized(this) {	                            this.d=d;                                   		MyThread t1 = new MyThread(d,"Dhoni");
			for(int i =0; i<10; i+=) {               			this.name=name;                             		MyThread t2 = new MyThread(d,"Yuraj");
				                                     		}                                               		t1.start();
				System.out.print("Good Morrning");   		public void run() {                             		t2.start();
			try {                                    			                                            	}
				Thread.sleep(2000);                  			d.wish(name);                               }
			}catch(InterruptedException e){}         		}
			Systen.out.println(name);                	}																	------------------
		}                                            	                                                                    |  Display		 |<------------------t1.displayn()
	  }	                                                                                                                    |  Object 		 |
		;;;;;;;;// another 1 lack line of code 	                                                                            |                |<----------t2.display();
	}	                                                                                                                    ------------------
}	
	
 -> In these example we use object level lock.

 
		class Display {										class MyThread extends Thread {			class SynchronizedDemo {			
			                                             		                                    	
			public void wish(String name){               		Display d;                          	public static void main(String args[]) {
				                                         		String name;                        		
				;;;;;;;; //1 lack lines of code             	MyThread (Display d, String name){  		Display d1 = new Display();
				synchronized (this){	                            this.d=d;                       		Display d2 = new Display();
    			for(int i =0; i<10; i+=) {               			this.name=name;                 		MyThread t1 = new MyThread(d1,"Dhoni");
    				                                     		}                                   		MyThread t2 = new MyThread(d2,"Yuraj");
    				System.out.print("Good Morrning");   		public void run() {                 		t1.start();
    			try {                                    			                                		t2.start();
					Thread.sleep(2000);                  			d.wish(name);                  		}
				}catch(InterruptedException e){}         		}	                                }
    			Systen.out.println(name);                	}
    		}                                            	
    	  }																									-------------							--------------
    		;;;;;;;;// another 1 lack line of code 	                                                        |	d1		|<-----t1-->(l).d1          |     d2	 |<---t2-->(l).d2
    	}	                                                                                                -------------	.wish("dhoni");         --------------  .wish("yuraj");
    }	
    	
    	
-> In these example we use class level lock and we get Regular output.

	Ex. 
    
    class Display {										class MyThread extends Thread {			class SynchronizedDemo {			
    	                                             		                                    	
    	public void wish(String name){               		Display d;                          	public static void main(String args[]) {
			                                         		String name;                        		
    		;;;;;;;; //1 lack lines of code             	MyThread (Display d, String name){  		Display d1 = new Display();
    		synchronized (Display){	                            this.d=d;                       		Display d2 = new Display();
    		for(int i =0; i<10; i+=) {               			this.name=name;                 		MyThread t1 = new MyThread(d1,"Dhoni");
    			                                     		}                                   		MyThread t2 = new MyThread(d2,"Yuraj");
    			System.out.print("Good Morrning");   		public void run() {                 		t1.start();
    		try {                                    			                                		t2.start();
    			Thread.sleep(2000);                  			d.wish(name);                  		}
    		}catch(InterruptedException e){}         		}	                                }
    		Systen.out.println(name);                	}
    	}                                            	
      }																									
    	;;;;;;;;// another 1 lack line of code 	                                                        
    
 	}	                                                                                                
}	
 	
-> Lock concept applicable for object types and class types but not for primitives hence a we can't pass primitive type as argument to synchronized block otherwise we will get compile time error 
	saying unexpected type found: int required: reference.
	
	
		int x = 10;
		synchronized(x){
				     |---->//CE: unexpected type found: int required: reference
			
		}
		
 --------	
  FAQs'
 --------

	1. What is synchronized keyword and  where we can apply ? 
		
		synchronized is modifiers applicable for methods, blocks but not for variables and classes.
		
		
	2. Explain advantage of synchronized keyword ? 
	
		we can resolve data inconsistancy problems.
		
	3. Expain disadvantage of synchronized keyword ? 
	
		It increases waiting time thread and creates performance problems.
		
	4. What is RaceCondition ? 
	
		If multiple threads are operating simultaneously on same java object then there may be chance of data inconsistancy problems this called race condition. We can overcome these problem 
		by using synchronized keyword.
		
		
	5. what is object lock and when it is required ? 
	
		Every object in java has unique lock which is nothing but object lock and when a thread required object lock, whenever a thread wants to execute instance synchronized method then the 
		thread required object lock.
		
		
	6. What is class level lock and when it is required ? 
	
		Every class in a java has a unique lock which is anothing but class level lock and when it is required , whenever if a thread want to execute static synchronized method then thread required
		this method .
		
		
	7 .what is the difference between class level lock and object level lock ?
	
		If a thread want's to execute static synchronized method then class level lock is required.
		If a thread want's to exeute  instance synchronized method then objcet level lock is required.

	8. While a thread executing synchronized method on the given object is the remaining threads are allowed to execute any other synchronized method simultaneously on the same object ?
	
		No ! 
		
	9. What is synchronized block ? 
	
	
	10. How to declare synchronized block  to get lock of current object ?

			synchronized(this){
				
			}
			
	11. How to declare synchronized block to get class level lock ?
	
			synchronized(Display.class) {
				
			}
			
	12. What is advantage of synchronized block over synchronized method ? 

		Performace by default will be improve and waiting time of thread will be reduace.
		
	13. Is a thread can accured mutiple locks simultaneously ? 
	
		Yes ! ofcourse from differnet objects .
		
			class X {
				
				public synchronized void m1() {
								//-------> Here thread has lock of 'X' object 
					Y y = new Y();
																											class Test {
					synchronized(y){                                                                        
							//-------> Here thread has locks of 'X' and 'Y' object                          	public static void main(String ars[]) {
							                                                                                	X x = new X();
							Z z = new Z();                                                                  	x.m1();
							                                                                                	}
							synchronized(z){                                                                }
								                                                                            			
								//-------> Here thread has locks of 'X' ,'Y' ,'Z' object 
							}
					}
				}
			}
							
		

	12. What is synchronized statement(Interview people created terminology) ? 
	
		The statements prasent in synchronized method and synchronized block are called synchronized statements.

	
		
		
		
		
		
	
			
			
			X  x= new X() 
			
					
		
	
	
 	
	
	
	
	
	
	
	
	
	
	
	