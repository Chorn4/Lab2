fun main(args: Array<String>) {
    print("Введіть ім'я користувача: ")
    var userName: String? = readLine()

    if (userName.isNullOrEmpty()) {
        userName = "Anonymous"
    }

    println("Привіт, $userName")
}