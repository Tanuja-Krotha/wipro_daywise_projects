package com.wiproA.mockitodemov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder() {
        
        OrderService mockOrderService = Mockito.mock(OrderService.class);
        when(mockOrderService.placeOrder("ORD-01")).thenReturn("successful");
        String result = mockOrderService.placeOrder("ORD-01");
        assertEquals("successful", result);
        verify(mockOrderService).placeOrder("ORD-01");
    }
}
