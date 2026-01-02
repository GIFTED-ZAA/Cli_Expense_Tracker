import logic.askExpense
import logic.askName
import logic.showSummary

fun main(args : Array<String>){
    println("----------CLI EXPENSE TRACKER DEVELOPED BY HARI----------")
    val name =askName()
    println("----------  WELCOME $name   -------------")
    val expense = askExpense().also {
        showSummary(it)
    }
}