# ASSIGNMENT README 


Welcome to the Cognizant Java Programming Exercise


This software relies on [Java Development Kit 11](https://www.oracle.com/java/technologies/downloads/) 
and [Gradle 7 or better](https://gradle.org/).

Please see [INSTALLING TOOLS](INSTALLING_TOOLS.md) for further help about getting the correct 
software for my workstation and operating system.

## Assignment

Cognizant has a client called XAMINI ("Xamini") in Africa.

We have a graduate programmer who has written production code for a new payment service.
Unfortunately, their code is incomplete and we need to ensure code quality. 

Your task is to take over the code (from the graduate programmer) and improve it.
Ensure our code satisfies technical quality and that it passes the business requirements satisfactorily.


*We are looking for clean code*.


Xamini have paying (existing) customers with accounts.

There have three types of account: GOLD, SILVER and BRONZE.

  * BRONZE customers have accounts with a balance less than £50,000.
  * SILVER customers have accounts at £50,000 and less than £250,000.
  * GOLD customers have accounts at £250,000 and over.

Additionally, Xamini have a bulk buying promotion deal that applies for a single payment for a collection of goods.
Xamini have these business rules regarding the SALES UNITS.
A collection of goods/items is called A SALES UNIT.

    1 set of iron widgets is 1 sale units
    10 sets of iron widgets are 10 sales units


If the customer pays for an item that is equal to or over £100.00 then a SALES UNIT DISCOUNT PROMOTION applies.

If the SALES UNITS are equal to 100 or greater than the customer gets 9.95% discount of the payment price.
If the SALES UNITS are equal to 50 or greater than the customer get 4.95% discount of the payment price.


Write code that satisfies the following acceptance criteria.


## Acceptance Criteria

Here is the acceptance criteria as written by the business analyst.
These acceptance criteria may be different style to what you are used to (*)


    AS A Xamini Payment Service (XPS)
      WHEN GOLD customer 'First Digital' with account 'Premier Track'
        and a current balance of £500,000.00
        WANTS to invoke payment amount £499.99 and 100 sales units
      THE XPS
         will result in payment of £45,024.10
         and will result in a new account balance £454,975.90


    AS A Xamini Payment Service (XPS)
      WHEN GOLD customer 'First Digital' with account 'Premier Track'
        and a current balance of £454,975.90
        WANTS to invoke payment amount £499.99 and 50 sales units
      THE XPS
         will result in payment of £23,762.02
         and will result in a new account balance £431,213.88


    AS A Xamini Payment Service (XPS)
      WHEN GOLD customer 'First Digital' with account 'Premier Track'
        and a current balance of £431,213.88
        WANTS to invoke payment amount £499.99 and 25 sales units
      THE XPS
         will result in payment of £12,499.75
         and will result in a new account balance £418,714.13


    AS A Xamini Payment Service (XPS)
      WHEN SILVER customer 'Jane Luna' with account 'Tinsel'
        and a current balance of £150,000.00
        WANTS to invoke payment amount £299.99 and 100 sales units
      THE XPS
         will result in payment of £27,014.10
         and will result in a new account balance £122,985.90


    AS A Xamini Payment Service (XPS)
      WHEN BRONZE customer 'Cast Cooper' with account 'Russet'
        and a current balance of £40,000.00
        WANTS to invoke payment amount £199.99 and 50 sales units
      THE XPS
         will result in payment of £9,504.52
         and will result in a new account balance £30,495.48


In addition, Xamini wants to publish to customers when their membership state transitions.


    AS A Xamini Payment Service (XPS)
      WHEN GOLD customer 'First Digital' with account 'Premier Track'
        and a current balance of £250,000.00
        WANTS to invoke payment amount £299.99 and 50 sales units
      THE XPS
         will result in payment of £14,257.02
         and will result in a new account balance £235,742.98
    notify customer [First Digital] membership moving from [GOLD] to [SILVER]


    AS A Xamini Payment Service (XPS)
      WHEN SILVER customer 'Jane Luna' with account 'Tinsel'
        and a current balance of £52,000.00
        WANTS to invoke payment amount £199.99 and 25 sales units
      THE XPS
         will result in payment of £4,999.75
         and will result in a new account balance £47,000.25
    notify customer [Jane Luna] membership moving from [SILVER] to [BRONZE]


Notice(*) that they have not followed the standard style of writing criteria, exactly.
For example

     AS A teacher 
     I WANT to evaluate each student's performance
     SO THAT each student receives the correct, fair and evidence-based grade


## Task

You will write the unit tests to cover these above scenarios.
In particular, how do you validate the operation of the services types: `CustomerNotificationService` and `PaymentNotificationService`?
Fix any failures that the graduate may have applied to his/her/their work.
Does your code meet the acceptance criteria of the business?

This exercise should take you about 1 hour to complete.
Do not spend more than 2 hours on this exercise.


Reminder: *We are looking for clean code*.


## Code

Java development code uses the follow technologies:

  * [Java 11](https://openjdk.org/projects/jdk/11/)
  * [Gradle 7](https://gradle.org/) or better
  * [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
  * [Mockito](https://site.mockito.org/)


## Feedback

You might prefer to use the handy shell script `pack.sh` to create a distribution.
This shell script creates a JAR file of the source files.

Extract the project 

```

❯ ./pack.sh                                                  
=====================================================================================
Creating JarFileName [xamini-payment-service-submit-peterpilgrim-20221030.jar]
=====================================================================================
added manifest
adding: README.md(in = 4432) (out= 1542)(deflated 65%)
adding: pack.sh(in = 480) (out= 213)(deflated 55%)
adding: .gitignore(in = 1028) (out= 348)(deflated 66%)
adding: gradlew(in = 8070) (out= 3480)(deflated 56%)
adding: gradlew.bat(in = 2763) (out= 1181)(deflated 57%)
adding: gradle/wrapper/gradle-wrapper.properties(in = 200) (out= 122)(deflated 39%)
adding: build.gradle.kts(in = 1676) (out= 608)(deflated 63%)

```

Send the distribution back to the recruiter agency and also carbon copy me `PeterAndrew.Pilgrim@cognizant.com`.





## Gradle Build

From the root on the project you should be able to build this project completely with *Gradle*. 

To reset the distribution, navigate to the root project directory 

```shell
cd xamini-payments-service
```

purge transient files like` *.class` by running the following command line: 

```shell
gradle clean
```

To build the software:

```shell
gradle build
```

To run the JUnit tests from the command line, execute the following:

```shell
gradle test
```

You should see output of the test output that you have written.

Finally, you can combine actions together in one command line.

```shell
gradle clean test assemble
```

The `assemble` action is a Gradle synonym to `build`, which creates a project JAR file.

If you are new to [*Gradle*](https://gradle.org/), it is worth reading up in your own time about this popular build tool.


## Credits

Peter Pilgrim

October 2022



End.
