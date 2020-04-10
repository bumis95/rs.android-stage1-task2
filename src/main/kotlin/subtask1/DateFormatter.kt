package subtask1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        val dateToValidate = "$day.$month.$year"

        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale("ru"))
        sdf.isLenient = false
        val date: Date
        try {
            date = sdf.parse(dateToValidate)
        } catch (e: ParseException) {
            return "Такого дня не существует"
        }

        return "$day ${chooseMonth(month)}, ${SimpleDateFormat("EEEE", Locale("ru")).format(date)}"
    }
    
    fun chooseMonth(month: String) = when(month.toInt()) {
        1 -> "января"
        2 -> "февраля"
        3 -> "марта"
        4 -> "апреля"
        5 -> "мая"
        6 -> "июня"
        7 -> "июля"
        8 -> "августа"
        9 -> "сентября"
        10 -> "октября"
        11 -> "ноября"
        else -> "декабря"
    }
}
