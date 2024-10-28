package lists
fun main(args: Array<String>) {
    println("Start testing")
    val n = 12
    val zero = 0
    val nAsNull = null
    val a0 : List<Int> = emptyList()
    val a1 = listOf(1, 2, 3, 4)

    // generateElement tests
    val genE0 = generateElement(a0)
    val genE1 = generateElement(a1)
    println("generateElement of $a0 is ${genE0()}")
    println("generateElement first call of $a1 is ${genE1()}")
    println("generateElement second call of $a1 is ${genE1()}")
    println("generateElement third call of $a1 is ${genE1()}")
    println("generateElement fourth call of $a1 is ${genE1()}")
    println("generateElement fifth call of $a1 is ${genE1()}")
    println()

    // generateRest tests
    val restE0 = generateRest(a0)
    val restE1 = generateRest(a1)
    println("generateRest of $a0 is ${restE0()}")
    println("generateRest first call of $a1 is ${restE1()}")
    println("generateRest second call of $a1 is ${restE1()}")
    println("generateRest third call of $a1 is ${restE1()}")
    println("generateRest fourth call of $a1 is ${restE1()}")
    println("generateRest fifth call of $a1 is ${restE1()}")
    println()

    // primeNumbers tests
    val primesUpToN = primeNumbers(n)
    println("primeNumbers to $n are $primesUpToN")
    val primesUpToZero = primeNumbers(zero)
    println("primeNumbers to $zero are $primesUpToZero")
    val primeNumbersNull = primeNumbers(nAsNull)
    println("primeNumbers to $n are $primesUpToN")
    println()

    // listApply tests
    val ala0 : List<List<Int>> = emptyList()
    val ala1 = listOf(listOf(1), listOf(1, 2), listOf(1, 2, 3), listOf(1, 2, 3, 4))
    println("listApply of ::add to $ala0 is ${listApply(::add,ala0)}")
    println("listApply of ::add to $ala1 is ${listApply(::add,ala1)}")
     println()

    // runLengthEncoding tests
    val are0 : List<Int> = emptyList()
    val are1 = listOf(1, 1, 2, 2, 3, 2, 2, 2)
    val are2 = listOf(1, 2, 3, 3, 3, 3, 1)
    println("runLengthEncoding of $are0 is ${runLengthEncoding(are0)}")
    println("runLengthEncoding of $are1 is ${runLengthEncoding(are1)}")
    println("runLengthEncoding of $are2 is ${runLengthEncoding(are2)}")
    println()

    // connectTheLists tests
    val words0 : List<List<Int>> = emptyList()
    val words1 = listOf(listOf(1, 2), listOf(3, 1))
    val words2 = listOf(listOf(1, 2), listOf(5, 3))
    val words3 = listOf(listOf(1, 5, 0),
        listOf(2, 7),
        listOf(0, 2, 3),
        listOf(3, 2)
    )
    println("connectTheLists of $words0 is ${connectTheLists(words0)}")
    println("connectTheLists of $words1 is ${connectTheLists(words1)}")
    println("connectTheLists of $words2 is ${connectTheLists(words2)}")
    println("connectTheLists of $words3 is ${connectTheLists(words3)}")
    println()

}