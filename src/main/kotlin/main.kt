import kotlin.math.max

const val ERROR_TYPE = -1//не известный тип карты
const val ERROR_LIMIT = -2//привышение лимита


fun comission(typeCard: String , transfer: Int, previous: Int) : Int {
    if(transfer > 150_000 || transfer + previous > 600_000){//лимиты на суммы перевода за сутки и за месяц
        return ERROR_LIMIT
    }
    return when(typeCard){
        "Mastercard"->if (transfer+previous <= 75_000) 0 else (transfer * 0.006).toInt() + 20
        "Visa"->max(35,(transfer * 0.0075).toInt())//если комиссия меньше 35 то будет 35,если больше 35 то % выражения
        "Мир"-> 0
        else -> ERROR_TYPE
    }
}
fun main(){
    val comissionEnd =comission("Mastercard",150_000,0)
    println("Сумма комиссии составит: $comissionEnd руб.")
}