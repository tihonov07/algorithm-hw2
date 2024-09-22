package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    void findMaxDigits() {
        var tree = new HomeWork();
//        5, 3, 1, 2, 4, 8, 7,6,10,9
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(10);
        tree.add(9);



        assertEquals(List.of(8, 7, 6), tree.findMaxDigits(3, 8));
        assertEquals(List.of(4, 3, 2), tree.findMaxDigits(3, 4));
        assertEquals(List.of(4, 3, 2, 1), tree.findMaxDigits(4, 4));
        assertEquals(List.of(10, 9, 8, 7), tree.findMaxDigits(4, 10));
    }
}