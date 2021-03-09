package com.github.wongoo.dubbo.hello;

import java.util.HashMap;
import java.util.Map;

public class AccessMap extends HashMap<String, Object> {

    public AccessMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public AccessMap(int initialCapacity) {
        super(initialCapacity);
    }

    public AccessMap() {
    }

    public AccessMap(Map<? extends String, ?> m) {
        super(m);
    }

    public static AccessMap create() {
        return new AccessMap();
    }

    public static AccessMap create(Map<String, Object> m) {
        return new AccessMap(m);
    }

    public static AccessMap create(String key, Object value) {
        AccessMap map = new AccessMap();
        return map.set(key, value);
    }

    ////

    public AccessMap set(String key, Object value) {
        put(key, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) super.get(key);
    }

    public <T> T getEnsureType(String key, Class<T> type) {
        return get(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T getOrDefault(String key, T defaultValue) {
        return (T) super.getOrDefault(key, defaultValue);
    }

}
