package org.erhmutlu.kata.mru;


import java.util.LinkedHashMap;
import java.util.Map;

public class MostRecentlyUsedCacheKata {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        myCache.put("1", "1");
        myCache.put("2", "2");
        myCache.put("3", "3");
        myCache.put("4", "4");
        myCache.put("5", "5");
        System.out.println(myCache.size());
        myCache.put("6", "6");
        System.out.println(myCache.size());
    }
    static class MyCache extends LinkedHashMap<String, String> {

        private static final int MAX_ENTRIES = 5;

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }

}
