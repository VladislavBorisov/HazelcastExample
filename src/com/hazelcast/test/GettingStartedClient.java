package com.hazelcast.test;

import com.hazelcast.client.config.ClientConfig;

import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class GettingStartedClient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("192.168.1.62:5704");
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		IMap<Object, Object> map = client.getMap("customers");
		System.out.println("Map Size:" + map.size());

		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		System.out.println(clientConfig.getAddresses());
	}
}
