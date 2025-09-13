Library

A simple console application that keeps data about books (or any entities you choose—movies, goods, etc.) in RAM and lets the user:
 - View all available books
 - Rent (issue) a book if it’s available
 - Return (release) a book
 - Add a new book
 - Quit the application

Highlights
 - Data stored in memory using List<>
 - Console navigation with Scanner
 - Control flow with while/for
 - Demonstrates custom exceptions for domain errors

Requirements
 - Java 21+ 
 - Maven

   Example Session
1) List books
2) Add a book 
3) Rent a book 
4) Return a book
5) Quit

Custom Exceptions
 - ItemNotFoundException — thrown if a book with the given index or ID cannot be found
 - NoAvailableCopiesException — thrown if the requested book has no available copies
 - InputMismatchException — thrown if the user enters an invalid menu option or non-numeric input
