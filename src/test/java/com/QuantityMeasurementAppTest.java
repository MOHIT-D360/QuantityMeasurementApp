package com;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // Test 1: Same Value
    @Test
    void testEquality_SameValue() {

        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f2), 
                "Expected 1.0 ft to be equal to 1.0 ft");
    }

    // Test 2: Different Value
    @Test
    void testEquality_DifferentValue() {

        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(f1.equals(f2), 
                "Expected 1.0 ft to NOT be equal to 2.0 ft");
    }

    // Test 3: Null Comparison
    @Test
    void testEquality_NullComparison() {

        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null), 
                "Expected comparison with null to return false");
    }

    // Test 4: Non-Numeric Input (Different Type)
    @Test
    void testEquality_NonNumericInput() {

        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        String nonNumeric = "abc";

        assertFalse(f1.equals(nonNumeric), 
                "Expected comparison with non-numeric object to return false");
    }

    // Test 5: Same Reference (Reflexive Property)
    @Test
    void testEquality_SameReference() {

        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1), 
                "Expected object to be equal to itself (reflexive property)");
    }
}