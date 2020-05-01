

public class HelloWorldThread extends Thread {


	@Override
	public void run(){
		try {
			System.out.print("Hello ");
			this.sleep(5000);
			System.out.print("World.");		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
