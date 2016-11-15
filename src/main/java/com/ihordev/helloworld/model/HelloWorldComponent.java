package com.ihordev.helloworld.model;

import java.util.Calendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihordev.helloworld.service.HelloWorldProvider;

/**
 * This class creates a greeting message.
 */

public class HelloWorldComponent {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldComponent.class);
	
	private HelloWorldProvider helloWorldProvider;
	
	/**
	 * Constructs an empty instance.
	 */
	public HelloWorldComponent() {

	}

	/**
	 * Sets the {@link com.ihordev.helloworld.service.HelloWorldProvider}
	 * that provides content for messages.
	 * 
	 * @param helloWorldProvider provider that provides message content.
	 */
	public void setHelloWorldProvider(HelloWorldProvider helloWorldProvider) {
		this.helloWorldProvider = helloWorldProvider;
	}
	
	/**
	 * Constructs an instance with 
	 * {@link com.ihordev.helloworld.service.HelloWorldProvider} set.
	 * 
	 * @param helloWorldProvider provider that provides message content.
	 */
	public HelloWorldComponent(HelloWorldProvider helloWorldProvider) {
		this.helloWorldProvider = helloWorldProvider;
	}

	/**
	 * Creates greeting message.
	 * 
	 * @return message that contains greeting
	 */
	public String getMessage()
	{
		Calendar currentTime = Calendar.getInstance(Locale.getDefault());
		
		logger.debug("currentTime: " + currentTime.getTime());
		
		String message = helloWorldProvider.getHelloWorld(currentTime);
		
		return message;
	}
	
}
