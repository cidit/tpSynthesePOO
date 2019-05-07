package assets.util;

/**
 * Counter that counts with manual incrementations. The maximal amount of
 * incrementations possible is Long.MAX_VALUE;
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
	 * @param ttl time to live before expiration (enter Long.MAX_VALUE for no
	 *            expiration)
	 */
	public Counter(long ttl) {
		this.ttl = ttl;
		count = 0;
	}

	/**
	 * Increments the counter.
	 */
	public void count() {
		count++;
	}

	/**
	 * Verifies the validity of the counter.
	 * 
	 * @return true if the count is
	 */
	public boolean isExpired() {
		return ttl < count ? true : false;
	}

}
