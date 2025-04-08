import java.lang.NumberFormatException

// Власні винятки
class InvalidSalaryException(salary: Double) : Exception("Salary cant be less than zero, last input: $salary.")
class InvalidBonusRateException(rate: Double) : Exception("Bonus rate cant be less than 0.1 or more than 2.0, last input: $rate.")

fun main(args: Array<String>) {
    val employeesAmount: Int

    // Введення кількості працівників
    while (true){
        print("Enter amount of employees: ")
        val inputEmployeesAmount  = readLine()?.toIntOrNull() ?: 0
        if (inputEmployeesAmount <= 0){
            println("Error input! Amount of employees must be an integer greater than or equal to zero. Try again...")
        } else{
            employeesAmount = inputEmployeesAmount
            break
        }
    }

    val employeesNames = mutableListOf<String>()
    val employeesSalary = mutableListOf<Double>()
    val employeesBonus = mutableListOf<Double>()

    // Введення Імені, зарплати та бонусу для кожного працівника
    for (i in 1..employeesAmount){
        if (employeesNames.size > 0){
            println()
        }
        print("Enter employee №$i name: ")
        val inputName = readlnOrNull()
        val name = inputName?.takeIf{it.isNotBlank()} ?: "Unknown"
        employeesNames.add(name)

        // Введення заплати працівника
        var salary : Double
        while (true){
            try{
                print("Enter employee №$i salary: ")
                salary = readLine()?.toDouble() ?: throw NumberFormatException()
                if (salary < 0){
                    throw InvalidSalaryException(salary)
                }
                employeesSalary.add(salary)
                break

            } catch (e: NumberFormatException){
                println("Error input! ${e.message} Try again...")
            } catch (e: InvalidSalaryException){
                println("Error input! ${e.message} Try again...")
            }
        }

        // Введення бонусної ставки працівника
        var bonusRate: Double
        while (true){
            try{
                print("Enter employee №$i bonus rate: ")
                bonusRate = readLine()?.toDouble() ?: throw NumberFormatException()
                if (bonusRate < 0.1 || bonusRate > 2.0){
                    throw InvalidBonusRateException(bonusRate)
                }
                break
            } catch (e: NumberFormatException){
                println("Error input! ${e.message} Try again...")
            } catch (e: InvalidBonusRateException){
                println("Error input! ${e.message} Try again...")
            }
        }

        // Обробка останочної бонусної зарлати
        val bonusSalary = salary * bonusRate
        employeesBonus.add(bonusSalary)
    }

    // Аналіз результатів
    println()
    for (i in 0..< employeesAmount){
        println("Employee №${i} ${employeesNames[i]}: Salary - ${employeesSalary[i]}$; Bonus salary - ${employeesBonus[i]}$")
    }

    println("\nResults:")
    val namesAndBonusPairs = employeesNames.zip(employeesBonus)
    val highestBonusName = namesAndBonusPairs.maxByOrNull {it.second}
    val totalSalary = employeesSalary.sum()
    val totalBonus = employeesBonus.sum()
    val excellentEmployees = namesAndBonusPairs.filter { it.second >= 10000 }.map { it.first }

    println("Employee with the highest Bonus - $highestBonusName")
    println("Total salary to pay - %.2f".format(totalSalary))
    println("Total bonuses to pay - %.2f".format(totalBonus))
    println("Amount of excellent employees (bonuses more than 10000$) - $excellentEmployees")
}