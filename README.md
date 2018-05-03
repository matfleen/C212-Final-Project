# C212-Final-Project
## Overview
This is the final project for CSCI-C212 for spring 2018 at Indiana University. This is by far the biggest undertaking of my programming career, not in terms of technical difficulty, but in terms of sheer scope. 
Creation of the project required using each step of the software development model, including analysis, design, implementation, and testing.
Our project is a simulation of a library system, where users can log on as a student or librarian and can view books, check them out, and other functions that one would expect to see at a library.
The system is sometimes buggy, however it is functional to the point that most users should not have a problem using it.

## Group Members
- Sam Kravitz sekravit@iu.edu
- Alexandra Embry aiembry@iu.edu
- Mitch Robinson robinmit@iu.edu
- Bret Bolin brbolin@iu.edu

## System Features
- Log on as either a student or librarian with a unique username and password. You will have different levels of access whether you are a logged in as a student or librarian.
- A student may look up a book using its author's name, title, or ISBN number.
- The system will inform the student information about a book when it is searched, including if it is checked out or not.
- A student may check out books, return books, and pay fines if a book was not returned by its due date.
- A librarian may search for books similarly to a student, and they may also look up the check out status of any book. The librarian can add, delete, or modify any book.
- The system features state persistence; if a user is to log off and exit the system, the next time the user logs in, the system will remember all actions took last time there was a log on. This is accomplished using several file read and write mechanisms. 
