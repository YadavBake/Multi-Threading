

/*class MyThread extends Thread {
		
		public void run() {
			
			try {
				
				for(int i = 0 ; i<10; i++) {
					
					System.out.println("I am Lazy Thread");
					Thread.sleep(2000);
				}
			}catch (InterruptedException e) {
				
				System.out.println("I got Interrupte");
			}
		}
	}*/
	
	class MyThread extends Thread {							
		                                                  
		public void run() {                               
			                                              
			for(int i = 0; i<=10000; i++) {                
				                                          
				System.out.println("I am Lazy Thread "+i);  
			}                                             
			System.out.println("I want to sleep");        
			try {                                         
				                                          
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				
				System.out.println("I got interrupted  because of Main Thread ");
			}
		}
	}
	class ThreadInterrupteDemo {
		
		public static void main(String args[]) {
			
			MyThread t = new MyThread();
			t.start();
			
			t.interrupt(); // line - 1 This line executed by Main thread 
			System.out.println("End of Main Thread ");
		}
	}
	
			
		