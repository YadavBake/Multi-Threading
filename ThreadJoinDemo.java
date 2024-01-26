

/*class MyThread extends Thread {
	
	public void run() {
		
		for(int i = 0; i<10; i++) {
			
			System.out.println("Sita Thread");
			
			try {
				
				Thread.sleep(2000);
			}catch(InterruptedException e) {
					
				}
			}
		}
	}


class ThreadJoinDemo {
	
	public static void main(String args[]) throws InterruptedException {
		
		MyThread t = new MyThread();
		t.start();
		
		t.join(10000);
		
		for(int i = 0; i<10; i++){
			
			System.out.println("Ram Thread");
		}
	}
} */

class MyThread extends Thread {
		
		static Thread mt ;
		
		public void run() {
			try {
				mt.join();
			}catch(InterruptedException e){}
			for(int i = 0; i<10; i++) {
				System.out.println("Child Thread");
			}
			
		}
	}
	
	class ThreadJoinDemo {
		
		public static void main(String args[])  throws InterruptedException {
			
			MyThread.mt = Thread.currentThread();
			
			MyThread t = new MyThread();
			t.start();
			t.join();
			for(int i = 0; i<10; i++){
				System.out.println("Main Thread");
				Thread.sleep(2000);
			}
		}
	}