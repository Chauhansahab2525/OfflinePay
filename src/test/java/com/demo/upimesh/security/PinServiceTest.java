package com.demo.upimesh.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinServiceTest {

    private final PinService pinService = new PinService();

    @Test
    void correctPinShouldReturnTrue() {
        String storedHash = pinService.hashPin("1234");
        String enteredHash = pinService.hashPin("1234");

        assertTrue(
                pinService.verifyPin(enteredHash, storedHash)
        );
    }

    @Test
    void wrongPinShouldReturnFalse() {
        String storedHash = pinService.hashPin("1234");
        String enteredHash = pinService.hashPin("9999");

        assertFalse(
                pinService.verifyPin(enteredHash, storedHash)
        );
    }
}