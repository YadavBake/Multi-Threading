
									Multi Threading Part-10 || Inter Thread Communication Part-1
								   =================================================================
																
----------------------------
 Inter Thread Communication
----------------------------

 -> Two thread can communicate with each by using wait(), notify(), anf notifyAll() methods.

 -> The thread which is expecting updation is responsible to call wait() method then immeadiatly the 
    thread will entered into waiting state.

 -> The thread which is responsible to performe updation, after performing updation it is responsible to
    call notify()method then waiting thread will get that notification and continue it's execution with 
	those updated items.
	
 -> wait(), notify(), anf notifyAll() methods prasent in object class but not in thread because thread 
    can call this  methods on any java object.  

 -> To call wait(), notify(), notifyAll() methofds on any object, Thread should owner of that object 
    that is the thread should has lock of that object that is the thread should be inside synchronized 
	area.
	
 -> Hence we can call wait(), notify(), and notifyAll() methods only from synchronized area otherwise 
    we will get runtime exception saying IllegalMonitorStateException.											
				
 -> If a thread call wait() method on any object it immeadiatly relieases the lock that particular 
	object and entered into waiting state.
	
 -> If a thread calls notify() method on any object it relieases the lock of that object but may 
    immeadiatly.
	
 -> Except wait(), notify() and notifyAll() there is no other method where thread relieases the lock.	
 
 -> 
	------------------------------------------
	|	Method 		Is Thread relieases lock |
	------------------------------------------	
	|1.  yeild()				No           |
	|                                        |
	|2. join()					NO           |
	|                                        |
	|3. sleep()					NO           |
	|			                             |
	|4. wait()					Yes          |
	|			                             |
	|5. notify()				Yes          |
	|		                                 |
	|6. notifyAll()				Yes          |
	------------------------------------------
 
 -> which of the following valid ?
  
	- If a thread call wait() method immeadiatly it will entered into waiting state without 
	  relieasing any lock ? 
	  
	  invalid 
	
	- If a thread call waits() method it relieases the lock of that object but may not immeadiatly ?
	
		invalid 
		
	- If a thread call wait() method on any object it relieases all locks accured by that thread and 
	  immeadiatly entered into waiting state ?
	  
		invalid 
		
	- If a thread call wait() method on any object it immeadiatly relieases the lock of that particular
	  object and entered into waiting state ?
	  
		valid 	
		
	- If a thread notify() method on any object it immeadiatly relieases the lock that particular 
	  object ? 
	  
		invalid.
		
	- If a thread calls notify() method on any object it relieases that lock of that object but may 
	  not immeadiatly ?
	  
		valid 
		

  
  -> Prototype type these method 
  
		
		public final void wait()throws InterruptedException
		
		public final native void wait(long miliSecond)throws InterruptedException
		
		public final void wait(long miliSecond, int nenoSeconds)throws InterruptedException
		
		
		public final native void notify()
		
		public final native void notifyAll()
		
 Note: 

	- Every wait() method throws InterruptedException which is checked exception.hence a whenever we are using wait() 
	  method compulsory we should handle these InterruptedException. Either by try-catch or by throws keyword. otherwise 
	  we will get compile time error.
	  
	  
		
		
																													---------------------------------	
																	 ------<<--------------<<---------<<------------|   waiting state               |	
    																 |		  					 					|								|  
    						2. if time expires or 					 |			   									---------------------------------  
    						3. if sleeping  thread got Completed	 |			   												^
    																 |			   									  	        |-->obj.wait()
                                                                     |                                                          |-->obj.wait(1000);
    		MyThread t = new MyThread()								 |		  													|-->obj.wait(1000,100);
      --------------------------------				     -------------------------											   	|
      | 							 |					 |						 |											   	|	
      |								 |  t.start()        |                  	 | If thread scheduler allocate process  -------------------  If run() method complite   ----------------
      |	New/Born state 				 |-----------------> |   Ready/Runnable state|-------------------------------------> |	Running state  |---------------------------->|   Dead State |
      |								 |					 |						 |  									 -------------------							  ---------------
      --------------------------------					 -------------------------														
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 	