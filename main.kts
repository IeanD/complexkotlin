println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
    val numbers = IntArray(15, { it * 1 } ).map { it -> it + 1 }

    val fizzBuzz = numbers.map {
        it ->
        	var result = ""
    		if (it % 3 == 0) result += "FIZZ"
    		if (it % 5 == 0) result += "BUZZ"
    
    		result
    }

    val mapFoldResults = fizzBuzz.fold("", { s, next -> s + next })


// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// (String function added by me, Iean)
fun Int.timesToString(block: () -> String): String {
    var acc = ""
    for (it in 1..this) {
        acc += block()
    }

    return acc
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}

// call process() with message "FOO" and a block that returns "BAR"
val r1 = process("FOO") { 
    it ->
        when(it) {
            "FOO" -> "BAR"
            else -> {
                "fail"
            }
        }
 } 

// call process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = process("FOO") {
    it ->
        when(it) {
            "FOO" -> 3.timesToString() { r2_message.toUpperCase() }
            else -> {
                "fail"
            }
        }
}

// write an enum-based state machine between talking and thinking
enum class Philosopher { 
    TALKING {
        override fun signal() = THINKING
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    },
    
    THINKING {
        override fun signal() = TALKING
        override fun toString(): String {
            return "Deep thoughts...."
        }
    };

    abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return this.prompt + message
    }
}




// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



