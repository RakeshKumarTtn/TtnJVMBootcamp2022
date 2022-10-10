# TtnJVMBootcamp2022 :- THIS REPOSITORY CONTAINS THE TO THE NEW BOOTCAMP ASSIGNMENTS.
---------------------------------------------------------------------------------------
  
 JAVA-2 ASSIGNMENT - BANKING SYSTEM:
                      Implement a banking system using java.

                      Create 3 sub class of Bank : SBI,BOI,ICICI

                      All 4 should have following methods:

                      getDetails which provide their specific details like rateofinterest etc
                      printDetails of every bank.
                      Every bank account should have a type (enum): SAVINGS, CURRENT
                      Implement a feature to deduct amount from account. Throw InsufficientAmountException if amount being deducted is less than the current balance.
                      Every banking transaction should be saved in a file of each bank's transaction log which would have all details of the transaction like (time of transaction,account number,amount withdrawn, amount before deduction, amount after deduction,transaction status (can also be enum), failure reason if any)

---------------------------------------------------------------------------------------

JAVA COLLECTIONS:
                      1) Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.

                      2) Given the following class
                      Employee class{ Double Age; Double Salary; String Name}
                      Design the class in such a way that the default sorting should work on firstname and lastname.

                      Also, Write a program to sort Employee objects based on salary using Comparator. 

                      3) Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. (Expected complexity ­ O(1))

                      4) Create class Employee with attributes name,age,designation and use instances of these class as keys in a Map and their salary as value
                        
---------------------------------------------------------------------------------------

JAVA 8 FEATURES:

                      Q1) Write the following a functional interface and implement it using lambda:

                          First number is greater than second number or not Parameter (int ,int ) Return boolean
                          Increment the number by 1 and return incremented value Parameter (int) Return int
                          Concatination of 2 string Parameter (String , String ) Return (String)
                          Convert a string to uppercase and return . Parameter (String) Return (String)


                      Q2) Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference create and apply multiplication method for the functional interface created

                      Q3)Create a thread using lambda function

                      Q4) WAP using java 8:

                          Collect all  even numbers from a list using stream
                          Given a list of objects of following class:

                                 class Employee{
                                 String fullName;
                                 Long salary;
                                 String city;
                                 }

                                Get list of all unique firstNames of employees where their salary is less than 5000 and who live in delhi.
                                Note: Full name is concatenation of first name, middle name and last name with single space in between.  


                      Q5)Implement multiple inheritance with default method inside interface.
