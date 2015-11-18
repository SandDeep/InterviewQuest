package com.design.behavioral.observer;

public class ObserverPatternTest {

	public static void main(String[] args) {
		MyTopic myTopic = new MyTopic();

		// create observers
		Observer obj1 = new MyTopicSubscriber("obj1");
		Observer obj2 = new MyTopicSubscriber("obj2");
		Observer obj3 = new MyTopicSubscriber("obj3");

		myTopic.register(obj1);
		myTopic.register(obj2);
		myTopic.register(obj3);

		// method to attach the Subject to the observer
		obj1.setSubject(myTopic);
		obj2.setSubject(myTopic);
		obj3.setSubject(myTopic);

		// check if any update is available
		obj1.update();
		
		// now send message to subject
		myTopic.postMessage("New Message");
	}
}
