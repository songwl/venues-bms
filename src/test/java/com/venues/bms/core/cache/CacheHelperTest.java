package com.venues.bms.core.cache;

import org.junit.Test;

import com.venues.bms.BaseTest;
import com.venues.bms.core.cache.impl.MapCache;

public class CacheHelperTest extends BaseTest {

	@Test
	public void testCache() {
		CacheHelper cache1 = MapCache.getInstance();
		CacheHelper cache2 = MapCache.getInstance();

		cache1.put("username", "c1");
		cache1.put("username1", "c11", 5);
		cache2.put("username2", "c22");

		System.out.println("---------");
		System.out.println(cache1.get("username"));
		System.out.println(cache1.get("username2"));

		System.out.println(cache2.get("username"));
		System.out.println(cache2.get("username1"));
		System.out.println("---------");
	}

}
