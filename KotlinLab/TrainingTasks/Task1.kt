fun main(args: Array<String>) {
    var month: Int

    while (true){
        print("Enter month number (from 1 to 12):")
        var input = readLine()

        if (input != null && input.toIntOrNull() != null){
            month = input.toInt()
            if (month in 1..12){
                break
            } else {
                println("Error: wrong input! Value for month must be from 1 to 12. Try again...")
            }
        } else {
            println("Error: wrong input! Input must be an integer from 1 to 12. Try again...")
        }
    }

    val season = when (month) {
        12, 1, 2 -> "Winter"
        3, 4, 5 -> "Spring"
        6, 7, 8 -> "Summer"
        9, 10, 11 -> "Autumn"
        else -> "Wrong input"
    }

    println("Season for month $month is: $season")
}