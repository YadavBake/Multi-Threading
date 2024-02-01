
								Multi Threading Part-14 || Green Thread,stop(),suspend(),resume()	
							=======================================================================

 ----------------
   Green Thread 
 ----------------

  -> Java multi-Threading concept  is implmented by using the following two models .

												|
						-----------------------------------------------------							
						|													|
			1. Green Thread Model 						 		 2. Native OS Model 	
			
			
 ---------------------			
   Green Thread Model  
 ---------------------
 
  -> The thread which is managed compliting by JVM without taking underlaying OS support is called green thread.
  
  -> Very few operating system like Sun Solaries provide support for green thread model.
  
  -> Any why green thread model is depricated and not recomanded to use.
  
 ---------------- 
  Native OS Model
 ----------------
 
  -> The thread which is managed by the JVM with help of underlaying OS, is called native OS model.

  -> All window based operating systems provide support for native OS model


 -----------------------
  How to stop a Thread  
 -----------------------

  -> We can stop a thread execution by using stop() of thread class.

		- public void stop()
		
  -> If we call stop() method the immeadiatly the thread will entered into dead state any way stop() method is 
	 deprecated and not recomanded to use.
	 
--------------------------------------
  How to Suspand and resume of Thread 
--------------------------------------

  -> We can suspend a thread by using suspend() method of thread class then immeadiatly the thread will be entered into 
     suspended state.

  -> We can resume a suspended thread by using resume() method of thread class then suspended thread can continue its 
     execution.

		- public void suspend()
		
		- public void resume()
	 
  -> Any way these method are deprecated not recomanded to use.


											=====================================================			
												    COMPLITE THREAD LIFE CYCLE 
											=====================================================





																							  ----------------	
														--------<<-----------------<<-------- |				 |
                                                        |1.If time expires.					  |Sleeing state |-----------<<------- 			
                                                        |2.If sleeping thread got interrupted.----------------					 |
														|									  ----------------------			 |	
														|	-----<<-----------------<<------- |Entered into waiting|----<<---    |
														|	|1. It t2 complities.			  |blocked for joining | 		|    |
														|	|2. If time expire.				  -------------------t1.join()<-|    |
														|	|3. If thread got interrupted. 					t1.join(ms)	  <-|	 |					
                                                        |   |                            Thread.yield();    t1.join(ms ns)<-|    |        
 		MyThread t = new MyThread()						|	|	|---------------<<--------------<<--------------<<--------	|    |->Thread.sleep(1000)													
   --------------------------------				     -------------------------											 ^  |    |->Thread.sleep(1000,100)
   | 							  |					 |						 |											 |  |	 |						
   |							  |  t.start()       |                  	 | If thread scheduler allocate process  -------------------  If run() method complite   ----------------	 
   |	New/Born state 			  |------->>-------->|   Ready/Runnable state|--------------->>--------------------> |	Running state  |---------------------------->|   Dead State |	 
   |							  |				 --->|						 |  									 -------------------							  ---------------	 
   --------------------------------				 |	 -------------------------									  		 	 |	|	|   	 								^
												 |	  ^                                                         obj.wait();<-|  |   |										|
												 |	  |-> If waiting thread got lock.						obj.wait(1000);<-|  |   |---->>------------->>----------->>------
	                                             |    |                                                 obj.wait(1000,100);<-|  |				t.stop()
												 |	  |				1.If waiting thread got notification ---------------     |  |               
												 |	  |				2.If time expires					 |				|<----	| 
												 |	  |				3.If waiting thread got interrupted  |Sleeing state |       |
												 |	  |								^				     ----------------	    |
												 |	-----------------				|					  |						|
	                                             |  |Another waiting|				|					  |						|
	                                             |  | to get lock   |<-----<<--------------<<--------------						|
	                                             |   ---------------- 															|
	                                             |														----------------- 		|	
												 |				t.resume()						        |			    |<-------
	                                             |--------<<----------------------<<--------------------|suspended state|
	                                                                                                    ----------------
	                                             
	                                             
	 
	 
	 
	 
	 
	 