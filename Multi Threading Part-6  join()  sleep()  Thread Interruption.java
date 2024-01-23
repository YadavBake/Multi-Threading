
															Multi Threading Part-6 || join() || sleep() || Thread Interruption
														========================================================================

 
--------------------------------------------------------------
 Case 2: Waiting of Child Thread until compliting main Thread  
--------------------------------------------------------------

 -> 

	class MyThread extends Thread {												class ThreadJoinDemo {
		                                                                        	
		static Thread mt ;                                                      	public static void main(String args[])  throws InterruptedException {
		                                                                        		
		public void run() {                                                     		MyThread.mt = Thread.currentThread();
			try {                                                               		
				mt.join();                                                      		MyThread t = new MyThread();
			}catch(InterruptedException e){}                                    		t.start();
			for(int i = 0; i<10; i++) {                                         		for(int i = 0; i<10; i++){
				System.out.println("Child Thread");                             			System.out.println("Main Thread");
			}                                                                   			Thread.sleep(2000);
			                                                                    		}
		}                                                                       	}
	}                                                                           }
	
	
 - In the above example child thread calls join() method on main thread object hence child thread has to wait until compliting main thread in these case output is 
	Main Thread Main Thread 10 times followed Child Thread Child Thread 10 times.
	
-------------------
	 Case 3: 
-------------------

	-> If main thread calls join() method on child thread object and child thread calls join() method on main thread object then both threads will wait forever and the programmer will be stucked
		(this is something like deadlock).
		
		Ex. 
	
		class MyThread extends Thread {									class ThreadJoinDemo {
		                                                                	
		static Thread mt ;                                              	public static void main(String args[])  throws InterruptedException {
		                                                                		
		public void run() {                                             		MyThread.mt = Thread.currentThread();
			try {                                                       		
				mt.join();                                              		MyThread t = new MyThread();
			}catch(InterruptedException e){}                            		t.start();
			for(int i = 0; i<10; i++) {                                 		
				System.out.println("Child Thread");                     		t.join();
			}                                                           		
			                                                            		for(int i = 0; i<10; i++){
		}                                                               			System.out.println("Main Thread");
	}                                                                   			Thread.sleep(2000);
	                                                                    		}
	                                                                    	}
	                                                                    }
-----------	
  Case 4: 	
-----------

	-> If a thread calls join() method on the same thread it self then the program will be stucked (These something like deadlock). In these case thread has to wait infinite amount of time.
	
		Ex. 
	
		class Test {
			
			public static void main(String args[]) throws InterruptedException  {
				
				Thread.currentThread().join(); //--> These line executed by main thread.
				---------------------
					  |	
				 Main Thread 
			
			
			
			}
			
		}
		
 
 -------------------- 
	sleep() Method 
 --------------------

   -> If a thread don't want to perform any operation for a particular amount of time then we should gor for sleep() method.
   
		- Singnature of sleep() method 
   
			public static native void sleep(long milliSeconds) throws InterruptedException 
			
			public static void sleep(long milliSeconds, int nanoseconds) throws InterruptedException
  
  Note: Every sleep() method throws InterruptedException, which is checked exception hence a whenever we are using sleep() method compulsory we should handle InterruptedException 	either by try-catch 
		or by throws keywords otherwise we will get compile time error.
		
		
		
		
																													---------------------------------	
    																 ------<<--------------<<---------<<------------|	sleepingstate               |	
																	 |		  					 					|								|  
    						2. if time expires or 					 |			   									---------------------------------  
    						3. if sleeping  thread got Completed	 |			   												^
    																 |			   									  	        |
                                                                     |                                                          |-->Thread.sleep(1000);
    		MyThread t = new MyThread()								 |		  													|-->Thread.sleep(1000,100);
      --------------------------------				     -------------------------											   	|
      | 							 |					 |						 |											   	|	
      |								 |  t.start()        |                  	 | If time scheduler allocate process    -------------------  If run() method complite   ----------------
      |	New/Born state 				 |-----------------> |   Ready/Runnable state|-------------------------------------> |	Running state  |---------------------------->|   Dead State | 
      |								 |					 |						 |  									 -------------------							  ---------------
      |								 |					 |						 |	
      |								 |					 -------------------------	
      -------------------------------




	Ex. 
	
		class SlideRotator {
			
			public static void main(String args[]) throws InterruptedException {
				
				for(int i = 1; i<=1; i++){
					System.out.println("Slide-"+i);
					Thread.sleep(5000);
				}
			}
		}


