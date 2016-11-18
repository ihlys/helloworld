package com.ihordev.helloworld.service;

import java.util.Calendar;

/**
 * Interface for providing greeting messages content.
 */
public interface HelloWorldProvider
{

    /**
     * Loads message content that corresponds to current time of day.
     * 
     * @param currentTime
     *            an instance of {@link java.util.Calendar} that represents
     *            current time.
     * @return content for message.
     */
    String getHelloWorld(Calendar currentTime);

}
