package me.xfly.leetcode;

import java.util.LinkedHashMap;

public class LeetCode_146 {
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		System.out.println(lruCache.get(4));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(1));

	}
}

class LRUCache {
	LinkedHashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		map = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				boolean tooBig = size() > capacity;
                if (tooBig) {
                    map.remove(eldest.getKey());
                }
               
                return tooBig;
			}
		};
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		map.put(key, value);
	}
}