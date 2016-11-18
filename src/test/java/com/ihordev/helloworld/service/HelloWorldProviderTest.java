package com.ihordev.helloworld.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ihordev.helloworld.service.impl.HelloWorldProviderImpl;

@RunWith(value = Parameterized.class)
public class HelloWorldProviderTest
{

    private String expectedHelloWorld;
    private Calendar testTimeOfDay;

    @Parameters
    public static Collection<Object[]> getTestParameters()
    {
        Locale enLocale = new Locale.Builder().setLanguage("en").setRegion("EN").build();

        return Arrays.asList(new Object[][] {
                { "Good morning, World!", new Calendar.Builder().setLocale(enLocale).setTimeOfDay(6,  15, 0).build() },
                { "Good morning, World!", new Calendar.Builder().setLocale(enLocale).setTimeOfDay(8,  35, 0).build() },
                { "Good day, World!",     new Calendar.Builder().setLocale(enLocale).setTimeOfDay(13, 25, 0).build() },
                { "Good evening, World!", new Calendar.Builder().setLocale(enLocale).setTimeOfDay(20, 45, 0).build() },
                { "Good night, World!",   new Calendar.Builder().setLocale(enLocale).setTimeOfDay(2,  32, 0).build() },
                { "Good night, World!",   new Calendar.Builder().setLocale(enLocale).setTimeOfDay(23, 45, 0).build() } 
        });
    }

    public HelloWorldProviderTest(String expectedMessage, Calendar testTimeOfDay)
    {
        this.expectedHelloWorld = expectedMessage;
        this.testTimeOfDay = testTimeOfDay;
    }

    private HelloWorldProvider helloWorldProvider;

    @Before
    public void setUp()
    {
        ResourceBundle testResourceBundle = ResourceBundle.getBundle("properties.messages",
                new Locale.Builder().setLanguage("en").setRegion("EN").build());

        helloWorldProvider = new HelloWorldProviderImpl(testResourceBundle);
    }

    @Test
    public void shouldProvideHelloWorldAccordingToTimeOfDay()
    {
        String actualHelloWorld = helloWorldProvider.getHelloWorld(testTimeOfDay);

        assertEquals(expectedHelloWorld, actualHelloWorld);
    }

}
