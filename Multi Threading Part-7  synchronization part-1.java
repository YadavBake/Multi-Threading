
																		Multi Threading Part-7 || synchronization part-1
																	=======================================================	

-------------------
  Synchronization
-------------------

 -> Synchronized is the modifier applicable only for methods and blocks but not classes and variables.

 -> If multiple threads are trying to operate simultaneously on the same java object then there may be chance of data inconsistancy problem.

 -> To overcome these problem we should go for synchronized keyword.

 -> If a method or block declared as synchronized then at a time only one thread is allowed to execute that method or block on the given object so that data inconsistancy problem will be resolved.

 -> The main advantage of synchronized keyword is we resolve data inconsistancy problems but the main disadvantage of synchronized keyword is it increases waiting time of threads and creates 
	performance problem hence If there is no specific requirement then it is not recomanded to use synchronized keyword.

 -> Internally synchronization concept is implimented by using lock. Every object in java has a unique lock.

 -> Whenever we are using synchronized keyword then only lock concept will come into the picture.

 -> If a thread want's to execute synchronized method on the given object first it has to get lock of that object.

 -> Once thread got the lock then it is allowed to execute any synchronized method on that object.

 -> Once a method execution complits automatically thread releases the lock.

 -> Occuaring and releasing lock internally takes care by JVM and programmer not responsible for these activity.

 
												waiting state
	class x {								t2------------------	
												    m1()	   |	
		synch m1()											   |	
															------------------------	m1() //t1 access x object m1() method using lock of object x 
		synch m2()											|					   |<--------------------t1 
															|		  X	object     |	
		m3()												------------------------ m1() {	
																|	   |						
	}												m2()		|	   |				}		
											t3-------------------	   |
											    waiting state		   |	
															m3()       |
											t4--------------------------
												t4 get access m3() method 	
												
												
 -> While a thread executing synchronized method on the given object the remaining threads are not allowed to execute any synchronized method simultaneously on the same object but remaining thread 
    are allowed to execute non-synchronized methods simultaneously 
												
 -> Lock concept is implimented based on object but not based on method.
																									class x {										class ReservationSystem {
							 ------------------------------------                                                                                   	
							 |								    |                                      synchronized area {                          	non-synchronized chechAvailability() {
							 |                   |              |                                          /*where we are performing update         		
	This are can be accessed | non-synchronized  |             -----> This area can be accessed				operation[add/delete/remove/	        		//Perform just read operation 
	by any no of Threads     |   area            |synchronized  |	  by only one thread at a              	replace] where state object             	}
	simultaneously.		<------                  |  area        |	  time 			                       	changing*/                              	
							 |                   |              |                                    	}	                                         synchronized bokkTicket () {
							 |                   |              |                                               	                                		
							 |                   |              |                                     non-synchronized area {                       		// updated perform 
							 |                                  |                                     	                                            	}
							 ------------------------------------                                     /*wherever object state                       	
							         Object x                                                           	won't be changed like                   }
							                                                                          	read operation */
							                                                                          }
                                                                                                 }
 -> 
 
	
	class Display {												class MyThread extends Thread {						class SynchronizeDemo {
		                                                        	                                                	
		public synchronized void wish(String name) {                Display d;                                      		public   static void main(String args[]) {
			                                                    	Stirng name;                                    
			for (i = 0; i<10; i++){                             	                                                			Display d = new Display();
				                                                	MyThread(Display d, String name){               			MyThread t1 = new MyThread(d,"Dhoni");
				System.out.println("Good Morning");             		                                            			MyThread t2 = new MyThread(d,"Yuraj");
				try {                                           		this.d = d;                                 			MyThread t3 = new MyThread(d,"kohli");
					                                            		this.name = name;                           			MyThread t4 = new MyThread(d,"Raina");
					Thread.sleep(2000);                         	}                                               			t1.start();
				}catch(InterruptedException e) {}               	public void run() {                             			t2.start();
				System.out.println(name);                       		                                            			t3.start();
			}                                                   		d.wish(name);                               			t4.start();
		}                                                       	}                                               			
	}                                                           }                                                   		}
	                                                                                                                }
	class SynchronizeDemo {
		
			public static void main(String args[]) {																	------------------
	                                                                                                                    |  Display		 |<------------------t1.wish("Dhoni");
				Display d = new Display();                                                                              |  Object 		 |
				d.wish("Dhoni");                                                                                        |                |<----------t2.wish("yuraj");
			}                                                                                                           ------------------
	}
	
	
	-> If we are not declaring wish() method as synchronized then both threads will executed simultaneously and hence a we will get Iregualr oputput.
	
	-> If we declare wish() method sa synchronized then at a time only one thread is allowed to execute wish() method on the given display object and hence a we will get regular output.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
				
				
				
				
				
	
	
	
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	