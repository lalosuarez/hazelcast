package com.example.hazelcast;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastApplication.class, args);
		HazelcastInstance hazelcastInstance =
                Hazelcast.newHazelcastInstance(new ClasspathXmlConfig("hazelcast/hazelcast-local.xml"));
	}

}

