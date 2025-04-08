fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 4, 5)

    println("Array: ["+ array.joinToString(", ") + "]")

    val sum = array.sum()
    val avg = sum.toDouble() / array.size

    println("Average value for elements in Array: $avg")
}