-----------------------------------------------
  How a Thread can Interrupte another thread.
-----------------------------------------------

 -> A thread can be interrupt a sleeping thread or waiting thread by using Interrupte method of thread class.
 
 
		- public void interrupt() 

	
	class MyThread extends Thread {											class ThreadInterrupteDemo {
		                                                                    	
		public void run() {                                                 	public static void main(String args[]) {
			                                                                		
			try {                                                           		MyThread t = new MyThread();
				                                                            		t.start();
				for(int i = 0 ; i<10; i++) {                                		
					                                                        		t.interrupt(); // line - 1 This line executed by Main thread 
					System.out.println("I am Lazy Thread");                 		System.out.println("End of Main");
					Thread.sleep(2000);                                     	}
				}                                                           }
			}catch (InterruptedException e) {                               
				                                                            		
				System.out.println("I got Interrupte");                     	
			}
		}
	}
	
	- If we comment line - 1 then main thread won't interrupt child thread in this case child thread will execute for loop 10 times.
	
	- If we are not commentig line - 1 then main thread interrupts child thread in this case outout is.
	
			End of Main Thread 
			I am Lazy Thread 
			I got Interrupted.
	
	Note*: Whenever we are calling interrupt() method if the target thread not in sleeping state or waiting state then there is no impect of interrupt call immediatly interrupt call will be waited 
		   until target thread entered into sleeping or waiting state.
		   
		   If the target thread entered into sleeping or waiting state then immediatly interrupt call will interrupt the target thread.
		   
		   
		   If the target thread never entered into sleeping or waiting state in it's life time then there is no impact of interrupt call these is the only case where interrupt call will be waisted.
	
		Ex. 
	
	
		class MyThread extends Thread {												class ThreadInterrupteDemo {
			                                                                        	
			public void run() {                                                     	public static void main(String args[]) {
				                                                                    		
				for(int i = 0; i<10000; i++) {                                      		MyThread t = new MyThread();
					                                                                		t.start();
					System.out.println("I am Lazy Thread ");                        		
				}                                                                   		t.interrupt(); // line - 1 This line executed by Main thread 
				System.out.println("I want to sleep");                              		System.out.println("End of Main");
				try {                                                               	}
					                                                                }
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					
					System.out.println("I got interrupted ");
				}
			}
		}
	
		- In the above example interrupt call waited until child thread complites for loop 10000 times.
		
		
 -------------------------------------------------------------		
	Compairsion table of yield() join() and sleep() methods 
 -------------------------------------------------------------

	--------------------------------------------------------------------------------------------------------------------------------------
	|	Property 				 | 			yield() 			  |			join() 					 |			sleep()					 |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|
	|1. Purpose ? 				 |	If a thread want to pass its  |	 If a thread wants to wait until |  If a thread don't want to perform|
	|							 |	execution to give the chance  |	 compliting some other thread 	 |  any operation for a particular   |
	|							 |	for remaining thread of same  |	 then we should go for join()	 |  amount of time then we should go |
	|							 |	priority then we should go	  |	 method.						 |	for sleep() method               |
	|							 |	for yield() method            |                                  |                                   |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|
	|	                         |                                |                                  |                                   |
	|2. Is it overloaded or not ?|			 No					  |		 Yes 						 |Yes                                |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|	   
	|3. It is final method ? 	 |			No 					  |		 Yes 						 |No                                 |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|
	|4. Is it throws IE ?		 |			No 					  |		 Yes						 |Yes  	                             |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|
	|5. Is it native or not ? 	 |		   Yes 					  |		 No							 |sleep(long ml) Yes is native  	 |
	|							 |								  |									 |sleep(long ml, int ns) No 	     |
	|----------------------------|--------------------------------|----------------------------------|-----------------------------------|
	
	
	
		






































  







 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	