package com.ihordev.helloworld.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.ihordev.helloworld.model.HelloWorldComponent;
import com.ihordev.helloworld.service.HelloWorldProvider;

public class HelloWorldComponentTest
{

    private HelloWorldComponent helloWorldComponent;
    private HelloWorldProvider mockHelloWorldProvider;
    private String expectedMessage = "Good morning, World!";

    @Before
    public void setUp()
    {
        mockHelloWorldProvider = mock(HelloWorldProvider.class);
        when(mockHelloWorldProvider.getHelloWorld(any(Calendar.class))).thenReturn(expectedMessage);

        helloWorldComponent = new HelloWorldComponent();
        helloWorldComponent.setHelloWorldProvider(mockHelloWorldProvider);
    }

    @Test
    public void testHelloWorldComponent()
    {
        Calendar expectedCurrentTime = Calendar.getInstance(Locale.getDefault());
        String actualMessage = helloWorldComponent.getMessage();

        ArgumentCaptor<Calendar> argument = ArgumentCaptor.forClass(Calendar.class);
        verify(mockHelloWorldProvider, atLeastOnce()).getHelloWorld(argument.capture());

        assertEquals(expectedMessage, actualMessage);
        assertTrue(expectedCurrentTime.getTimeInMillis() - argument.getValue().getTimeInMillis() < 1000);
    }

}
