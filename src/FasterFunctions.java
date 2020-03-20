
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		
		Thread sortLargeArray = new Thread(()-> {
			System.out.println("Starting to Run sortLargeArray");
			SlowFunctions.slowSortLargeArray();
			System.out.println("Finished Running sortLargeArray");
		});
		Thread ackerMan = new Thread (()-> {
			System.out.println("Starting to Run ackerMan");
			SlowFunctions.ackermann(3, 14);
			System.out.println("Finished Running ackerMan");
		});
		Thread millionsOfSqrts = new Thread(()->{
			System.out.println("Starting to Run millionsOfSqrts");
			SlowFunctions.millionsOfSqrts();
			System.out.println("Finished Running millionsOfSqrts");
		});
		
		sortLargeArray.start();
		ackerMan.start();
		millionsOfSqrts.start();
		
		try {
			sortLargeArray.join();
			ackerMan.join();
			millionsOfSqrts.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
