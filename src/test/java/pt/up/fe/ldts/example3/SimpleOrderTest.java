package pt.up.fe.ldts.example3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SimpleOrderTest {

    @Test
    public void testFixedDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        order.setDiscount(new FixedDiscount(10));
        Assertions.assertEquals(90, order.getTotal(), 0.1);
    }

    @Test
    public void testPercentageDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        order.setDiscount(new PercentageDiscount(0.2));
        Assertions.assertEquals(80, order.getTotal(), 0.1);
    }

    @Test
    public void testNoDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        Assertions.assertEquals(100, order.getTotal(), 0.1);
    }
}