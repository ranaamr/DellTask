# **LinkedIn**

Test Plan

# Contents

[Introduction 1](#_Toc95781672)

[Scope of the project 2](#_Toc95781673)

[Work Plan 2](#_Toc95781674)

[Test Procedure 3](#_Toc95781675)

[Bug Reports 3](#_Toc95781676)

[Tools 4](#_Toc95781677)

[Risks 4](#_Toc95781678)

## **Introduction**

This document describes the methods and procedures that will be used by the Testing team in the functional testing process. It is meant to be used as a manual during testing works. It describes the procedure of the testing process.

The objective of this test plan document:

● Identify existing project information and software components to be tested.

● Recommendation and description of the testing strategies to be employed.

● Identify required resources and provide a test effort estimate

● List the test project deliverable elements. The results of test execution will be sent to the customer as reports. All found bugs will be tracked using JIRA bug tracker

## Scope of the project

| The following components and functions would be tested during this release: |
| --- |
|
1. Registration using email
2. Registration using social media accounts
 |
|
1. Login and password recovery
 |
|
1. Logout
 |
|
1. View/ Edit profile
2. Jobs tab includes Applied jobs / filtering of jobs / job search
 |

## Work Plan

|
1. **Functional Testing:**
 The objective of functional testing is to make sure that the whole mobile application works according to the requirements, and no significant errors appear in the application. A software product must pass all the planned tests. Only in this case its quality can be assured.
2. **Test Objective:**
Ensure proper target of test functionality
 |
| --- |
|
1. **Technique:**
Execute each use case, use-case flow, or function, using valid and invalid data, to verify the following:
 ● The expected results occur when valid data is used.
 ● The appropriate error or warning messages are displayed when invalid data is used.
 ● Each rule is properly applied

 |
|
1. **Entry Criteria:**
 ● the test engineers are dedicated.
 ● Necessary devices, instruments, and other equipment are acquired.
 ● Test environment is prepared, and the application is released to the test environment.
 ● Test environment is prepared, and the application is released to the test environment.
 |
|
1. **Exit Criteria:**
 All the planned tests are performed.
 ● There are no show-stopping errors.
 ● All the errors of high priority and severity are fixed.
 ● The test results are evaluated, discussed, and approved.
 |

## Test Procedure

Test procedure assumes the next points:
 ● Reporting of found software bugs. Various aspects of the tested software should be checked; this requires executing of different testing types. The main testing type that would be executed:
 ● Functional Testing
 ● UI Testing
 ● Usability Testing
 ● Compatibility Testing (4 modern web browsers and devices)
 ● Regression testing
 ● Retesting

## Bug Reports

Bug reports are created to provide the development team and the project managers with exhaustive information about the discovered defects. They must be helpful in determining causes of the errors and correcting them. Defect Severity can be classified into four categories:
 ● **Critical (blocker):** defects are the failure of the complete system or of a critical subsystem, and no work or testing can be carried out after the occurrence of the defect. It also applies to data loss failures and with processes that leave inconsistent data stored on the database.
 ● **Major defects (and crashes):** are those which also causes failure of entire or part of the system, but there are some processing alternatives which allows further operation of the system. It also applies to the system crashing, or aborting, during normal operation of a non-critical flow.
 ● **Minor:** defects do not result in failure but causes the system to show incorrect, incomplete, or inconsistent results.
 ● **Trivial:** defects are small errors that do not affect the functionality: typos, grammar mistakes, wrong terminology, etc.

 The information that is indicated in each bug report.
 ● Version number of the software product.
 ● Devices on which the tests were performed.
 ● Summary, which is short description of the problem.
 ● Location of the defect in the software application.
 ● Steps to reproduce
 ● Severity of the defect.
 ● Additional information about the defect in form of attached screenshots or video records

## Tools

|
1. Jira (defect tracking).
 |
| --- |
|
1. Test rail (Test cases)
 |
|
1. IOS and Android devices with the latest software updates
 |

## Risks

The next issues may influence testing works:
 ● changes and modifications of the software application that were not planned and discussed with the test team beforehand.
 ● changes in the software requirements that were not discussed with the test team beforehand.
 ● delays in correcting/fixing errors.
 ● delays in delivering new builds to the test team.
**Test Team Expectations**
The test team must be provided with valid, updated documents during the whole testing process. All the required equipment, instruments, devices, and software must be acquired and prepared before beginning of the testing process. All show-stopping errors must be corrected as soon as possible. Release note should be added to each software release to the test team. The note must explain which elements, functions and features were added to the program and how these additions affect the software. The developers should correct all the errors in the software modules before releasing a new version.

**Responsibilities of Test Team Members**
**QA Lead:**
 ● Collecting and learning the requirements.
 ● Validation of the documentation.
 ● Planning the testing works.
 ● Monitoring the testing activities, making sure that the works are performed according to the plan.
 ● Reporting about the progress, number and severity of the found errors.

**Test Engineer** :
 ● QA process / logging found errors into the approved bug tracking system.

**Deliverables**
● Test Plan.
 ● Bug reports and reports regarding the testing progress.

Page | 1