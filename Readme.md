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
