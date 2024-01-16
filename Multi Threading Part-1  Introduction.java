
																			Multi Threading Part-1 || Introduction	
																		==============================================

----------
  Agenda 
----------

 1. Introduction.
 2. The ways to define a Thread.
		
		1. By extending Thread class .
		2. By implementing Runnable(I).
		
 3. Getting and Seting Name of The Thread.State
 4. Thread Priorities.
 5. The methods to prevent Thread execution.

		1. Yield() method. 
		2. join() method.
		3. sleep() method.
 
 6. Synchronization.
 7. Inter Thread Communication.
 8. DeadLock.
 9. Deamon Threads.
10. Multi Threading Enhancemnents.

=======================================================================================================================================================================================================

																					1. Introduction 
																				---------------------
---------------
 Multi-Tasking
--------------- 

 -> Executing several task  simultaneously  is the concept of multitasking.
 
 -> There are Two type of multitasking.
 
		1. Process Based Multi-Tasking.
		
		2. Thread Based Multi-Tasking.
		
-------------------------------
  Process Based Multi-Tasking
-------------------------------

 -> Executing serveral task simultaneously where each task is a seprate independent program(Process), is called Process Based Multi-Tasking.

	Ex. 
	
		1. While type a java program in th editor we can listen audio songs from the same the system at the same time we can download a file from net all these tasks will be excuted simultaneously
		   and independent of each other hence a it is process based multitasking.
		   
		   
		2. Process Based Multi-Tasking is best suitable at OS(oeprating System) level.
		
-----------------------------		
 Thread Based Multi-Tasking
-----------------------------

	1. Executing serveral task simultaneously where each task is a seprate independent part of the same program is called Thread based Multi-Tasking and each independent part is called a thread.
	
	2. Thread based Multi-Tasking is best suitable at programetic level.
	
	
	
-> Whether it is process based or thread based the main objective of multitasking is to reduce response time of the system and to improve performance of the System.

-> The main important application areas of multithreading are:

		1. To develop mutli media graphics.
		
		2. To develop animations.
		
		3. To develop video games.
		
		4. To develop Web servers and Application servers ect.

-> When compaired with old langauges developing multithreaded applications in java is very easy because java provide inbuild support for multithreading with reach API (Thread,Runnable,ThreadGroup..).
 

		
 







































