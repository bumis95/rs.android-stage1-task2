package subtask2

class TimeConverter {

    var result = ""

    fun toTextFormat(hour: String, minute: String): String {

        if (minute.toInt() > 60 || hour.toInt() > 12) return result
        return makeResult(hour, minute)
    }
}

private fun getStringTime(time: Int) = when (time) {
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    10 -> "ten"
    11 -> "eleven"
    12 -> "twelve"
    13 -> "thirteen"
    14 -> "fourteen"
    15 -> "quarter"
    16 -> "sixteen"
    17 -> "seventeen"
    18 -> "eighteen"
    19 -> "nineteen"
    20 -> "twenty"
    21 -> "twenty one"
    22 -> "twenty two"
    23 -> "twenty three"
    24 -> "twenty four"
    25 -> "twenty five"
    26 -> "twenty six"
    27 -> "twenty seven"
    28 -> "twenty eight"
    29 -> "twenty nine"
    else -> "half"
}

private fun makeResult(hour: String, minute: String): String {

    val minuteInt = minute.toInt()
    val hourInt = hour.toInt()
    return when (minuteInt) {
        0 -> "${getStringTime(hourInt)} o' clock"
        in 1..30 -> when(minuteInt) {
            15, 30 -> "${getStringTime(minuteInt)} past ${getStringTime(hourInt)}"
            else -> "${getStringTime(minuteInt)} minutes past ${getStringTime(hourInt)}"
        }
        else -> {
            when(val diff = 60 - minuteInt) {
                15, 30 -> "${getStringTime(diff)} to ${getStringTime(hourInt + 1)}"
                else -> "${getStringTime(diff)} minutes to ${getStringTime(hourInt + 1)}"
            }
        }
    }
}