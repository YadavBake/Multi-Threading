
																			Multi Threading Part-4 || Thread Priorities		
																		=================================================
----------------------
   Thread Priorities
-----------------------

	-> Every Thread in java has some priority it may be default priority generated by JVM or customized priority provided by programmer.
	
	-> The valid range of Thread priorities is [ 1 to 10 ] where '1' is MIN_PRIORITY AND '10' is MAX_PRIOPRITY.
	
	-> Thread class defines the following constant to reprasent some standard priorities.
	
			Thread.MIN_PRIORITY --> 1 
			
			Thread.NORM_PRORITY --> 5
			
			ThreaD.MAX_PRORITY -->  10
   
	Thread.LOW_PRIORITY //invalid 
	Thread.HIGH_PRIORITY// invlaid 
	Thread.MIN_PRIORITY // valid 
	Thread.NORM_PRIORITY //valid 
	0 // invalid 
	1 // valid 
	10 // valid 
	
	

-> Thread schedular will use priorities while alocating processor.

-> The thread which is having highest priority will get chance first.

-> If two threads having same priority then we can't accept exact execution order it's depend thread schedular.

-> Thread class defines the following methods to get and set priorities of a thread.

	public final int getPriority(){}
	
	public final void setPriority(int p );
								  ------	
									|--> Allowed values range[1 to 10] otherwie we will get RE: IllegalArgumentException.
									
	Ex. 
	
	t.setPriority(7); //valid 
	t.setPriority(19); // invalid RE: IllegalArgumentException.
	
 ---------------------
	Defualt Priority 
----------------------

 -> The default priority only for the main thread is '5'.

 -> But for all remaining threads default priority will be inheritated from parent to child that is whatever priority parent thread has the same priority will be there for the child thread.

 -> 

	Ex. 
	
		class MyThread extends Thread {
			
		}
		
		class Test {
			
			public static void main(String args[]) {																	Thread 		Main Thred	
				                                                                                                          ^				^	 
				System.out.println(Thread.currrentThread.getPriority()); //5                                              | parent	    | parent 
				                                                                                                          |	class		| Thread 
				//Thread.currrentThread.setPriority(15); //invalid RE: IllegalArgumentException                         ----------------------
				                                                                                                        |	MyThread t =     |
				Thread.currrentThread.setPriority(7);  // line - 1                                                      |	new MyThread()   |
				MyThread t = new MyThread();                                                                            ----------------------
				System.out.println(t.getPriority()); //7 
			}
		}
	
	 - If we comment line - 1 then child thread priority will become 5.
	 
	 
	 
	 class MyThread extends Thread {						class ThreadPriorityDemo {
		                                                    	 
		 public void run() {                                	 public static void main(String args[]) {
			                                                		 
			for (int i = 0 ; i<10 ; i++) {                  		 MyThread t = new MyThread();
				                                            		 t.setPriority(10); // line - 1 
				System.out.println("Child Thread");         		 t.start();
									                        		 
		 }                                                  		 for(int i = 0; i<10 ; i++){
	 }                                                      			 
	                                                        			 System.out.pritln("Main Thread");
	                                                        		}
	                                                        }
	
	
	 - If we are commenting line - 1 then both main and child threads have the same priority 5 and hence we can't except executiong order and exact output.
	 
	 - If we are not commenting line - 1 then main thread  has a priority 5 and child thread has a priority 10 hence a child thread will get the chance first followed by main thread in this case 
	   output is Child Thread, Child Thread 10 times followed by Main Thread, Main Thread 10 times.
	   
	Note: Some platforms won't provide proper support for Thread priorities.

	
		 
		 
	
	
	
	
	
	




































	
	
	