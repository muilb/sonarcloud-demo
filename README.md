# 🔍 SonarCloud Java 11 Demo

> **Training Repository**: Static Code Analysis + GitHub Copilot

This repository demonstrates how **SonarCloud** catches code quality issues and how to combine it with **GitHub Copilot** for efficient development.

---

## 🎯 Purpose

This repo is used for training junior developers about:

- ✅ Static Code Analysis concepts
- ✅ SonarCloud integration with GitHub
- ✅ CI/CD with GitHub Actions
- ✅ GitHub Copilot limitations & best practices
- ✅ Pattern-based bug fixing

---

## ❌ Intentionally Included Issues

| Issue Type | Rule | File | Description |
|------------|------|------|-------------|
| **BUG** | S2259 | UserService.java | NullPointerException risk |
| **BUG** | S2259 | OrderService.java | Same NPE pattern |
| **BUG** | S2259 | PaymentService.java | Same NPE pattern |
| **VULNERABILITY** | S2068 | PasswordUtil.java | Hardcoded credentials |
| **VULNERABILITY** | S2068 | DatabaseConfig.java | Hardcoded password |
| **CODE SMELL** | - | UserController.java | Duplicate code |
| **LOW COVERAGE** | - | UserServiceTest.java | < 80% coverage |

---

## 🔑 Key Learning Points

### 1️⃣ Same Pattern = Multiple Issues

```
UserService.java:20     → user.getName().length()  // NPE
OrderService.java:18    → customer.getName().length()  // SAME PATTERN
PaymentService.java:17  → payer.getName().length()  // SAME PATTERN
```

**Fix the pattern ONCE** → All 3 issues disappear!

### 2️⃣ Copilot Writes Fast... But Wrong

See `CopilotGeneratedCode.java` - realistic examples of what Copilot generates:
- Hardcoded passwords
- No null checks
- Security vulnerabilities

**Copilot doesn't know your security requirements!**

### 3️⃣ Quality Gate as Safety Net

Default conditions:
- 0 new bugs
- 0 new vulnerabilities
- ≥80% code coverage
- <3% duplicated lines

---

## 🚀 Quick Start

### 1. Clone & Setup

```bash
git clone https://github.com/YOUR_ORG/sonarcloud-java11-demo.git
cd sonarcloud-java11-demo
```

### 2. Update Configuration

Edit `sonar-project.properties`:
```properties
sonar.projectKey=YOUR_ORG_sonarcloud-java11-demo
sonar.organization=YOUR_ORG
```

### 3. Setup SonarCloud

1. Go to [sonarcloud.io](https://sonarcloud.io)
2. Sign in with GitHub
3. Import this repository
4. Generate token at [Account > Security](https://sonarcloud.io/account/security)

### 4. Add GitHub Secret

1. Go to repo → Settings → Secrets → Actions
2. Add `SONAR_TOKEN` with your token

### 5. Push & Watch

```bash
git push origin main
```

Watch the GitHub Actions workflow run and SonarCloud report issues!

---

## 📁 Project Structure

```
sonarcloud-java11-demo/
├── src/main/java/com/demo/
│   ├── controller/
│   │   └── UserController.java      # REST API
│   ├── service/
│   │   ├── UserService.java         # ❌ NPE bugs
│   │   ├── OrderService.java        # ❌ Same pattern
│   │   └── PaymentService.java      # ❌ Same pattern
│   ├── util/
│   │   ├── PasswordUtil.java        # ❌ Hardcoded creds
│   │   └── CopilotGeneratedCode.java # ❌ Copilot examples
│   ├── config/
│   │   └── DatabaseConfig.java      # ❌ Hardcoded password
│   └── model/
│       └── User.java                # Model class
├── src/test/java/com/demo/
│   └── service/
│       └── UserServiceTest.java     # ❌ Low coverage
├── .github/workflows/
│   └── sonar.yml                    # CI/CD pipeline
├── pom.xml                          # Maven config
├── sonar-project.properties         # SonarCloud config
└── README.md                        # This file
```

---

## 🎓 Demo Scenarios

### Demo 1: Pattern Recognition (5 min)
1. Show SonarCloud dashboard
2. Click on NPE issue
3. See "Same bug in 3 files"
4. Fix pattern once → 3 issues fixed

### Demo 2: Copilot Fails, Sonar Catches (7 min)
1. Ask Copilot to generate password validation
2. Copilot generates hardcoded password
3. Push code → SonarCloud catches S2068
4. Quality Gate: **FAILED**

### Demo 3: Copilot + Sonar Workflow (5 min)
1. See Sonar issue (S2068)
2. Ask Copilot: `/fix S2068 hardcoded password`
3. Copilot suggests `System.getenv()`
4. Push fix → Quality Gate: **PASSED**

---

## ✅ The Fix

### Before (Buggy)
```java
public int getUserNameLength(User user) {
    return user.getName().length(); // ❌ NPE risk
}
```

### After (Fixed)
```java
public int getUserNameLength(User user) {
    if (user == null) return 0;
    String name = user.getName();
    return name != null ? name.length() : 0; // ✅ Safe
}
```

---

## 📚 Resources

- [SonarCloud Documentation](https://docs.sonarcloud.io/)
- [GitHub Copilot](https://github.com/features/copilot)
- [Sonar Java Rules](https://rules.sonarsource.com/java)

---

## 🏷️ Tags

`java` `java11` `sonarcloud` `sonarqube` `github-actions` `copilot` `training` `demo`

---

**Happy Learning! 🚀**
