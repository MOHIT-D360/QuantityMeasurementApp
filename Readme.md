# Branch: UC4-Yard-Equality

## 📌 Description
UC4 extends UC3 by adding **YARDS** and **CENTIMETERS** to the `QuantityLength` class.

This demonstrates the scalability of the generic design.  
New units are added by updating only the `LengthUnit` enum — no duplication or restructuring required.

Supported Units:
- FEET
- INCHES
- YARDS (1 yard = 3 feet)
- CENTIMETERS (1 cm = 0.393701 inches)

---

## ✅ Preconditions
- `QuantityMeasurementApp` uses the refactored `QuantityLength` class from UC3.
- Two numerical values with valid units are provided.
- Conversion factors are defined inside `LengthUnit` enum.

---

## 🔄 Main Flow
1. User inputs two values with units (feet, inches, yards, centimeters).
2. Input values are validated.
3. Unit types are validated against the enum.
4. Values are converted to a common base unit.
5. Converted values are compared using `equals()`.
6. Result (`true` / `false`) is returned.

---

## 🎯 Postconditions
- Equality result is returned based on converted values.
- UC1, UC2, and UC3 functionality remains unaffected.
- All cross-unit comparisons are supported.
- No code duplication introduced.

---

## 🛠 Implementation Highlights

### 🔹 LengthUnit Enum Updated
- `YARDS` → conversion factor: 3.0 feet  
- `CENTIMETERS` → conversion factor based on inches (1 cm = 0.393701 in)  

### 🔹 No Changes to QuantityLength
- Existing conversion logic works automatically.
- Generic design handles new units seamlessly.

---



---

## 🧠 Concepts Learned

- Scalability of Generic Design
- Enum Extensibility
- Conversion Factor Management
- Mathematical Accuracy in Unit Conversion
- DRY Principle Validation
- Backward Compatibility
- Cross-Unit Equality
- Precision Handling with Double Comparison

---

## 🔑 Key Concepts Tested

### ✔ Yard Equality
- Yard-to-Yard (same/different values)
- Yard-to-Feet (1 yd = 3 ft)
- Yard-to-Inches (1 yd = 36 in)

### ✔ Centimeter Equality
- Cm-to-Cm
- Cm-to-Inches (1 cm = 0.393701 in)
- Cm-to-Feet / Cm-to-Yard

### ✔ Multi-Unit Transitive Property
If:
- 1 Yard = 3 Feet  
- 3 Feet = 36 Inches  

Then:
- 1 Yard = 36 Inches  

### ✔ Precision & Rounding
- Accurate conversion factors.
- Reliable `Double.compare()` usage.

---

## 🧪 Test Cases

- `testEquality_YardToYard_SameValue()`
- `testEquality_YardToFeet_EquivalentValue()`
- `testEquality_YardToInches_EquivalentValue()`
- `testEquality_CentimetersToInches_EquivalentValue()`
- `testEquality_MultiUnit_TransitiveProperty()`
- `testEquality_AllUnits_ComplexScenario()`
- `testEquality_YardWithNullUnit()`
- `testEquality_CentimetersWithNullUnit()`
- `testEquality_YardSameReference()`
- `testEquality_YardNullComparison()`

---

## 🚀 Architectural Strength

- Only enum modification required for new units.
- No new classes needed.
- Centralized conversion logic.
- Clean, maintainable, scalable system design.
