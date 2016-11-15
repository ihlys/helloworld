package com.ihordev.helloworld.app;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihordev.helloworld.model.HelloWorldComponent;
import com.ihordev.helloworld.service.impl.HelloWorldProviderImpl;

public class Application 
{
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public void start()
	{
    	logger.info("Starting application");
    	try
    	{
    		init();
    		run();
    	} catch(Exception e)
    	{
    		logger.error("Application error: ", e);
    	}
	}
    
	
	private HelloWorldComponent helloWorldComponent;
	
    private void init()
    {	
    	logger.debug("initialized with locale: " + Locale.getDefault().toString());
    	ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.messages", Locale.getDefault());
    	
    	helloWorldComponent = new HelloWorldComponent();
    	helloWorldComponent.setHelloWorldProvider(new HelloWorldProviderImpl(resourceBundle));
    }
    
    private void run()
    {
    	String message = helloWorldComponent.getMessage();
    	
    	System.out.println(message);
    	
    }
}
