package org.example.observer;

import com.alibaba.fastjson2.JSON;

public class ObserverDemo {
	public static void main(String[] args) {
		EventService eventService = new EventServiceImpl();
		Event result = eventService.draw("001");
		System.out.println(JSON.toJSON(result));
	}
}
