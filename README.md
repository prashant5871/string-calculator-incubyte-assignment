# 🧮 String Calculator – Incubyte Assignment

---

## 📖 Introduction

This project is a solution to the **String Calculator Kata**, assigned as part of the **Incubyte** recruitment process.  
It is implemented in **Java using Gradle**, following the principles of **Test-Driven Development (TDD)** — specifically using the **Red ➡ Green ➡ Refactor** approach:

- 🔴 **Red**: Write a failing test
- ✅ **Green**: Write the simplest code to make it pass
- 🔁 **Refactor**: Clean up the code while keeping tests green

To understand the development process, please review all the commits. Each step in the implementation is clearly reflected through meaningful commit messages.

---

## 🗂️ Project Structure

- The main logic resides in the `com.incubyte.stringcalculator.helper.StringCalculatorHelper` class.
- A thin wrapper class `StringCalculator` exposes the main `add()` method for usage.
- Unit tests are written using **JUnit 5** under `src/test/java`.
- The project is built and managed using **Gradle** and structured in standard `src/main/java` and `src/test/java` directories.
- All tests are written to follow TDD principles and cover both valid and invalid input cases.

---

## 📦 Required Dependencies

These are already included in the Gradle build:

```groovy
// build.gradle
plugins {
   id("java")
}

group = "com.incubyte.stringcalculator"
version = "1.0-SNAPSHOT"

repositories {
   mavenCentral()
}

dependencies {
   testImplementation(platform("org.junit:junit-bom:5.9.1"))
   testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
   useJUnitPlatform()
}
```

✅ No need to manually install anything — everything is resolved through **Gradle**.

---

## 🛠️ How to Run This Project in IntelliJ IDEA

1. **Clone the Repository**
   ```bash
   git clone https://github.com/prashant5871/string-calculator-incubyte-assignment.git
   ```

2. **Open IntelliJ IDEA**
    - Click on `Open` and select the cloned folder.
    - IntelliJ will auto-detect it as a Gradle project.
    - Allow it to sync.

3. **Run Tests**
    - Open `StringCalculatorTest.java`.
    - Right-click on the file and select `Run 'StringCalculatorTest'`.

4. **Optional: Run via Terminal**
   ```bash
   ./gradlew test        # On Unix/Mac
   gradlew.bat test      # On Windows
   ```

---

## ✅ Features Implemented

| Feature                         | Description                                                  |
|----------------------------------|--------------------------------------------------------------|
| Empty input                     | Returns 0                                                    |
| Single number                   | Returns the number                                           |
| Two numbers separated by comma  | Returns their sum                                            |
| Multiple numbers                | Handles unknown amount of numbers                            |
| Newline as delimiter            | Accepts `\n` along with commas                               |
| Custom delimiters               | Format: `//[delimiter]\n[numbers]`                           |
| Multiple custom delimiters      | Format: `//[delim1][delim2]\n[numbers]`                      |
| Multi-length delimiters         | Format: `//[***][%%%]\n1***2%%%3`                            |
| Negative number detection       | Throws exception with list of all negatives                 |
| Numbers >1000 are ignored       | e.g., `2 + 1001 = 2`                                         |

---

## 💡 Sample Inputs and Outputs

| Input                         | Output                    |
|------------------------------|---------------------------|
| `""`                         | `0`                        |
| `"1"`                        | `1`                        |
| `"1,2"`                      | `3`                        |
| `"1\n2,3"`                   | `6`                        |
| `"//;\n1;2"`                 | `3`                        |
| `"//[***]\n1***2***3"`       | `6`                        |
| `"//[*][%]\n1*2%3"`          | `6`                        |
| `"2,1001"`                   | `2`                        |
| `"-1,-2,3"`                  | ❌ Throws: `negatives not allowed: -1, -2` |

---

## 🧪 Running Tests

Run all tests via terminal:

```bash
./gradlew test
```

Or through IntelliJ IDEA as explained above.

---

## 👨‍💻 Author

> **Prashant Kalsariya**  
> 🔗 [GitHub: prashant5871](https://github.com/prashant5871)

---

This project is built as part of an interview assignment. You are welcome to explore, fork, and learn from it.
