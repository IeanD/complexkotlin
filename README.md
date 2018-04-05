# Greetings!

This homework is designed to force you to exercise your knowledge of the Kotlin programming language. This homework does not involve Android in any way.

Your task is simple: Make the code compile, and make all the unit tests pass. You may not change the tests that already exist in the code; you will also be asked to add a few tests, as well.

## Tools
In order to complete this homework, you will need a command-line installation of Kotlin, since Android Studio does not permit us to write Kotlin shell applications. There are several ways to obtain Kotlin, all of which are described [here](https://kotlinlang.org/docs/tutorials/command-line.html), but, summarized, consist of:

* *Download the Kotlin compiler directly.* It is found on the Kotlin website.
* *Use SDKMAN!* SDKMAN is a Unix-friendly Java-ecosystem installation manager. It will work on any *nix environment, which includes both macOS and most flavors of Linux. If you are running a recent build of Windows 10, it also works well inside the Ubuntu Shell (Windows Subsystem for Linux).
* *Use Homebrew for macOS.* Homebrew is by far the best option, but unfortunately it only works for macOS.

You may want a decent text editor for working with this assignment; VisualStudio Code comes highly recommended (it's what I used to create the assignment), and naturally you can use Android Studio itself to edit the files.

To run Kotlin code, first compile it at the command-line with

    kotlinc main.kt -include-runtime -d main.jar

The `-d` parameter tells Kotlin to compile the code into a single JAR file as the output. The `-include-runtime` flag tells Kotlin to include the Kotlin standard library as part of the generated JAR file. As a result, running the code should be as simple as

    java -jar main.jar

However, for purposes of this exercise, you can also use Kotlin as a scripting tool, by giving the file a `.kts` extension and running `kotlinc` with the `-script` parameter:

    kotlinc -script main.kts

This the expected use for this assignment.

***NOTE:*** The `main.kts` file will not run when you first check this code out; your job will be to make the code run and pass all the tests (that is, no "!" appearing in the output). You are not permitted to change the code below the "DO NOT CHANGE BELOW THIS LINE" comment--commenting out tests so that the tests "pass" is considered bad form, professionally. (Practically speaking, however, temporarily commenting them out so you can be certain some tests pass is acceptable, so long as you remember to uncomment them again.)

## To obtain this code...
... you must first obtain a copy of the source. Do that by cloning this repository:

    git clone https://bitbucket.org/TedNeward/uw-android-simplekotlin complexkotlin

This will create a local copy of the project. However, in order to *store* your changes to your own GitHub account, you need to create a new repository on GitHub (call it `simplekotlin`), and then change the project's settings to point to that new repository as the remote origin.

    git remote set-url origin https://github.com/[your-ID]/complexkotlin.git

This will work regardless of whether you got the syntax of the URL correct or not, so do a quick push to make sure it all worked correctly:

    git push

Git will ask you for your username and password, then (if everything was done correctly), it will upload the code to the new repository, and this is your new "home" for this project going forward. Verify the files are there by viewing your GitHub project through the browser.

***NOTE:*** Your grade for this assignment (and all future assignments) will be based on what we see in the GitHub repository, and nothing else. If it isn't in GitHub, it doesn't exist.

## The assignment
The code is broken into a sequence of sections. Your job is to implement the body of each section, so that the tests will pass.

In the first section, you will be using the collection methods `map` and `fold` to perform the "FIZZBUZZ test". This is a simple algorithm, usually used as part of an interview process as a way of verifying developer skill (and rather poorly at that). FIZZBUZZ goes like this: Iterate across a sequence of numbers (1 to 15), and any number that is divisible by 3 returns "FIZZ", and any number divisible by 5 returns "BUZZ". Numbers which are divisible by both 3 and 5 return "FIZZBUZZ". Use the `map` function to transform the range of numbers into an list of strings (either "FIZZ", "BUZZ" or the empty string ""), and then use `fold` to combine them all down into a single String. The end result should be "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ". (This is an exercise in understanding how `map` and `fold` work, as they are commonly used in Kotlin code, along with `filter`. You are free to use `filter` as well, if you so choose, but you do not need to in order to pass the tests.)

In the second section, your job is to use the `process` function defined in the script to generate strings. The `process` function takes a parameter and a block of code. Your job is to write the call to `process` such that the tests for `r1` and `r2` pass. (This is an exercise in getting the "block syntax" correct.)

In the third section, you are to create an enum class called `Philosopher`. This is going to be a peculiar use of enum, however, as we are going to model a very simple state machine: as everybody knows, philosophers split their time between `THINKING` and `TALKING`, and only shift from one state to the other when told to do so via the method call `signal`. Additionally, each state should override the `toString` function so that when `THINKING`, a philosopher will return "Deep thoughts..." and when `TALKING`, a philosopher will return "Allow me to suggest an idea...". If you are not sure of the syntax here, check out the Kotlin reference page on [Enum classes](http://kotlinlang.org/docs/reference/enum-classes.html). Modeling state machines in a mobile application is a very common occurrence, so it's worth taking the time to give this exercise a shot.

(By the way, I will give a bonus point to anyone who can find out who Seneca the Younger was, an additional point if you can tell me which school of philosophy he is commonly associated with, and a third point if you can summarize that school of philosophy in a single sentence. On another note, when you have some time to kill, play "The Wikipedia Game"--pick any random subject on Wikipedia, and click the first link on that page. On the page that comes up, click the first link on that page. Continue doing this until you have reached the Wikipedia page on Philosophy, and marvel at how everything in human existence essentially traces its roots back to philosophy and a bunch of dead Greeks in togas.)

In the fourth section, create a class called `Command` that can be used as a function. This means you will need to provide a `invoke` method on the class. The primary constructor should take a String parameter (`prompt`), and the `invoke` operator should also take a String parameter (`message`), and simply return a concatenation of the two. 

As with the previous assignment, 5 points if all the tests pass, and 0 points if any of them fail. Where this README appears to disagree with the code, follow the code, but do not change the tests.


