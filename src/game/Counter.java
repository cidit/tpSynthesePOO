package game;

/**
 * Class that counts with manual incrementations
 * 
 * @author cidit
 *
 */
public class Counter {
	
	private long count;
	
	private final long ttl;
	
	/**
	 * Constructor
	 * 
	 * @param millis time to live
	 */
	public Counter(long millis) {
		ttl = millis;
		count = 0;
	}
	
	public void count() {
		count++;
	}

	public boolean isExpired() {
		return ttl < count? true: false;
	}
	
	public long getCount() {
		return count;
	}
	
	public long getTimeToLive() {
		return ttl;
	}
	
	public long getCompletion() {
		long inv = ttl/count;
		return 1;
	}

}
