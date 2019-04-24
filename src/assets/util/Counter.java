package assets.util;

/**
 * Class that counts with manual incrementations.
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
	 * @param millis time to live before expiration (enter Long.MAX_VALUE for no
	 *               expiration)
	 */
	public Counter(long millis) {
		ttl = millis;
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

	/**
	 * Returns the count.
	 * 
	 * @return count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * Returns the maximum amount of incrementations allowed before expiration.
	 * 
	 * @return time to live
	 */
	public long getTimeToLive() {
		return ttl;
	}

	/**
	 * Returns a floating-point number between 0 and 1 representing the ratio of
	 * completion of the counter.
	 * 
	 * @return progression
	 */
	public float getProgression() {
		return (float) count / ttl;
	}

}
