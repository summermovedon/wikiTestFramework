package e2e.data;

import java.util.concurrent.ConcurrentHashMap;

public class DataProvider {

    private static ConcurrentHashMap<String, Object> data = new ConcurrentHashMap<>();

    public static void set(String key, Object value) {
        if (data.containsKey(key)) {
            throw new RuntimeException("Cannot set the key");
        }
        data.put(key, value);
    }

    public static Object get(String key) {
        if (!data.containsKey(key)) {
            throw new RuntimeException("No such key");
        }
        return data.get(key);
    }

    public static void update(String key, Object value) {
        if (!data.containsKey(key)) {
            throw new RuntimeException("No such key");
        }
        data.put(key, value);
    }
    
}
