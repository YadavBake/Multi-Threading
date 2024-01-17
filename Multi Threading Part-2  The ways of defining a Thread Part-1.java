
																		Multi Threading Part-2 || The ways of defining a Thread Part-1
																	====================================================================

--------------------
 Defining  a Thread 
--------------------

 -> We can define a in the following two ways.

	1. By extending Thread class.
	
	2. By implementing Runnable interface.
	

--------------------------------	
	By Extending Thread Class 
--------------------------------

 -> 

																										    class ThreadDemo { 			      
	class MyThread extends Thread {<--------------------------------------------------											
																					 |                      	public static void main(String args[]) {
		public void run() {								                             |                      		
															                         |                      		
			for(int i = 0; i<10;i++) {<------------------	                         |/*=> This called      		MyThread t = new MyThread(); //This line is called Thread instaintiation 
														| Executed by Child thread   |  defining Thread*/   		t.start();// Starting of thread by main thread. 
				System.out.println("Child Thread ");	|==>//This is Job of Thread  |	                    		
			}<-------------------------------------------	                         |                      		for(int i = 0 ; i<10; i++){<------------
		}													                         |                      			 System.out.println("Main Thread"); |/*Executed by Main Thread */
	}<--------------------------------------------------------------------------------                      		}<---------------------------------------
			                                                                                                	}
                                                                                                            }
                                                                                                            		
--------------------------	
 Case 1: Thread Scheduler 	
--------------------------

 -> It is the part of JVM.

 -> It is responsible to schedul Threads that is if multiple threads are waiting to get the chance of execution then which in order threads will be executed is decided by thread scheduler.

 -> We can't except exact algorithm followed by Thread scheduler it is different from JVM to JVM. Hence a we can't except Thread execution order and excat output.
 
 -> Hence a Whenever situation comes to multi Threading there is no guarantee for exact output but we can provide several possible outputs.
 
 -> The following are various possible outputs for the above program.
 
 
	P-1 					p-2 				p-3 				p-4 
	
	Main Thread 		Child Thread 			Main Thread 		Main Thred 
	Main Thread 		Child Thread 			Child Thread 		Main Thread 
	10 times 			10 times 				Main Thread 		Child Thread 
												Child Thread 		Child Thread 
	Child Thread 		Main Thread 				.				Main Thread 
	Child Thread 		Main Thread 				.				Main Thread 
	10 time 			10 times 					.				Child Thread .
	
	
---------------------------------------------------	
 Case 2: Difference Between t.start() and t.run() 
--------------------------------------------------- 

	-> In the case of t.start() new thread will be created which the responsible for the execution run() method.
	
	->But in the case of t.run() a new thread won't be created and run() method will be executed just like a normal method call by main thread.
	
	-> Hence in the above program if we replace t.start() method with t.run() method then the output is.
	
		o/p:
		
			Child Thread 
			Child Thead 
			10 times 
			
			Main Thread 
			Main Thread
			10 time 
		
		- These total output produced by only main Thread. 
		
---------------------------------------------------		
 Case 3: Importance of Thread class start() method 
---------------------------------------------------

 -> Thread class start() method is responsible to registor the thread with Thread scheduler and all other mandatory activities. Hence a without executing thread class start() method there is no 
    chance starting a new thread in java. Due to these thread class start method is considard as heart of Multi Threading.


		start() {
			
			1. Register this thread with Thread scheduler.
			
			2. Performe all other mandatory activities.
			
			3. Invoke run() method.
		}
		
---------------------------------------------------		
  Case 4 : Overloading of run() method.
---------------------------------------------------

	-> Overloading of run() method is always possible but thread class start() method can invoke no-argument run() method the overloaded method we have to call explicitly like normal method call.
	
		Ex. 
	
		class MyThread extends Thread {															class ThreadDemo {
			                                                                                    	
			public void run() {<--------------------------                                      	public static void main(String args[]) {
													     |                                      		
				System.out.println("no-arg run method"); |                                      		MyThread t = new MyThread();
			}											 |/*These 2 method are 	                		t.start();
			public void run(int i ) {					 |  overloaded method*/                 		
														 |                                      	}
				Syste.out.println("int-arg run method"): |                                      } //output: no-arg run method
			}<--------------------------------------------
		}
		
-------------------------------------------------		
  Case 5: If we are not overriding run() method. 		
-------------------------------------------------		
		
	-> 	If we are not overriding run() method then thread class run() method will be executed which has empty implementation. Hence a we won't get any output.
	
	
		class MyThread extends Thread {
			
		}
		class ThreadDemo {
			
			public static void main(String args[]) {
				
				MyThread t = new MyThread();
				t.start();
			}
		}//output: no output 


  Note: It is highly recomanded to override run() method otherwise don't go for multi threading concept.

-------------------------------------------
   Case 6: Overriding of start() method   
-------------------------------------------

	-> If we override start() method then our start() method will be executed just like a normal method and new thread won't be created.
	
		Ex. 
	
	
		class MyThread extends Thread {								class Test {
			                                                        	
			public void start() {                                   	public void static void main(String args[]) {
				                                                    		
				System.out.println("Start method");                 		t.start();
			}                                                       		System.out.println("Main thread");
			public void run() {                                     	}
				                                                    }//Output:Start method| 
				System.out.pritln("run method");                     //		  Main Thread |==> Produced by only main Thread 
			}
		}
		
	Note: It is not recomanded to override start method otherwise don't go for multi threading concept.

	
		Ex. 
		
		
		class MyThread extends Thread {								class Test {
			                                                        	
			public void start() {                                   	public void static void main(String args[]) {
				super.start();                                                    		
				System.out.println("Start method");                 		t.start();
			}                                                       		System.out.println("Main thread");
			public void run() {                                     	}
				                                                    }
				System.out.pritln("run method");                     
        	}														 
        }
		
		possible output for these program.															|
																						----------------------
		p -1 			 p -2 					 p-3 									|				     |
																				   child Thread 	     main Thread 
		run method 		start method		start method  							 |-run method 			|-start method 	
		start method    main method 		run method 														|- main method 
		main method     run method 			main method 
		
		
----------------------------		
 Case 7 : Thread Life cycle 
----------------------------

 -> 
		MyThread t = new MyThread()
	----------------------------------					 -------------------------
   | 								 |					 |						 |
   |								 |  t.start()        |                  	 | If time scheduler allocate process    -------------------  If run() method complite   ----------------
   |	New/Born state 				 |-----------------> |   Ready/Runnable state|-------------------------------------> |	Running state  |---------------------------->|   Dead State | 
   |								 |					 |						 |  									 -------------------							  ---------------
   |								 |					 |						 |	
   |								 |					 -------------------------	
   -----------------------------------



---------------------------------------
 Case 8 : 
--------------------------------------- 

	-> 	 After starting a thread if we are trying to re-start the same thread then we will get runtime exception sayig IllegalThreadStateException
	
		class Test {
			
			public static void main(String args[]) {
				
	
				Thread t = new Thread() ;
				t.start(); //valid 
				System.out.println("main Method");
				t.start();// invalid RE: IllegalThreadStateException
			}
		}
















  
		
 
 
 
	
	
	
	
	
	
	
	
	
	
	