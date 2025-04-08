import java.lang.NumberFormatException
fun main(args: Array<String>) {
    try {
        print("Enter integer value: ")
        var input = readLine()
        var number = input?.toInt()

        println("Success. Input value '$number' is integer.")
    } catch (e:NumberFormatException){
        println("Error! Input value is not integer...")
    }
}