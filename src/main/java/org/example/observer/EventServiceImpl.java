package org.example.observer;

import java.util.Date;

public class EventServiceImpl extends EventService{

	@Override
	public Event doDraw(String uid) {
		String msg = "user uid's messages";
		System.out.println("System sends messages to user " + uid);
		return new Event(uid, msg, new Date());
	}

}
