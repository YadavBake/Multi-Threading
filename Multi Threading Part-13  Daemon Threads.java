
										Multi Threading Part-13 || Daemon Threads
									===============================================	
  -----------------									
	Daemon Threads
  -----------------

Q. What is daemon threads ?


   -  The thread which are executing in the background are called daemon threads.

		Ex.
		
			1. GarbageCollector.
			2. SingleDispature.
			3. AttachLitener.
			
Q. What is daemon thread purpose ?			
			
   - The objective of daemon threads is to provide support for non-daemon threads(main thread) for example if main 
	 thread runs with low memory then JVM runs garbage collector to destroyes useless objects so that number of bytes 
	 free memory will be improved with these free memory main thread can continue it's execution.
	 
 -> Useally daemon threads having low priority but based on our requirement daemon threads can run with high priority 
     also.

 -> We can check daemon nature of a thread by using isDaemon() method of thread class.  


	- public boolean isDaemon()
	
 -> We can change daemon nature of a thread by using setDaemon() method. 	
	
	- public void setDaemon(boolean b)
	
	- But changing daemon nature is possible before starting of a thread only. After starting a thread if we are trying 
	  to change nature then we will get runtime exception saying IllegalThreadStateException.
 
 -> What is default nature of thread ?

	- By default main thread is always non-daemon and for all remaining threads daemon nature will be inherited from 
	  parent to child that is if the parent thread is daemon then automatically child thread is also daemon.
	
	- And if the parent thread is non-daemon then automatically child  thread is also non-daemon.
	
	
 Note: 

	It is impossible to change daemon nature of main thread because is already started by JVM at beagining.

		class MyThread extends Thread {
			
		}

		class Test {
			
			public static void main(String args[]){
				
				System.out.println(	Thread.currentThread().isDaemon()); //false 
				//Thread.currentThread().setDaemon(true);//invalid IllegalThreadStateException
				MyThread t = new MyThread();
				System.out.println(	Thread.currentThread().isDaemon()); //false 	
				t.setDaemon(true);//
				System.out.println(t.isDaemon());//	true
				
			}
		}
	

 -> Whenever last non-daemon thread terminates automatically all daemon thread will be terminated Irespective of there 
    possition.


	class MyThread extends Thread {
	
		public void run(){
			
			for(int i =0; i<10; i++){
				
				System.out.println("child thread");
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {}
			}
		}
	}
	
	class DaemonThreadDemo {
		
		public static void main(String args[]) {
			
			MyThread t = new MyThread();
			t.setDaemon(true); ---> line --1 
			t.start();
			System.out.println("End of Main Thread");
		}
		
	}
 	
 -> If we are commenting line 1 both main and child thread are non-daemon and hence a both thread will be executed until 
    there complition.
    
 -> If we are not commenting line 1 then main thread is non-daemon and child thread is daemon hence a whenever main thread 
    terminates automatically child thread will be terminated. 
	
 -> In this case output is :
 
	End of Main Thread 		End of Main Thread      child Thread
	child Thread									End of Main Thread 
	
	
 		