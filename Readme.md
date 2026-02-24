# Branch: UC9-Weight-Measurement

## 📌 Description
UC9 extends the Quantity Measurement Application to support **Weight Measurements** alongside Length.

A new measurement category **Weight** is introduced with independent logic and type safety.

Supported Weight Units:
- KILOGRAM (Base Unit)
- GRAM (1 kg = 1000 g)
- POUND (1 lb ≈ 0.453592 kg)

This validates that the architectural pattern established in UC1–UC8 scales seamlessly to multiple measurement categories.

---

## ✅ Preconditions
- `WeightUnit` exists as a standalone enum (similar to UC8 refactor for LengthUnit).
- `QuantityWeight` class mirrors `QuantityLength` design.
- Conversion factors are defined relative to KILOGRAM.
- Length functionality (UC1–UC8) remains fully operational.
- Weight and Length are separate, incomparable categories.

---

## 🔄 Main Flow

### 1️⃣ Equality Comparison
- Validate input values and units.
- Convert both weights to base unit (kilogram).
- Compare using overridden `equals()` with `Double.compare()`.

### 2️⃣ Unit Conversion
- Normalize to base unit (kg).
- Convert to target unit.
- Return new immutable `QuantityWeight`.

### 3️⃣ Addition
- Convert operands to base unit.
- Add values.
- Convert result to:
  - First operand’s unit (default), OR
  - Explicit target unit (overloaded method).
- Return new immutable object.

---

## 🎯 Postconditions
- Equivalent cross-unit weights are equal.
- Accurate conversions within epsilon tolerance.
- Addition preserves immutability.
- Length and Weight categories are non-interoperable.
- Architecture supports future categories (Volume, Temperature, etc.).

---

## ▶ Example Output

### Equality
```
Quantity(1.0, KILOGRAM).equals(Quantity(1000.0, GRAM))
→ true

Quantity(1.0, KILOGRAM).equals(Quantity(~2.20462, POUND))
→ true
```

### Conversion
```
Quantity(1.0, KILOGRAM).convertTo(GRAM)
→ Quantity(1000.0, GRAM)

Quantity(2.0, POUND).convertTo(KILOGRAM)
→ Quantity(~0.907184, KILOGRAM)
```

### Addition
```
Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM))
→ Quantity(2.0, KILOGRAM)

Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM), GRAM)
→ Quantity(2000.0, GRAM)
```

### Category Safety
```
Quantity(1.0, KILOGRAM).equals(Quantity(1.0, FOOT))
→ false
```

---

## 🧠 Concepts Learned

- Multiple Measurement Categories
- Category Type Safety
- Base Unit Normalization (Kilogram as base)
- Enum-Based Conversion Responsibility
- Immutability Across Categories
- Method Overloading for Arithmetic
- Equals & hashCode Contract
- Floating-Point Precision Handling
- Architectural Scalability Validation
- Reusable Design Patterns

---

## 🔑 Key Concepts Tested

### ✔ Same-Unit Equality
- Kilogram ↔ Kilogram
- Gram ↔ Gram
- Pound ↔ Pound

### ✔ Cross-Unit Equality
- 1 kg = 1000 g
- 1 kg ≈ 2.20462 lb
- 453.592 g ≈ 1 lb

### ✔ Conversion Accuracy
All unit pairs convert correctly.

### ✔ Addition (Implicit & Explicit Target Unit)
Supports default and specified result units.

### ✔ Commutativity
add(A, B) == add(B, A)

### ✔ Category Incompatibility
Weight ≠ Length

### ✔ Precision & Rounding
Results validated using epsilon (e.g., 1e-6).

### ✔ Edge Cases
- Zero values
- Negative values
- Large magnitude values
- Small magnitude values
- Null handling
- Invalid input validation

---

## 🧪 Test Cases

- `testEquality_KilogramToKilogram_SameValue()`
- `testEquality_KilogramToGram_EquivalentValue()`
- `testEquality_KilogramToPound_EquivalentValue()`
- `testEquality_WeightVsLength_Incompatible()`
- `testConversion_KilogramToPound()`
- `testConversion_RoundTrip()`
- `testAddition_SameUnit_KilogramPlusKilogram()`
- `testAddition_CrossUnit_KilogramPlusGram()`
- `testAddition_ExplicitTargetUnit_Kilogram()`
- `testAddition_Commutativity()`
- `testAddition_NegativeValues()`
- `testAddition_LargeValues()`

---

## 🚀 Architectural Validation

UC9 proves that:

- The refactored design from UC8 is scalable.
- New measurement categories require **no modification** to existing categories.
- Conversion logic remains encapsulated within respective Unit enums.
- Quantity classes remain cohesive and loosely coupled.
- System is ready for enterprise-grade multi-category expansion.

---

## 📈 Evolution Summary

UC1 → Length Equality  
UC2 → Multi-Unit Length  
UC3 → Generic Refactor  
UC4 → Extensible Units  
UC5 → Conversion API  
UC6 → Addition  
UC7 → Explicit Target Unit  
UC8 → Architectural Refactor (Standalone Unit Enum)  
UC9 → Multi-Category Support (Weight)
