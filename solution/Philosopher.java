import java.util.Random;

public class Philosopher extends Thread {
	boolean active = true;

	int eatCount;

	int identity, rightFork, leftFork;

	Fork left;

	Random random;

	Fork right;

	Philosopher(int id, Fork l, Fork r) {
		identity = id;
		left = l;
		right = r;
		leftFork = left.getIdentity();
		rightFork = right.getIdentity();
		random = new Random();
		eatCount = 0;
	}

	public void leave() {
		active = false;
	}

	/**
	 * This method overrides Thread.run().
	 * 
	 * @see java.lang.Thread#run() Call one of the methods runOriginal() [source
	 *      code presented in lecture], runRandom() [implements randomly
	 *      selecting a fork], runCheckFirst() [implements a check to see if the
	 *      second fork can be picked up, if not put down first fork].
	 */
	@Override
	public void run() {
		// runOriginal();
		// runRandom();
		runCheckFirst();
	}

	public void runCheckFirst() {
		try {
			while (active) {
				System.out.printf("Philosopher %d is thinking%n", identity);
				thinking();
				right.getRight();
				System.out
						.printf(
								"Philosopher %d got right fork %d ... looking for left fork %d%n",
								identity, rightFork, leftFork);
				if (!left.isTaken()) {
					left.getLeft();
					eatCount++;
					System.out
							.printf(
									"Philosopher %d got left fork %d and eats for the %d time :-)%n",
									identity, leftFork, eatCount);
					eating();
					left.put();
					right.put();
				} else {
					right.put();
				}
			}
		} catch (InterruptedException ignore) {
		}
	}

	public void runOriginal() {
		try {
			while (active) {
				System.out.printf("Philosopher %d is thinking%n", identity);
				thinking();
				right.getRight();
				System.out
						.printf(
								"Philosopher %d got right fork %d ... looking for left fork %d%n",
								identity, rightFork, leftFork);
				left.getLeft();
				eatCount++;
				System.out
						.printf(
								"Philosopher %d got left fork %d and eats for the %d time :-)%n",
								identity, leftFork, eatCount);
				eating();
				left.put();
				right.put();
			}
		} catch (InterruptedException ignore) {
		}
	}

	public void runRandom() {
		try {
			while (active) {
				System.out.printf("Philosopher %d is thinking%n", identity);
				thinking();
				if (random.nextBoolean()) {
					right.getRight();
					System.out
							.printf(
									"Philosopher %d got right fork %d ... looking for left fork %d%n",
									identity, rightFork, leftFork);
					left.getLeft();
					eatCount++;
					System.out
							.printf(
									"Philosopher %d got left fork %d and eats for the %d time :-)%n",
									identity, leftFork, eatCount);
				} else {
					left.getLeft();
					System.out
							.printf(
									"Philosopher %d got left fork %d ... looking for right fork %d%n",
									identity, leftFork, rightFork);
					right.getRight();
					eatCount++;
					System.out
							.printf(
									"Philosopher %d got right fork %d and eats for the %d time :-)%n",
									identity, rightFork, eatCount);
				}
				eating();
				left.put();
				right.put();
			}
		} catch (InterruptedException ignore) {
		}
	}

	// --- Auxiliary functions (do not change) -------------------------------

	static void eating() {
		if (Math.random() > 0.95) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ignore) {
			}
		}
	}

	static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {
		}
	}

	static void thinking() {
		if (Math.random() > 0.75) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException ignore) {
			}
		}
	}
}