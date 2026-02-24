# Branch: UC5-Unit-Conversion

## 📌 Description
UC5 extends UC4 by introducing explicit **unit-to-unit conversion operations**.

Instead of only checking equality, the `QuantityLength` API now exposes a conversion method:

```java
static double convert(double value, LengthUnit source, LengthUnit target)
```

This method converts a numeric value from a source unit to a target unit using centralized conversion factors defined in the `LengthUnit` enum.

---

## ✅ Preconditions
- `QuantityLength` class and `LengthUnit` enum exist (FEET, INCHES, YARDS, CENTIMETERS).
- Conversion factors are defined relative to a common base unit.
- Input includes:
  - Numeric value
  - Valid source unit
  - Valid target unit

---

## 🔄 Main Flow
1. Client calls `convert(value, sourceUnit, targetUnit)` or instance `convertTo()`.
2. Validate:
   - `value` is finite (`Double.isFinite()`).
   - `sourceUnit` and `targetUnit` are non-null.
3. Normalize value to base unit.
4. Convert from base unit to target unit.
5. Apply precision/rounding handling (if required).
6. Return converted numeric value.

---

## 🎯 Postconditions
- Converted numeric value is returned.
- Invalid inputs throw `IllegalArgumentException`.
- Conversion preserves mathematical equivalence within floating-point tolerance.

---

## 🛠 Conversion Formula

```
result = value × (sourceUnit.factor / targetUnit.factor)
```

All conversions are normalized through the base unit.

---



---

## 🧠 Concepts Learned

- Enum with Conversion Factors
- Immutability & Value Object Semantics
- Method Overriding (`equals()`, `toString()`)
- Method Overloading
- Private Helper & Utility Methods
- Input Validation & Exception Handling
- Floating-Point Precision Handling
- API Design Principles

---

## 🔑 Key Concepts Tested

### ✔ Basic Unit Conversion
- Feet ↔ Inches
- Yards ↔ Feet

### ✔ Cross-Unit Conversion
- Yards ↔ Inches
- Centimeters ↔ Feet

### ✔ Bidirectional Conversion
convert(A → B → A) ≈ original value (within epsilon)

### ✔ Edge Cases
- Zero values
- Negative values
- Large & small magnitudes
- Same-unit conversion
- NaN / Infinite values (exception)

### ✔ Precision Handling
- Uses epsilon (e.g., `1e-6`) for floating-point comparison.

---

## 🧪 Test Cases

- `testConversion_FeetToInches()`
- `testConversion_InchesToFeet()`
- `testConversion_YardsToInches()`
- `testConversion_InchesToYards()`
- `testConversion_CentimetersToInches()`
- `testConversion_RoundTrip_PreservesValue()`
- `testConversion_ZeroValue()`
- `testConversion_NegativeValue()`
- `testConversion_InvalidUnit_Throws()`
- `testConversion_NaNOrInfinite_Throws()`
- `testConversion_PrecisionTolerance()`

---

## 🚀 Architectural Strength

- No code duplication.
- Centralized conversion logic in enum.
- Clean, reusable API.
- Backward compatible with UC1–UC4.
- Easily extendable for future units.
