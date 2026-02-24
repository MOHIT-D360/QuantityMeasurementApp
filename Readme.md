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


# Branch: UC5-Unit-To-Unit-Conversion

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

# Branch: UC6-Addition

## 📌 Description
UC6 extends UC5 by introducing **addition operations** between length measurements.

The `QuantityLength` API now supports adding two length values (possibly in different units) and returning the result in the **unit of the first operand**.

Example:
1 Foot + 12 Inches = 2 Feet

---

## ✅ Preconditions
- `QuantityLength` and `LengthUnit` enum exist (FEET, INCHES, YARDS, CENTIMETERS).
- Conversion factors are defined relative to a consistent base unit.
- Two valid `QuantityLength` objects (same category: length).
- All values are finite numbers.

---

## 🔄 Main Flow
1. Client calls:
   ```java
   add(QuantityLength length1, QuantityLength length2)
   ```
   or overloaded version.

2. Validate:
   - Operands are non-null.
   - Units are valid.
   - Values are finite.

3. Convert both values to base unit.
4. Add converted values.
5. Convert sum to unit of first operand.
6. Return a **new QuantityLength object** (immutability preserved).

---

## 🎯 Postconditions
- Returns new `QuantityLength` object with sum.
- Original operands remain unchanged.
- Invalid inputs throw `IllegalArgumentException`.
- Addition respects floating-point precision limits.
- Addition is mathematically commutative.

---



---

## 🧠 Concepts Learned

- Arithmetic on Value Objects
- Reuse of Conversion Infrastructure (UC5)
- Base Unit Normalization
- Immutability & Functional Design
- Method Overloading
- Factory-style Object Creation
- Precision Handling (epsilon comparison)
- Type Safety & Validation
- Mathematical Properties (Commutativity, Identity)

---

## 🔑 Key Concepts Tested

### ✔ Same-Unit Addition
1 ft + 2 ft = 3 ft

### ✔ Cross-Unit Addition
1 ft + 12 in = 2 ft

### ✔ Commutativity
add(A, B) == add(B, A)

### ✔ Identity Element
5 ft + 0 in = 5 ft

### ✔ Negative Values
5 ft + (-2 ft) = 3 ft

### ✔ Precision Handling
Results validated within floating-point tolerance.

### ✔ Large & Small Values
Handles extreme magnitudes safely.

---

## 🧪 Test Cases

- `testAddition_SameUnit_FeetPlusFeet()`
- `testAddition_SameUnit_InchPlusInch()`
- `testAddition_CrossUnit_FeetPlusInches()`
- `testAddition_CrossUnit_InchPlusFeet()`
- `testAddition_CrossUnit_YardPlusFeet()`
- `testAddition_CrossUnit_CentimeterPlusInch()`
- `testAddition_Commutativity()`
- `testAddition_WithZero()`
- `testAddition_NegativeValues()`
- `testAddition_NullSecondOperand()`
- `testAddition_LargeValues()`
- `testAddition_SmallValues()`

---

## 🚀 Architectural Strength

- Fully reuses UC5 conversion logic.
- No duplication introduced.
- Immutable value-object design.
- Scalable for future arithmetic operations (subtraction, multiplication).
- Backward compatible with UC1–UC5.

# Branch: UC7-Target-Unit-Addition

## 📌 Description
UC7 extends UC6 by allowing the caller to explicitly specify the **target unit** for the addition result.

Instead of defaulting to the unit of the first operand, the API now supports:

```java
add(QuantityLength length1, QuantityLength length2, LengthUnit targetUnit)
```

This provides full flexibility in representing the result.

Example:
1 Foot + 12 Inches in YARDS ≈ 0.667 YARDS

---

## ✅ Preconditions
- `QuantityLength` and `LengthUnit` enum exist (FEET, INCHES, YARDS, CENTIMETERS).
- Conversion factors are defined relative to a base unit.
- Two valid `QuantityLength` objects are provided.
- A valid `targetUnit` is explicitly specified.
- All units belong to the same measurement category (length).

---

## 🔄 Main Flow
1. Client calls:
   ```java
   add(length1, length2, targetUnit)
   ```
2. Validate:
   - Operands are non-null.
   - `targetUnit` is non-null and valid.
   - Values are finite.
3. Convert both operands to base unit.
4. Add normalized values.
5. Convert sum to explicitly specified `targetUnit`.
6. Return new immutable `QuantityLength` instance.

---

## 🎯 Postconditions
- Result is always expressed in the specified `targetUnit`.
- Original objects remain unchanged.
- Invalid inputs throw `IllegalArgumentException`.
- Addition remains mathematically accurate within epsilon tolerance.
- Commutativity is preserved.

---



---


## 🔑 Key Concepts Tested

### ✔ Explicit Target Unit (Same as First Operand)
Result respects explicitly provided unit.

### ✔ Explicit Target Unit (Different from Both Operands)
Conversion to third unit works correctly.

