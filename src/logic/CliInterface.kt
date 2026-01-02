package logic
import kotlin.Int
//to get user's name
fun askName(): String {
    print("Enter your name: ")
    return toValidateNullableString()
}
fun askExpense(): MutableList<Expense>{

    val expenses: MutableList<Expense> = mutableListOf()
    var id = 0

    println("let's enter your expenses")
    while (true) {
//prompting user to enter expenseType and item purchased
        println("Enter your expenseType: ")
        val type = toValidateNullableString()
        println("what item did you buy: ")
        val item = toValidateNullableString()
//prompting user to enter unit price and quantity
        println("unit price: ")
        val price = toValidateNullableDouble()
        println("purchased quantity : ")
        val quantity = toValidateNullableDouble()

//    val total expense
        val totalExpense: Double = price * quantity

        expenses.add(
            Expense(
                id = id,
                expenseType = type,
                itemName = item,
                unitPrice = price,
                quantity = quantity,
                totalPrice = totalExpense,
            )
        )
        id++

        println("--------------------SAY STOP TO EXIT THIS MENU-------------------- ")
        println("                               OR                                  ")
        println("--------------------  PRESS ENTER TO CONTINUE  --------------------")
        val choice = readlnOrNull()?.uppercase()
        if(choice=="STOP")return expenses
    }
}
fun showSummary(expenses: MutableList<Expense>){
    var totalExpensePrice: Double = 0.0
    println("--------------------------------------SUMMARY TABLE------------------------------------------------")
    println("   ID   | Expense Type | Item Bought | Unit Price | Quantity | Total Price ")
    expenses.forEach{
        println("   ${it.id}   | ${it.expenseType} | ${it.itemName} | ${it.unitPrice} | ${it.quantity} | ${it.totalPrice} "   )
        totalExpensePrice += it.totalPrice
    }
    println("TOTAL EXPENSE = $$totalExpensePrice")


}

//function i made to validate inputs such as string and double
fun toValidateNullableString(): String {
    var input=readlnOrNull()?.trim()
    while(input.isNullOrBlank()){
        print("bro enter like a human now try again :")
        input = readlnOrNull()?.trim()
    }
    return input
}
fun toValidateNullableDouble(): Double {
    var input=readlnOrNull()?.trim()
    while(input.isNullOrBlank()){
        print("bro enter like a human now try again :")
        input = readlnOrNull()?.trim()
    }
    return input.toDouble()
}
//with data class i was able to make objects with properties
data class Expense(
    val id: Int,
    val expenseType: String,
    val itemName: String,
    val unitPrice:Double,
    val quantity:Double,
    val totalPrice:Double
        )