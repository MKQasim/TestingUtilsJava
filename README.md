# TestingUtilsJava
# Refactored and tested code for Java development 
# Muhammad Qasim Mubeen
- **Email**: kamqasim1@gmail.com
- **Phone**: +4915216414689

https://github.com/MKQasim/TestingUtilsJava.git

https://github.com/MKQasim/TestingUtilsiOS.git

## Developer Guide for Code Refactoring and Testing in Cross-Platform Development 

In the context of cross-platform development, the same codebase is often used across different platforms. In this case, we will consider a scenario where the code is written in Java and Swift and tested for Android and iOS, respectively. Improvements are made as required for both platforms. 

### Understanding the Code 

Start by thoroughly understanding the functionality of the existing code in CommonUtils.java (for Java) or CommonUtils.swift (for iOS) and the tests in CommonUtilsTest.java (for Java) or CommonUtilsTest.swift (for iOS). This includes understanding what each method does and how it works. 

### Identifying Bugs 

Run the existing tests on an Android emulator (for Java) or an iOS simulator (for iOS) and observe any failures. Investigate these failures to identify any bugs in the code. Also, review the code manually to spot any potential issues. 

### Creating a Test Plan 

Develop a comprehensive test plan to ensure all parts of the code are tested. This could involve adding new test cases or modifying existing ones in CommonUtilsTest.java (for Java) or CommonUtilsTest.swift (for iOS). 

### Improving Tests 

Based on the test plan, improve the tests in CommonUtilsTestNew.java (for Java) or CommonUtilsTestNew.swift (for iOS). This could involve adding new test cases, improving existing ones, or even breaking down complex test cases into simpler ones. 

### Fixing Bugs 

Once the bugs have been identified, start fixing them in the CommonUtilsSolutions.java (for Java) or CommonUtilsSolutions.swift (for iOS) file. Make sure to re-run the tests on the Android emulator (for Java) or the iOS simulator (for iOS) after each fix to ensure the bug has been correctly resolved. 

### Code Review and Refactoring 

Review the code for any possible improvements. Refactor the code if necessary to improve its structure, readability, and adherence to Java (for Java) or Swift (for iOS) development best practices. 

### Documentation 

Document all the changes made, bugs found, and how they were resolved. Also, document any improvements made to the tests. 

### Final Testing 

Once all bugs have been fixed and the tests have been improved, run all the tests again on the Android emulator (for Java) or the iOS simulator (for iOS) to ensure everything is working as expected. 

### Changes Made and Steps Followed 

#### Changes Made 

- Class Name: The class name was changed from CommonUtils to CommonUtilsSolutions. 
- Error Handling: Added error handling in findInFile, findInString, and findInDirectory methods to check if the needle is null or empty. 
- Error Handling: In sieveOfEratosthenes method, added a condition to check if the input n is negative. 
- Error Handling: In levenshteinDistance method, added a condition to check if either lhs or rhs is null. 

#### Steps Followed as a Developer 

- Understand the Requirement: Understand the functionality of the existing code and the changes required. 
- Code Changes: Implement the changes in the code as per the requirement. 
- Code Review: Review the code changes to ensure they meet the requirement and follow the coding standards. 
- Unit Testing: Write unit tests to validate the functionality of the code. 
- Integration Testing: Test the code in integration with other modules in Android Studio (for Java) or Xcode (for iOS). 
- Documentation: Document the changes made, functionality of the code, and the testing steps in the developer guide. 

#### Steps Followed as a Tester 

- Understand the Requirement: Understand the functionality of the code and the changes made. 
- Test Case Preparation: Prepare test cases to validate the functionality of the code. This includes positive cases, negative cases, boundary cases, etc. 
- Test Execution: Execute the test cases on an Android emulator (for Java) or an iOS simulator (for iOS) and validate the results. 
- Bug Reporting: If any test case fails, report the bug with details. 
- Retesting: Once the bug is fixed, retest the functionality on the Android emulator (for Java) or the iOS simulator (for iOS). 
- Regression Testing: Perform regression testing to ensure that the latest changes have not affected the existing functionality. 
- Test Closure: Once all the test cases pass, close the testing. 

Please note that the actual steps may vary based on the project and organization standards. It is always recommended to follow the best practices defined by your organization. Also, ensure to follow the coding and testing standards while performing the tasks. 
