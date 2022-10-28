package com.demo.service;

import com.demo.domain.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @InjectMocks
    EmailService emailService;

    @Mock
    Order order;

    @Before
    public void setUp() {
        System.out.println("Test Case Starts...");
    }

    @Test
    public void sendEmailBooleanTest() {
        boolean result = emailService.sendEmail(order, "test");
        verify(order, atLeast(1)).setCustomerNotified(true);
        Assert.assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void sendEmailVoidTest() {
        emailService.sendEmail(order);
        verify(order, atLeast(1)).setCustomerNotified(false);
    }

    @After
    public void close() {
        System.out.println("Test Case Finished...");
    }
}