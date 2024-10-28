// Please not remove or rename the package
package lists

/*
* The following functions are helper functions that I am providing
*/

/*
* Extend the List class with a "tail" getter to get the tail of a list.
* Below is an example of how you would use tail
*    val a = listOf(1,2,3)
*    val t = a.tail
*    println("tail of $a is $t") // prints [2,3]
*/
val <T> List<T>.tail: List<T>
get() = drop(1)

/*
* Extend the List class with a "head" getter to get the head of a list.
* Below is an example of how you would use head
*    val a = listOf(1,2,3)
*    val h = a.head
*    println("head of $a is $h") // prints 1
*/
val <T> List<T>.head: T
get() = first()

/*
* The isPrime function takes as input an Int
*      x : an Int object to test
* and returns a Boolean
*      true  if x is a prime
*      false if x is not a prime
*/
fun isPrime(x : Int) : Boolean {
    for (i in 2..(x-1)) {
        if (x % i == 0) {
            return false
        }
    }
    return true
}


/**
 * generates each element from the passed list.
 * @param list a list of integers to generate elements from
 * @return a function that returns the next element in the list or null if all elements have been generated.
 */
fun generateElement(list: List<Int>): () -> Int? {
    var index = 0
    return {
        if (index < list.size) {
            val element = list[index]
            index++
            element
        } else null
    }
}

/**
 * generates a list with the current element removed
 * @param list a list of ints to generate remaining elements from.
 * @return a function that returns a list of remaining integers or null if all elements have been generated.
 */
fun generateRest(list: List<Int>): () -> List<Int>? {
    var index = 0
    return {
        if (index < list.size) {
            val rest = list.filterIndexed { i, _ -> i != index }
            index++
            rest
        } else null
    }
}

/**
 * returns a list of prime numbers up to n
 * @param n, integer limit for generating prime numbers (can be null)
 * @return a list of prime numbers up to n (can be null)
 */
fun primeNumbers(n: Int?): List<Int>? {
    return n?.let {
        (2..it).filter { num -> isPrime(num) }
    }
}

/**
 * builds the run-length encoding of a list
 * @param list a list of ints to encode
 * @return a list of pairs representing the run-length encoding (or null if the input is null)
 */
fun runLengthEncoding(list: List<Int>?): List<List<Int>>? {
    if (list == null) return null

    val result = mutableListOf<List<Int>>()
    var count = 1
    for (i in 1..<list.size) {
        if (list[i] == list[i - 1]) {
            count++
        } else {
            result.add(listOf(list[i - 1], count))
            count = 1
        }
    }
    if (list.isNotEmpty()) {
        result.add(listOf(list.last(), count))
    }
    return result
}


fun add(x: Int, y: Int): Int = x + y
/**
 * applies a binary function to elements in a list of lists.
 * @param f the binary function
 * @param lists a list of lists of ints, or null
 * @return a list of results after applying the function (or null)
 */
fun <T> listApply(f: (T, T) -> T, lists: List<List<T>>?): List<T>? {
    if (lists == null) return null
    return lists.map { sublist ->
        sublist.reduce(f)
    }
}

/**
 * connects lists from a list of lists into a chain based on matching elements
 * @param lists,  a list of lists of ints.
 * @return a connected list of lists (if no connection possible, returns null)
 */
fun connectTheLists(lists: List<List<Int>>): List<List<Int>>? {
    if (lists.isEmpty()) return emptyList() //empty list=empty output
    if (lists.size == 1) return lists // if only one exists


    fun canConnect(first: List<Int>, second: List<Int>): Boolean { //can two lists connect?
        return first.isNotEmpty() && second.isNotEmpty() && first.last() == second.head
    }

    fun findChain(current: List<List<Int>>, chain: MutableList<List<Int>>, visited: MutableSet<List<Int>>): Boolean {
        if (chain.size == current.size) return true // found a valid chain

        for (list in current) {
            if (list !in visited && (chain.isEmpty() || canConnect(chain.last(), list))) {
                visited.add(list)
                chain.add(list)

                if (findChain(current, chain, visited)) return true // recurse to find next connection
                //backtrack
                chain.removeAt(chain.lastIndex)
                visited.remove(list)
            }
        }
        return false // return false if no valid chain
    }

    val result = mutableListOf<List<Int>>()
    val visited = mutableSetOf<List<Int>>()

    if (findChain(lists, result, visited)) {
        return result // return valid chain
    }
    return null // no valid chain
}
