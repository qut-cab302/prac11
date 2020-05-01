public class Fork {
	private int identity;

	private boolean taken = false;

	Fork(int id) {
		identity = id;
	}

	/**
	 * Accessor for the taken field.
	 * 
	 * @return the taken
	 */
	public boolean isTaken() {
		return taken;
	}

	synchronized int getIdentity() {
		return identity;
	}

	synchronized void getLeft() throws InterruptedException {
		while (taken) {
			wait();
		}
		taken = true;
	}

	synchronized void getRight() throws InterruptedException {
		while (taken) {
			wait();
		}
		taken = true;
	}

	synchronized void put() {
		taken = false;
		System.out.printf("Fork %d is put down%n", identity);
		notify();
	}
}