
										Multi Threading Part-12 || DeadLock || Starvation
									 ======================================================

 -----------
  DeadLock	
 -----------

 -> If two threads are waiting for each other forever such type of infinite waiting is called DeadLock.

 -> synchronized keyword is the only resion for DeadLock situation hence a while using synchronized keyword we have to 
	take special care.
	
 -> There are no resolution techniques for DeadLock but serveral prevention techniques are available.
 
 -> 
 
 
				class  A {											class B {					
																		
					synchronized d1(B b ){      				    	
																	synchronized d2(A a ) {
							b.last();           				    		
																			a.last();
						}                       				    		
																		}
					synchronized last() {       				        synchronized last(){
																			
																		}
						}                       				    }
				}							
				
					  
		        	--------							--------
	            	|	   |	                		|	   |	
	            	|  a   |<------t1->lock(a)			|  b   |<------t2--> lock(b)   
	            	|	   |	.d1(b){         		|	   |	.d2(a){
	            	--------	 {              		--------	 {
	            				}               					}
	              /*t1-> will entered into wating 		t2-> will entered into wating 
	              waiting state  to get 'b's lock       waiting state  to get 'a's lock
	              and currently t1 holds 'a's lock      and currently t2 holds 'b's lock*/
	            							            							
	
	class A {

		public synchronized void d1(B b){
			
			System.out.println("Thread one start execution d1() method");

				try {
					
					Thread.sleep(5000);
				}catch(InterruptedException e){
					
				}
				
				System.out.println("Thread one trying to call B's last Method");
				
				b.last();
		}
		
		public synchronized void last(){
			
			System.out.println("Inside A's last() method");
		}
	}


	class B {
    
    	public synchronized void d2(A a){
    		
    		System.out.println("Thread two start execution d2() method");
    
    			try {
    				
    				Thread.sleep(5000);
				}catch(InterruptedException e){	
    				
    			}
    			
    			System.out.println("Thread two trying to call A's last Method");
    			
    			b.last();
    	}
    	
    	public synchronized void last(){
    		
    		System.out.println("Inside B's last() method");
    	}
    }
	
	
	class DeadLock extends Thread {
		
			A a = new A();
			B b = new B();
			
			public void m1(){
				
				this.start();
				a.d1(b); // This line executed by main thread 
				
			}
			
			public void run(){
				
				b.d2(a); // This line executed by child thread.
			}
			
		
		public static void main(String args[]){
			
			DeadLock t = new DeadLock();
			// We can did not take here t.start() method because here the problems is 	suppose i can take t.start() method 
			// after t.start() method know main thread is responsible to call a.d1() method but 'A' and 'B' are instance
			// variables and instance variables we can't access directly 	from static area that's why problem is coming 
			// in the middle we can take instance method from that we call start method using 'this.start();
			t.m1();
			
		}
	}		
	
		output:

		Thread one start execution d1() method
		Thread two start execution d2() method
		Thread two trying to call A's last Method
		Thread one trying to call B's last Method	
			
 -> In the above program if we remove at list one synchronized keyword then the program won't into deadlock. Hence a 
	synchronized keyword is only resion for deadlock situation. Due to this while using synchronized keyword we have 
	take special care.
	
 ------------------------
  DeadLock Vs Starvation
 ------------------------

 -> Long wating of a thread where waiting never ends is called DeadLock.

 -> Where as long waiting of a thread where waiting ends at cirtain point is called Starvation.

	For example:
	
		- Low priority has to wait until compliting all high priority threads it may be long waiting 
		  but ends at cirtain point, which nothing but Starvation.





















	
		
			
			