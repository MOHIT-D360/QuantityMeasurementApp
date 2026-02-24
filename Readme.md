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
