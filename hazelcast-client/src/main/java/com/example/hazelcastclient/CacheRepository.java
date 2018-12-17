package com.example.hazelcastclient;

import com.hazelcast.core.IMap;

public interface CacheRepository {
    void save(String key, Object value);
    Object findBy(String key);
    IMap<Object, Object> findAll();
    void deleteBy(String key);
    void deleteAll();
}