### ✔ Target Unit Consistency
Returned object always uses specified unit.

### ✔ Commutativity
add(A, B, target) == add(B, A, target)

### ✔ Mathematical Correctness Across Units
Equivalent values across FEET, INCHES, YARDS, CENTIMETERS.

### ✔ Edge Cases
- Zero values
- Negative values
- Large-to-small scale conversions
- Small-to-large scale conversions
- Null target unit validation

---

## 🧪 Test Cases


- `testAddition_ExplicitTargetUnit_PrecisionTolerance()`

---

## 🚀 Architectural Strength

- Fully backward compatible with UC6.
- Reuses centralized conversion logic.
- Zero duplication introduced.
- Flexible result representation.
- Clean, scalable arithmetic API.

# Branch: UC8-Standalone-Unit

## 📌 Description
UC8 refactors the design from UC1–UC7 by extracting `LengthUnit` from inside `QuantityLength` into a standalone top-level enum.

This resolves architectural limitations such as:
- Circular dependency risks
- Violation of Single Responsibility Principle
- Poor scalability for multiple measurement categories

Now:

- `LengthUnit` → Responsible for conversion logic  
- `QuantityLength` → Responsible for comparison and arithmetic  

All existing functionality (UC1–UC7) remains fully intact.

---

## ✅ Preconditions
- Refactored `LengthUnit` exists as a standalone enum.
- Units supported: FEET, INCHES, YARDS, CENTIMETERS.
- Conversion factors are defined inside `LengthUnit`.
- Public API of `QuantityLength` remains unchanged.
- All previous test cases exist and pass.

---

## 🔄 Main Flow

### 1️⃣ Enum Refactoring
- Move `LengthUnit` to top-level class.
- Define:
  ```java
  double convertToBaseUnit(double value)
  double convertFromBaseUnit(double baseValue)
  ```

### 2️⃣ Delegation Pattern
- Remove conversion logic from `QuantityLength`.
- Delegate conversion to:
  ```java
  unit.convertToBaseUnit(value)
  unit.convertFromBaseUnit(baseValue)
  ```

### 3️⃣ Backward Compatibility
- All UC1–UC7 APIs remain unchanged.
- Client code requires no modification.

---

## 🎯 Postconditions
- `LengthUnit` fully manages conversion responsibility.
- `QuantityLength` is simplified and cohesive.
- SRP is upheld.
- Circular dependency risks eliminated.
- All equality, conversion, and addition operations behave identically.



---

## 🧠 Concepts Learned

- Single Responsibility Principle (SRP)
- Separation of Concerns
- Delegation Pattern
- Dependency Inversion
- Circular Dependency Elimination
- Cohesion & Loose Coupling
- Enum Encapsulation (data + behavior)
- Refactoring with Backward Compatibility
- Architectural Scalability
- Immutability & Thread Safety

---

## 🔑 Key Concepts Tested

### ✔ Standalone Enum Accessibility
LengthUnit constants globally accessible.

### ✔ Base Unit Conversion
- INCHES → FEET
- YARDS → FEET
- CENTIMETERS → FEET

### ✔ From Base Unit Conversion
- FEET → INCHES
- FEET → YARDS
- FEET → CENTIMETERS

### ✔ Delegation Verification
`QuantityLength` delegates conversion logic to `LengthUnit`.

### ✔ Backward Compatibility
All UC1–UC7 test cases pass unchanged.

### ✔ Equality & Arithmetic Integrity
- Cross-unit equality preserved.
- Addition and conversion behavior unchanged.
- Explicit target unit addition (UC7) works correctly.

### ✔ Scalability Pattern
Architecture ready for:
- `WeightUnit`
- `VolumeUnit`
- `TemperatureUnit`

---

## 🧪 Test Cases

- `testLengthUnitEnum_FeetConstant()`
- `testConvertToBaseUnit_InchesToFeet()`
- `testConvertFromBaseUnit_FeetToYards()`
- `testQuantityLengthRefactored_Equality()`
- `testQuantityLengthRefactored_ConvertTo()`
- `testQuantityLengthRefactored_Add()`
- `testBackwardCompatibility_UC1EqualityTests()`
- `testBackwardCompatibility_UC5ConversionTests()`
- `testBackwardCompatibility_UC7AdditionWithTargetUnitTests()`
- `testRoundTripConversion_RefactoredDesign()`
- `testUnitImmutability()`

---

## 🚀 Architectural Impact

- High cohesion
- Low coupling
- Clean separation of responsibilities
- Scalable to enterprise-grade multi-category measurement system
- Zero regression introduced

---

## 📈 Evolution Summary

UC1 → Basic Equality  
UC2 → Multi-unit Equality  
UC3 → Generic Abstraction  
UC4 → Extensible Units  
UC5 → Conversion API  
UC6 → Arithmetic  
UC7 → Flexible Target Unit  
UC8 → Architectural Refactoring (SRP + Delegation + Scalability)
