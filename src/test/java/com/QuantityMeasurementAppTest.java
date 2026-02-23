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
    @Test 
    public void testInchesEquality_SameValue() {
    	QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(5.0);
    	QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(5.0);
    	
    	assertTrue(i1.equals(i2));
    }
    @Test
    public void testInchesEquality_NullComoparison() {
    	QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(5.0);
    	
    	assertFalse(inch.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentValue() {
    	QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(5.0);
    	QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(6.0);
    	
    	assertFalse(i1.equals(i2));
    }
    @Test
    public void testInchesEquality_sameReference() {
    	QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(5.0);
    	
    	assertTrue(inch.equals(inch));
    }
    @Test
    public void testInchesEquality_DiffrentClass() {
    	QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(5.0);
    	
    	assertFalse(inch.equals("1"));
    }
}