package com.hazelcast;

import com.hazelcast.core.*;
import com.hazelcast.config.*;

import java.util.Map;
import java.util.Queue;

public class GettingStarted {
	public static void main(String[] args) {
		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
		Map<Integer, String> mapCustomers = instance.getMap("customers");

		mapCustomers.put(1, "Vladi");
		mapCustomers.put(2, "Antoan");
		mapCustomers.put(3, "Stefan");

		System.out.println("Customer with key 1: " + mapCustomers.get(1));
		System.out.println("Map Size:" + mapCustomers.size());

		Queue<String> queueCustomers = instance.getQueue("customers");
		queueCustomers.offer("Miro");
		queueCustomers.offer("Bobi");
		queueCustomers.offer("Kiro");

		System.out.println("First customer: " + queueCustomers.poll());
		System.out.println("Second customer: " + queueCustomers.peek());
		System.out.println("Queue size: " + queueCustomers.size());
	}
}
