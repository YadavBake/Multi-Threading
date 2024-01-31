
									Multi Threading Part-11 || Inter Thread Communication Part-2
								==================================================================

  
  
  
	class ThreadA {														class ThreadB extends Thread {			
		                                                                
		public static void main(String args[]) throws InterruptedExcepti		int total = 0;on {        
			                                                            		public void run(){
			ThreadB b = new MyThreadB();                                			
			b.start();                                                  			for(int i =0; i<=100; i++) {
			Thread.sleep(10000)	                                        				
			System.out.println(b.total);                                				total = total+i;
		}                                                               			}	
	}                                                                   		}
			                                                            }
                                                        
	
    
 -> Alternative of sleep() method is join() method.

	
    
  class ThreadA {													class ThreadB extends Thread {				  
  	                                                                  
  	public static void main(String args[]) throws InterruptedExcepti		int total = 0;on {          
  		                                                            		public void run(){  
  		ThreadB b = new MyThreadB();                                				
  		b.start();                                                  			for(int i =0; i<=100; i++) {  
  		b.join();                                       	        				total = total+i;	
  		System.out.println(b.total);                                			}
  	}                                                               			// After compliting there 1Cr line code 		
  }                                                                 		}  	
	                                                                }
	
	
	
 -> 

 class ThreadA {														class ThreadB extends Thread {			 
 	                                                                
 	public static void main(String args[]) throws InterruptedExcepti		int total = 0;on {        
 		                                                            		public void run(){
 		ThreadB b = new MyThreadB();                                			
 		b.start();                                                  			for(int i =0; i<=100; i++) {
		b.wait();//RE:IllegalMonitorStateException here 						total = total+i; 
 		System.out.println(b.total);                                			   }	
 	}                                                               			  this.notfy();	//RE: ISME
 }                                                                   		}
 		                                                            }
 
 -> 
 
 	class ThreadA {

	public static void main(String args[])throws InterruptedException {
		
		ThreadB b = new ThreadB();
		b.start();
		//Thread.sleep(10000); //keep on waiting until get notification but it doesn't get notification.
		synchronized(b){
		System.out.println("Main Thread  to call wait() method");
		//b.wait(10000);  to solve this problem wait for 10 Seconds 
		b.wait();// Step -1 // Immeadiatly main thread entered into waitig state. 
		System.out.println("Main Thread got notification"); // Step -4 
		System.out.println(b.total); //Step-5 
		}
	}
 }
	
	
	class ThreadB extends Thread {
		
		int total = 0;
		
		public void run(){
		
		  synchronized(this){

			System.out.println("Child Thread starts calculation"); //Step -2 
			
			for(int i = 0; i<=100; i++){
				
				total = total+i;
			}
			System.out.println("Child Thread giving notification"); // Step -3 
			this.notify();
		  }
		}
	}
	
	OutPut:
	
	Main Thread  to call wait() method
	Child Thread starts calculation
	Child Thread giving notification
	Main Thread got notification
	5050
 ---------------------------
  Producer Comsumer problem 
 ---------------------------
 
  - Producer thread is responsible to produce items to the queue and Consumer thread is responsible to consume items from 
    the queue if queue is empty then consumer thread will wait() method and entered into waiting state.
	
  - After producing items to the queue producer thread is responsible to call notfy() method then waiting consumer will 
	get that notification and continue its execution with updated items.
	
	
	
	
					producing item to queue				  Consuming items from the queue	
  Producer Thread<------------------------------->|	   |<-------------------------------->Consumer Thread 	
	 								       	------|----|-------
	class Producer {                       	|	  |	   |	  |				
                                           	|   ---- ----     |				class ConsumerThread {	
		produces(){                        	|   |  | |  |     |             
			                               	|	---- ----     |             	consumer() {
			synchronized(q){               	|	---- ----     |             		
				                            |   |  | |  |     |             		synchronized(q){
				produces item to            |   ---- ----     |             			if(q is empty){
				queue                      	|	---- ----     |             				q.wait();
				                            |  |  | |  |      |             			}else{
				q.notify();                 |  ---- ----      |             				consume item;
			}                              	|                 |             			}
		}                                  	-------------------	            		}
	}										      Queue                     	}
									   	   Queue q = new Qeueu()            }
 									
 
  ----------------------------------------------
	Difference between notfy() and notifyAll() 
  ----------------------------------------------

  1. We can use notfy() method to give the notification for only waiting thread if multiple threads are waiting then only 
     one thread will be notify and the remaining threads have to wait for further notifications.
	 
  2. Which thread will be notify we can't except it depends on JVM.
  
  
  3. We can use notifyAll() method to give the notification for all waiting threads of a particular object.
  
  4. Even though multiple thread notify but execution will be performe one by one because thread required lock and only
	 one lock available.
	 
	
 Note: 

	- On which object we are calling wait() method thread required the lock of that particular object for example if we 
	  are calling wait() method on 's1' then we have get lock of 's1' object but not 's2' object to call wait() method 
	  on 's1' but not on 's2'
 
	 
										Stack s1 = new Stack();
										Stack s2 = new Stack();
										-----------------------	
													|
					synchronized(s1){				|		synchronized(s1){					
                                                    |                 
						s2.wait();                  |        	s1.wait();
					}                               |        } //valid 
				  //RE:IllegalMonitorStateException |
                                                    |
                                                    |
                                                    |

































  
	

	
	
	
	
	
	
	
	
	
	
	
									
                                    
                                    
									
                                    
                                    
									
									

























 
	    