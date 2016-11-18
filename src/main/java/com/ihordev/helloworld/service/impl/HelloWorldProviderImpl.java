package com.ihordev.helloworld.service.impl;

import java.util.Calendar;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihordev.helloworld.model.HelloWorldComponent;
import com.ihordev.helloworld.service.HelloWorldProvider;

/**
 * This class loads content for greeting messages from resource message file.
 */
public class HelloWorldProviderImpl implements HelloWorldProvider
{
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldComponent.class);

    private static final String RESOURCE_BASENAME = "HelloWorld";
    private static final String MORNING_POSTFIX = "Morning";
    private static final String DAY_POSTFIX = "Day";
    private static final String EVENING_POSTFIX = "Evening";
    private static final String NIGHT_POSTFIX = "Night";

    private ResourceBundle resourceBundle;

    /**
     * Sets the {@link java.util.ResourceBundle} for loading resources.
     * 
     * @param resourceBundle
     *            bundle for loading resources.
     */
    public void setResourceBundle(ResourceBundle resourceBundle)
    {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Constructs an instance with {@link java.util.ResourceBundle} set.
     * 
     * @param helloWorldProvider
     *            provider that provides messages content.
     */
    public HelloWorldProviderImpl(ResourceBundle resourceBundle)
    {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Loads message content that corresponds to current time of day.
     * 
     * @param currentTime
     *            an instance of {@link java.util.Calendar} that represents
     *            current time.
     * @return content for message.
     * @throws IllegalArgumentException
     *             if the specified currentTime is null.
     */
    public String getHelloWorld(Calendar currentTime)
    {
        if (currentTime == null)
        {
            throw new IllegalArgumentException("currentTime argument can't be null");
        }

        String resourceName = RESOURCE_BASENAME;

        int hour = currentTime.get(Calendar.HOUR_OF_DAY);

        if (6 <= hour && hour < 9)
        {
            resourceName += MORNING_POSTFIX;
        } else if (9 <= hour && hour < 19)
        {
            resourceName += DAY_POSTFIX;
        } else if (19 <= hour && hour < 23)
        {
            resourceName += EVENING_POSTFIX;
        } else if (23 <= hour || hour < 6)
        {
            resourceName += NIGHT_POSTFIX;
        }

        logger.debug("generated resourceName: " + resourceName);

        return resourceBundle.getString(resourceName);
    }
}
