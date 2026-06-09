# Secure Coding Review (Java Login Process)

This repository contains my submission for **Task 3: Secure Coding Review** under the Cyber Security Internship at **CodeAlpha**. It features a comprehensive manual source code review comparing insecure development practices against secure coding remediation guidelines.

---

## 📌 Project Architecture
The project is split into two simulated database login implementations to demonstrate the risks of vulnerabilities and how to properly secure them:
1. **`VulnerableLogIn.java`**: The baseline script containing hardcoded secrets and vulnerable query structures.
2. **`SecureLogIn.java`**: The refactored script showcasing proper mitigation tactics.

---

## 🔍 Vulnerabilities Identified

### 1. Use of Hardcoded Credentials (CWE-798)
*   **Location:** `VulnerableLogIn.java`
*   **Severity:** High
*   **Description:** Production database credentials (`DB_USER` and `DB_PASSWORD`) are statically embedded as plain-text string constants directly inside the file.
*   **Risk:** Pushing code with hardcoded credentials to version control tracking systems exposes critical backend architecture to unauthorized leaks and breaches.

### 2. Potential SQL Injection Risk (CWE-89)
*   **Location:** `VulnerableLogIn.java`
*   **Severity:** High
*   **Description:** The application relies on unvalidated dynamic string concatenation to evaluate authentications during active runtime lookups.
*   **Risk:** Malicious entities can manipulate structural runtime flow payloads (e.g., inputting `' OR '1'='1`) to completely bypass authorization barriers without requiring verified user passwords.

---

## 🛡️ Remediation Applied

To fix the security flaws discovered during the code review phase, the implementation was refactored with the following security defenses inside `SecureLogIn.java`:

*   **Runtime Environment Mapping:** Sensitive production database markers are completely pulled out of the codebase. Instead, variables are securely mapped using dynamic context calls (`System.getenv()`).
*   **Strict Parameterized Queries:** Standard open database statements are migrated over to structured **`PreparedStatement`** wrappers. This maps user arguments directly to dedicated data position holders (`?`), completely defusing custom execution logic strings.

---

## ⚙️ How to Review & Execute

### Prerequisites
*   Java Development Kit (JDK 8 or higher) installed.

### Verification Run
Compile and run either file via the terminal to witness the logic simulation in action:

```bash
# To view the insecure behavior and bypass demo
javac VulnerableLogIn.java
java VulnerableLogIn

# To view the secure behavior and mitigation defense
javac SecureLogIn.java
java SecureLogIn
```

---

## 📄 License
This project is open-source and available under the [MIT License](LICENSE).
