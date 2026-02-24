# Branch: UC3-Generic-Quantity

## 📌 Description
UC3 refactors the separate `Feet` and `Inches` classes into a single generic `QuantityLength` class.

This eliminates code duplication from UC1 and UC2 and applies the **DRY (Don't Repeat Yourself)** principle.  
The new design supports multiple units using an `enum` and preserves all previous functionality.

---

## ✅ Preconditions
- `QuantityMeasurementApp` is instantiated.
- Two numerical values with their respective unit types (feet, inches, etc.) are provided.
- Conversion factors between supported units are defined as constants.

---

## 🔄 Main Flow
1. User provides two values with unit types.
2. `QuantityLength` validates numeric input.
3. Unit type is validated using `LengthUnit` enum.
4. Both values are converted to a common base unit (feet).
5. Converted values are compared using `equals()`.
6. Result (`true` / `false`) is returned.

---

## 🎯 Postconditions
- Returns equality result based on converted values.
- UC1 and UC2 functionality remains intact.
- Code duplication is eliminated.
- System becomes scalable for new units.

---

## 🛠 Implementation Highlights

### 🔹 LengthUnit Enum
- Defines supported units (FEET, INCH).
- Stores conversion factor relative to base unit (feet).
- Provides type-safe constants.

### 🔹 QuantityLength Class
- Stores `value` and `unit`.
- Converts values to base unit before comparison.
- Overrides `equals()` for cross-unit equality.
- Maintains immutability with `final` fields.

---







## 🔑 Key Concepts Tested

### ✔ Equality Contract
- Reflexive
- Symmetric
- Transitive
- Consistent
- Null-safe

### ✔ Cross-Unit Equality
1 Foot == 12 Inches

### ✔ Type & Unit Safety
Only enum-supported units are allowed.

### ✔ Backward Compatibility
All UC1 and UC2 test cases pass without modification.

---

## 🧪 Test Cases

- `testEquality_FeetToFeet_SameValue()`
- `testEquality_InchToInch_SameValue()`
- `testEquality_InchToFeet_EquivalentValue()`
- `testEquality_FeetToFeet_DifferentValue()`
- `testEquality_InchToInch_DifferentValue()`
- `testEquality_InvalidUnit()`
- `testEquality_NullUnit()`
- `testEquality_SameReference()`
- `testEquality_NullComparison()`

---

## 🚀 Improvement Over UC1 & UC2

- No duplicate code.
- Centralized conversion logic.
- Easy to extend (e.g., add Meter, Centimeter).
- Cleaner and maintainable architecture.
