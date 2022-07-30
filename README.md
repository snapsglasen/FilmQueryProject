## How This App Works ##

  This app starts in the main method calling a "launch" method which creates a scanner input, passes that input to the "startUserInterface" method as an argument. This second method is contained within a while loop, "loop", and the close for the scanner is also contained in "launch". "startUserInterface" prints out a menu which presents three options that are passed, via scanner input passed from "launch", to  three "if" statements.
    The first "if" is triggered when the int 1 is entered and prompts the user to type in a Film ID int. The number is then passed to the "findFilmByID" method in the new class "DatabaseAccessorObject" and
  plugged into a prepared statement for a SQL query. If the query matches an ID in the database, the required toString and language will be printed out; if there is no matched ID, a message stating that there was no film found will print.
    The second "if" is triggered when the input is the int 2 and prompts the user to type in a String that will follow the same process as the first "if" statement; however, two areas are targeted by the prepared statement instead of one, and the output allows for the possibility of multiple films to be printed via ArrayList.
      The third "if" statement is triggered when int 3 is typed in. This last part of the app prints the exit message and breaks the loop the "startUserInterface" method is contained in by changing the while loop's boolean condition to false.


## Tech Used ##
Java and SQL

## What I Learned ##

  This was the first main project I did with SQL; thereby, this project has given me a novice, yet solid, understanding of how to combine Java and SQL if only to collect and pass information from a database to an application. The rest of this project has compounded further ways of implementing Java logic into my processes. For example: I had trouble figuring out where the loop containing "startUserInterface" would go before learning, for the first time in my own coding experience, to place it calling an external method from the one it was created in.
