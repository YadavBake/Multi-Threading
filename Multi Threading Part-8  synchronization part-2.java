
																	Multi Threading Part-8 || synchronization part-2
																======================================================

-------------
 Case_Study 
------------- 



class Display {												class MyThread extends Thread {						class SynchronizeDemo {	
	                                                        	                                                	
	public synchronized void wish(String name) {                Display d;                                      		public   static void main(String args[]) {
		                                                    	Stirng name;                                    
		for (i = 0; i<10; i++){                             	                                                			Display d1 = new Display();
			                                                	MyThread(Display d, String name){               			Display d2 = new Display();
			System.out.println("Good Morning");             		                                            			MyThread t1 = new MyThread(d1,"Dhoni");
			try {                                           		this.d = d;                                 			MyThread t2 = new MyThread(d,"kohli");
				                                            		this.name = name;                           			
				Thread.sleep(2000);                         	}                                               			
			}catch(InterruptedException e) {}               	public void run() {                             			
			System.out.println(name);                       		                                            			t1.start();
		}                                                   		d.wish(name);                               			t2.start();
	}                                                       	}                                               			
}                                                           }                                                   		}
                                                                                                                }
																											
																								-------------							--------------
																								|	d1		|<-----t1-->(l).d1          |     d2	 |<---t2-->(l).d2
																								-------------	.wish("dhoni");         --------------  .wish("yuraj");
																								
																								
		-> Even though wish() method is synchronized we will get Iregular output becuase threads are operating on different java objects.

Conclusion 

	- If multiple thread are operating on same java object then synchronization is required.
	
	- If multiple threads are operating on multiple java object then synchronization is not required.
	

---------------------	
  Class Levelo Lock  
---------------------  

 -> Every class in java has unique lock which is anothing but class level lock. 
 
 -> If a thread want's to execute a static synchronized method then thread required class level lock.
 
 -> Once a thread got class level lock then it is allowed to execute any static synchronized method of that class.
 
 -> Once a method execution complites automatically thread releases the lock.
 
 

class Display {												class MyThread extends Thread {						class SynchronizeDemo {	
	                                                        	                                                	
	public static synchronized void wish(String name) {         Display d;                                      		public   static void main(String args[]) {
		                                                    	Stirng name;                                    
		for (i = 0; i<10; i++){                             	                                                			Display d1 = new Display();
			                                                	MyThread(Display d, String name){               			Display d2 = new Display();
			System.out.println("Good Morning");             		                                            			MyThread t1 = new MyThread(d1,"Dhoni");
			try {                                           		this.d = d;                                 			MyThread t2 = new MyThread(d,"kohli");
				                                            		this.name = name;                           			
				Thread.sleep(2000);                         	}                                               			
			}catch(InterruptedException e) {}               	public void run() {                             			
			System.out.println(name);                       		                                            			t1.start();
		}                                                   		d.wish(name);                               			t2.start();
	}                                                       	}                                               			
}                                                           }                                                   		}
                                                                                                                }
																											
																								-------------							--------------
																								|	d1		|<-----t1-->(l).d1          |     d2	 |<---t2-->(l).d2
																								-------------	.wish("dhoni");         --------------  .wish("yuraj");
												
-> While a thread executing static synchronized method the remaining threads are not allowed to execute any static synchronized method of that class simultaneously but remaining threads are 
	allowed to execute the following method simultaneously. first one Normal static method, second one synchronized instance method, third one normal instance methods.
	
												
												
                                                	waiting state
 class X {                                      t2------------------	
	                                            	    m1()	   |	
	static synchronized m1 ()									   |			
	static synchronized m2 ()                   				------------------------	m1() //t1--> get class level Lock (x)
				 static m3 ()                   				|					   |<--------------------t1 
		   synchronized m4 ()                   				|		  X	object     |	
						m5 ()                   				------------------------ m1() {	
                                                					|	   |	|	|   				
                                                		m2()		|	   |	|	|		}		
                                                t3-------------------	   |    |   |
                                                    waiting state		   |	|   |			m5() get access 
                                                				m3()       |    |   ---------------------------->t6
                                                t4--------------------------    -------------------->t5
                                                	t4 get access m3() method 	    m4() get access 



 -> 
	------------------------------------------------
	Without synchronized  we will get mixed output
  --------------------------------------------------	
 
	class Display {												class MyThread1 extends Thread {			class SynchronizeDemo3 {
		                                                        	                                        	
		public void displayn() {                                	Display d ;                             	public static void main(String args[]) {
			                                                    	MyThread1(Display d ){                  		
			for(int i = 1 ; i<=10; i++) {                       		this.d=d;                           		Display d = new Display();
				                                                	}                                       		MyThread t1 = new MyThread(d);
				System.out.println(i);                          	public void run(){                      		MyThread t2 = new MyThread(d);
				try {                                           		                                    		t1.start();
					                                            		d.displayn()                        		t2.start();
					Thread.sleep(2000);                         	}                                       	}
				}catch(InterruptedException e){}                }                                           }
			}                                                                                               
		}                                                       class MyThread2 extends Thread {            
		                                                        	                                        ------------------
		public void displayc() {                                	Display d ;                             |  Display		 |<------------------t1.displayn()
			                                                    	MyThread2(Display d) {                  |  Object 		 |
			for(int i = 65;  i<= 75; i++){                      		this.d=d;                           |                |<----------t2.display();
				System.out.print((char i));                     	}                                       ------------------
				try {                                           	public void run() {
					Thread.sleep(2000);                         		
				}catch(InterruptedException e){}                		d.displayc();
			}                                                   	}
		}                                                       }
	}
	
	
	
  ------------------------------------------------	
	With synchronized  we will get regular  output
  -------------------------------------------------	
	
	class Display {												class MyThread1 extends Thread {			class SynchronizeDemo3 {
		                                                        	                                        	
		public synchronized void displayn() {                       Display d ;                             	public static void main(String args[]) {
			                                                    	MyThread1(Display d ){                  		
			for(int i = 1 ; i<=10; i++) {                       		this.d=d;                           		Display d = new Display();
				                                                	}                                       		MyThread t1 = new MyThread(d);
				System.out.println(i);                          	public void run(){                      		MyThread t2 = new MyThread(d);
				try {                                           		                                    		t1.start();
					                                            		d.displayn()                        		t2.start();
					Thread.sleep(2000);                         	}                                       	}
				}catch(InterruptedException e){}                }                                           }
			}                                                                                               
		}                                                       class MyThread2 extends Thread {            
		                                                        	                                        ------------------
		public synchronized void displayc() {                       Display d ;                             |  Display		 |<------------------t1.displayn()
			                                                    	MyThread2(Display d) {                  |  Object 		 |
			for(int i = 65;  i<= 75; i++){                      		this.d=d;                           |                |<----------t2.display();
				System.out.print((char i));                     	}                                       ------------------
				try {                                           	public void run() {
					Thread.sleep(2000);                         		
				}catch(InterruptedException e){}                		d.displayc();
			}                                                   	}
		}                                                       }
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    



























