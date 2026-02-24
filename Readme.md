#    Quantity Measurement App 


# Branch: UC1-FeetMeasurement-Equality

## 📌 Description
The `QuantityMeasurementApp` class is responsible for checking the equality of two numerical values measured in **feet**.  
It ensures accurate comparison and handles various edge cases.

---

## ✅ Preconditions
- `QuantityMeasurementApp` class is instantiated.
- Two numerical values in feet are provided for comparison.

---

## 🔄 Main Flow
1. User inputs two numerical values in feet.
2. The class validates that inputs are numeric.
3. The values are compared using the `equals()` method.
4. The result (`true` / `false`) is returned.

---

## 🎯 Postconditions
- Returns `true` if both values are equal.
- Returns `false` otherwise.

---

## 🛠 Implementation Highlights
- Inner `Feet` class represents the measurement.
- Encapsulation using `private final double value`.
- Immutable object design.
- Overridden `equals()` method.
- Uses `Double.compare()` for floating-point comparison.
- Includes proper null and type checking.

---

## 🧠 Key Concepts Covered

### ✔ Equality Contract
- Reflexive
- Symmetric
- Transitive
- Consistent
- Null handling

### ✔ Type Safety
Objects are equal only if they belong to the same class.

### ✔ Floating-Point Comparison
`Double.compare()` is used instead of `==`.

### ✔ Encapsulation & Immutability
Measurement value stored as `private final`.

---

## 🧪 Test Cases
- `testEquality_SameValue()`
- `testEquality_DifferentValue()`
- `testEquality_NullComparison()`
- `testEquality_SameReference()`
- `testEquality_NonNumericInput()`

---


# Branch: UC2-Feet-And-Inches-Equality

## 📌 Description
This Use Case extends **UC1** to support equality checks for **Inches** along with **Feet**.

Feet and Inches are treated as separate entities.  
The system compares:
- Feet-to-Feet
- Inch-to-Inch  

It does NOT compare Feet with Inches directly.

---

## ✅ Preconditions
- `QuantityMeasurementApp` class is instantiated.
- Two numerical values in Feet and Inches are hard-coded for comparison.

---

## 🔄 Main Flow
1. Main method calls a static method for Feet equality validation.
2. Main method calls a static method for Inches equality validation.
3. Static methods instantiate `Feet` and `Inches` objects.
4. Both classes validate numeric input.
5. `equals()` method is called for comparison.
6. Result (`true` / `false`) is returned.

---

## 🎯 Postconditions
- Returns `true` if both values are equal.
- Returns `false` otherwise.
- Supports Feet-to-Feet and Inch-to-Inch comparisons.

---

## 🛠 Implementation Highlights
- Separate `Feet` and `Inches` classes.
- Encapsulation using `private final double value`.
- Immutable object design.
- Overridden `equals()` method in both classes.
- Uses `Double.compare()` for floating-point comparison.
- Proper null and type checking.
- Reduced dependency on `main()` using dedicated static methods.

---

## 🧠 Concepts Learned
- Object Equality
- Floating-Point Comparison
- Null Checking
- Type Checking
- Encapsulation & Immutability

---

## 🔑 Key Concepts Tested
- Equality Contract (Reflexive, Symmetric, Transitive, Consistent, Null-safe)
- Type Safety
- Value-Based Equality
- Null Safety

---

## 🧪 Test Cases
- `testEquality_SameValue()`
- `testEquality_DifferentValue()`
- `testEquality_NullComparison()`
- `testEquality_NonNumericInput()`
- `testEquality_SameReference()`

(Test coverage similar to UC1 for both Feet and Inches.)

---

---

## ⚠ Limitation

### DRY Principle Violation
The implementation violates the **DRY (Don't Repeat Yourself)** principle:

- Same constructor pattern in both classes
- Identical `equals()` implementation
- Same `value` field and logic

This duplication increases maintenance effort and risk of inconsistency.

### Suggested Improvement
Create:
- A generic `Quantity` class  
OR  
- A single class with a unit type parameter  

This would eliminate redundancy and improve maintainability.
