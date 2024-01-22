
																		Multi Threading Part-5 || yield() || join()
																	=================================================



 -> We can privent a Thread excution by using the following Methods :

		1. yield()
		
		2. join()
		
		3. sleep()
		
		
----------------
 yield() Method 
----------------

 -> yield() method couase to pass current executing thread to give the chance for waiting threads of same priority.

 -> If there is no waiting thread or all waiting thread have low priority then same threan  can continue its executing. 
 
 -> If multiple threads are waiting with same priority then which waiting thread will get the chance we can't except it depends on thread schedular.
 
 -> The thread which is yielded, when it will get the chance once again it depends on thread schedular and we can't except exactly.
 
 
	Prototype of yield() method :-
	
	  ------------------------------------
	  |public static native void yield();|
	  ------------------------------------
	  
-> 
																							Thread.yield();
																	---------------------<<--------------------<<---------------
 		MyThread t = new MyThread()									|														   ^
	----------------------------------					 -------------------------											   |	
   | 								 |					 |						 |											   |		
   |								 |  t.start()        |                  	 | If time scheduler allocate process    -------------------  If run() method complite   ----------------
   |	New/Born state 				 |-----------------> |   Ready/Runnable state|-------------------------------------> |	Running state  |---------------------------->|   Dead State | 
   |								 |					 |						 |  									 -------------------							  ---------------
   |								 |					 |						 |	
   |								 |					 -------------------------	
   -----------------------------------
   
   
   
	class MyThread extends Thread {													class ThreadYieldDemo {
		                                                                            	
		public void run() {                                                         	public static void main(String args[]) {
			                                                                        		
			for(int i = 0; i<10; i++) {                                             		MyThread t = new MyThread();
				                                                                    		t.start();
				System.out.println("Child Thread");                                 		for(int i = 0; i<10; i++) {
				Thread.yield(); // line - 1                                         			
			}                                                                       			System.out.println("Main Thread");
		}                                                                           		}
	}                                                                               	}
	                                                                                }
	
	
	-> In the above program if we are commenting line 1 then both threads executed simultaneously and we can't except which thread will complete first.
	
	-> If we are not commenting line 1 then child thread always called yield() method because of that main thread will get chance more number of times and the chance of completing main thread first 
	   is hiegh.
	   
	-> Some platforms won't provide proper support for yield() method.

---------------	
 join() Method 
---------------

 -> If a thread want's to wait until compliting some other thread then we should go for join() method.
 
 -> For example if a thread t1 want's to wait until compliting t2 then t1 has to call t2.join() method.
 
 -> t1 executs t2.join() then imeadiatly t1 will entered in to wating state until compliting t2 complites.
 
 -> Once a t2 compites then t1 can continue it's execution.
 
 
	venue fixing activity 				wedding cards printing 					wedding cards distribution 
			|									  |											|
			|									  |											|
			t1 									  t2 										t3 
			|									  |											|
												t1.join();								  t2.join();		

 -> Wedding cards printing thread(t2) has to wait until venue fixing thread complition hence a t2 has to call t1.join();
 
 -> Wedding cards distribution thread(t3) has to wait until Wedding cards thread complition(t2) hence a t3 has to call t2.join();


	Prototype of join() method 
  ------------------------------
		
		--------------------------
	 1.	|public final void join()| throw InterruptedException
		--------------------------

		-------------------------------------------	
	 2. |public final void join(long milliSeconds)| throws InterruptedException
        -------------------------------------------
		
		----------------------------------------------------------
     3. |public final void join(long milliSeconds,int nanoSecond)| throws InterruptedException
        ----------------------------------------------------------

Note: 
	
	- 	Every join() method throws InterruptedException which is checked exception. Hence a compulsory we should handle this exception either by using try-catch or by throws keyword otherwise we will 
		Compile time error.
																													---------------------------------	
																	 ------<<--------------<<---------<<------------|	waiting state               |	
							1. iF t2 completes or 					 |		  					 					|	Thread got for Block joiing |  
							2. if time expires or 					 |			   									---------------------------------  
							3. if waiting thread gor interrupted	 |			   												^
																	 |			   									  	        |-->t2.join();
                                                                     |                                                          |-->t2.join(1000);
			MyThread t = new MyThread()								 |		  													|-->t2.join(1000,100);
      --------------------------------				     -------------------------											   	|
      | 							 |					 |						 |											   	|	
      |								 |  t.start()        |                  	 | If time scheduler allocate process    -------------------  If run() method complite   ----------------
      |	New/Born state 				 |-----------------> |   Ready/Runnable state|-------------------------------------> |	Running state  |---------------------------->|   Dead State | 
      |								 |					 |						 |  									 -------------------							  ---------------
      |								 |					 |						 |	
      |								 |					 -------------------------	
      -------------------------------




			

		class MyThread extends Thread {						class ThreadJoinDemo {
			                                                	
			public void run() {                             	public static void main(String args[]) throws InterruptedException {
				                                            		
				for(int i = 0; i<10; i++) {                 		MyThread t = new MyThread();
					                                        		t.start();
					System.out.println("Sita Thread");      		
					                                        		t.join(); //----> line -1 
					try {                                   		
						                                    		for(int i = 0; i<10; i++){
						Thread.sleep(2000);                 			
					}catch(InterruptedException e) {        			System.out.println("Ram Thread");
							                                		}
						}                                   	}
					}                                       }
				}
			}


	- If we comment line - 1 both main child thread simultaneously and we can't except exact output.
	
	- If we are not commenting lin - 1 then main thread calls join() method on child thread object hence a main thread will wait until compliting child thread in these case output is 
	  Sita Thread, Sita Thread 10 time followed by Ram Thread, Ram Thread 10 times.
	  
	  
























 
 
	
	
	
	
	
	   
	
	
	
	
	
	
	
	
	
	
			