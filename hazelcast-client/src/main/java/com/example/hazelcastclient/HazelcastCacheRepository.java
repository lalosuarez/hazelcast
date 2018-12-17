package com.example.hazelcastclient;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelcastCacheRepository implements CacheRepository {

    private IMap<Object, Object> map;

    private HazelcastInstance hazelcastInstance;

    public HazelcastCacheRepository(HazelcastInstance hazelcastInstance, String mapName) {
        this.hazelcastInstance = hazelcastInstance;
        map = hazelcastInstance.getMap(mapName);
    }

    /**
     * This method overrides a method already defined in a parent class and defines how it will be executed for the CacheRepository class.
     *
     * @see CacheRepository#save(String, Object)
     * @since R1707
     */
    @Override
    public void save(String key, Object value) {
        if (map == null)
            return;

        map.put(key, value);
    }

    /**
     * This method overrides a method already defined in a parent class and defines how it will be executed for the CacheRepository class.
     *
     * @see CacheRepository#findBy(String)
     * @since R1707
     */
    @Override
    public Object findBy(String key) {
        if (map == null)
            return null;

        return map.get(key);
    }

    /**
     * This method overrides a method already defined in a parent class and defines how it will be executed for the CacheRepository class.
     *
     * @see CacheRepository#findAll()
     * @since R1707
     */
    @Override
    public IMap<Object, Object> findAll() {
        if (map == null)
            return null;
        return map;
    }

    /**
     * This method overrides a method already defined in a parent class and defines how it will be executed for the CacheRepository class.
     *
     * @see CacheRepository#deleteBy(String)
     * @since R1707
     */
    @Override
    public void deleteBy(String key) {
        if (map == null)
            return;

        map.remove(key);
    }

    /**
     * This method overrides a method already defined in a parent class and defines how it will be executed for the CacheRepository class.
     *
     * @see CacheRepository#deleteAll()
     * @since R1707
     */
    @Override
    public void deleteAll() {
        if (map == null)
            return;

        map.evictAll();
    }
}
