package com.codeWithElgo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest extends Main{

    @org.junit.jupiter.api.Test
    public void division() {
        assertEquals(2, division(2, 4) );
    }

    @org.junit.jupiter.api.Test
    public void multiplicationo() {
        assertEquals(20, multiplication(10, 2) );
    }
    @org.junit.jupiter.api.Test
    public void addition() {
        assertEquals(12, addition(10, 2) );
    }

    @org.junit.jupiter.api.Test
    public void soustraction() {
        assertEquals(8, soustraction(2, 10) );
    }
}