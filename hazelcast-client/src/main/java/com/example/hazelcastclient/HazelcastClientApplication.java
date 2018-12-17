package com.example.hazelcastclient;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

//@SpringBootApplication
public class HazelcastClientApplication {

	public static void main(String[] args) {

//		SpringApplication.run(HazelcastClientApplication.class, args);

        HazelcastInstance hazelcastInstance = getHazelcastInstance();

		CacheRepository cacheRepository = new HazelcastCacheRepository(hazelcastInstance, "test-map");

        System.out.println("Saving 2 records...");
		cacheRepository.save("1", "Record-1");
        cacheRepository.save("2", "Record-2");

        IMap<Object, Object> all = cacheRepository.findAll();
        System.out.println("test-map size: " + all.size());

        System.out.println("Finding record by key 1...");
        Object record1 = cacheRepository.findBy("1");
        System.out.println("Record with key 1 = " + record1);

        System.out.println("Deleting record by key 1...");
        cacheRepository.deleteBy("1");

        all = cacheRepository.findAll();
        System.out.println("test-map size: " + all.size());

        System.out.println("Deleting all records...");
        cacheRepository.deleteAll();

        all = cacheRepository.findAll();
        System.out.println("test-map size: " + all.size());
    }

    private static HazelcastInstance getHazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:5701");
        return HazelcastClient.newHazelcastClient(clientConfig);
    }

}

