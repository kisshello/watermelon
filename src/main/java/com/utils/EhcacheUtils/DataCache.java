package com.utils.EhcacheUtils;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class DataCache {

	private final Ehcache cache;

	private static final DataCache dataCache = new DataCache();

	public static DataCache getInstance() {
//		if (dataCache == null) {
//			dataCache = new DataCache();
//		}
		return dataCache;
	}

	private DataCache() {
		CacheManager manager = CacheManager.getInstance();
		this.cache = manager.getCache("sampleCache1");
	}

	/*
	 * read some data - notice the cache is treated as an SOR. the application
	 * code simply assumes the key will always be available
	 */
	public Object readData(Object key) {
		Element element = cache.get(key);
		if (element == null) {
			return null;
		}
		return element.getObjectValue();
	}

	/*
	 * write some data - notice the cache is treated as an SOR, it is the
	 * cache's responsibility to write the data to the SOR.
	 */
	public void writeData(Object key, Object value) {
		cache.put(new Element(key, value));
	}
	
	public static void main(String[] args) {
		DataCache.getInstance().writeData("name", "asasa");
		
		Object object = DataCache.getInstance().readData("name");
		
		System.err.println("obj:" + object);
		
		
		
	}
}
