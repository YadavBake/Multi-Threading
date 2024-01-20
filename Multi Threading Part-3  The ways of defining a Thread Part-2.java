
															        Multi Threading Part-3 || The ways of defining a Thread Part-2
															 ========================================================================


----------------------------------------------------------	
	Defining a Thread by implementing Runnable interface 
------------------------------------------------------------

 -> We can define a thread by implementing Runnable interface
 
			
						Runnable(interface)
								|
								|
				--------------------------------------				
				|									 |
			 Thread 							MyRunnable 
				|
			MyThread 	
		 (1st Approach)						(2nd Approach).


-> Runnable interface prasent in java.lang package and it containe only one method it is run() method. 

			- public void run() {}

	Ex. 
	
																											  class ThreadDemo { 			      		
		class MyRunnable extends Runnable {<----------------------------------------------					  					
																						 |                    	public static void main(String args[]) {
			public void run() {								                             |                    		
																                         |                    		MyRunnable r = new MyRunnable()
				for(int i = 0; i<10;i++) {<------------------	                         |/*=> This called    								  
															| Executed by Child thread   |  defining Thread*/ 								  |--->//Target Runnable			
					System.out.println("Child Thread ");	|==>//This is Job of Thread  |	                  								  |	
				}<-------------------------------------------	                         |                    		MyThread t = new MyThread(r); //This line is called Thread instaintiation 
			}													                         |                    		t.start();// Starting of thread by main thread. 
		}<--------------------------------------------------------------------------------                    		
                                                                                                              		for(int i = 0 ; i<10; i++){<------------
			                                                                                                  			 System.out.println("Main Thread"); |/*Executed by Main Thread */
                                                                                                              		}<---------------------------------------
                                                                                                              	}
                                                                                                              }
    -> We will get mixed output and we can't tell exact output.
    
------------	
 Case_Study 
------------

 ->  
 
	
	MyRunnable r = new MyRunnable();
	Thread t1 = new Thread();
	Thread t2 = new Thread(r);

---------------------
 Case 1: t1.start();
---------------------

	-> A new thread will be created and which is responsible for the execution Thread clas run() method, Which has empty implementation.
	
--------------------    
  Case 2: t1.run();
--------------------
 
  -> No new thread will be created and Thread class run() method will be executed just like normal method call. 
 
-----------------------
  Case 3: t2.start();
-----------------------

  -> A new Thread will be create which is responsible for the execution of MyRunnable class run() method.

--------------------- 
 Case 4: t2.run();
---------------------

  -> A new thread won't be created and MyRunnable class run() method will be executed just like normal method call.

--------------------
 Case 5: r.start();  /
-------------------- 

  -> We will get compile time error saying MyRunnable class doesn't have start() method capability '//CE: Cannot find Symbol, Symbol:strt(), Location: class MyRunnable

-------------------
 Case 6: r.run();
------------------- 

	-> No new Thread will be created and MyRunnable class run() method will be executed like normal method call.
	
	
 -> Which approach is best to define a Thread ?
 
		- Among two ways of defening a thread implements Runnable approach is recomanded.

		- In the first approach our class always extends Thread class, There is no chance of extending any other class hence a we are missing inheritance benifit.
		
		- But in the second approach while implementing Runnable interface we can extends any other class hence a we won't miss any inheritance benifit.
		
		- Because of above resion implementing Runnable interface approach is recomanded then extending thread class.
		
		Ex. 

		class MyThread extends Thread {				class MyRunnable implements Runnable {
			                                        	
			run() {                                 	run(){
				                                    		
			}                                       	}
		}                                           }
		
		// Not Recomanded 							// Recomanded.
		
		
---------------------------		
 Thread class Constructors 
---------------------------
	
		Thread t = new Thread();
		Thread t = new Thread(Runnable r);
		Thread t = new Thread(String name);
		Thread t = new Thread(Runnable r,String name);
		Thread t = new Thread(ThreadGroup g,String name);
		Thread t = new Thread(ThreadGroup g, Runnable r);
		Thread t = new Thread(ThreadGroup g, Runnable r, String name):
		Thread t = new Thread(ThreadGroup g, Runnable r , Stirng name, long stacksize);
		

 

--------------------------------------------------------------
 Durga's Approach To Define a Thread (Not Recomanded to use )
--------------------------------------------------------------


 -> 
 
		class MyThread extends Thread {
			
			public void run() {										Runnable(I)	
																		|	
				System.out.println("Child thread");						|
			}														 Thread 		
		}																|			
																		|
																	MyThread
		classs ThreadDemo {
			
			public static void main(String args[]) {
				
				MyThread t = new MyThread();
				
				Thread t1 = new Thread(t);
				t1.start();
				System.out.println("Main Thread");
			}
		}


		o/p: Child thread 	Main Thread 
			  Main Thread   Child thread 

-------------------------------------------
	Getting and Setting name of a Thread 
-------------------------------------------

	-> Every thread in java has some name it may be default name generated by JVM or customized name provided by programmer.
	
	-> We can get and set name of a Thread by using the following two method of Thread class.
	
			1. public final String getName(){}
			
			2. public final void setName(String name) {}

		Ex. 

		class MyThread extends Thread {
			
			
		}
		
		class Test {
			
			public static void main(String args[]) {
				
				System.out.println(Thread.currentThread().getName()); // main thread name 
				
				MyThread t = new MyThread();
				System.out.println(t.getName()); // Thread-0 it is thread name 
				
				MyThread t2 = new MyThread();
				System.out.println(t.getName()); // Thread-1 it is thread name and generated by JVM 
				
				Thread.currentThread().setName("Baake");
				System.out.println(Thread.currentThread().getName()); // Baake is Current thread name.
				System.out.println(10/0);
				
			}
		}
				
				
 -> 

		class MyThread extends Thread {
			
			public void run() {
					
				System.out.println("This line executed by Thread :"+ Thread.currentThread().getName()):	
			}
		}
		
		
		class Test {
			
			public static void main(String args[]) {
				
				MyThread t = new MyThread();
				t.start();
				System.out.println("This line exeecuted by Thread :"+ Thread.currentThread().getName());
				
			}
		}
































			  






















 
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  
    
    
    
    
 




























 
    