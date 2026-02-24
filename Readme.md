
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
