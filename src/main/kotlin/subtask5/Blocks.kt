package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        val stringList: List<String>
        val intList: List<Int>
        val dateList: List<LocalDate>

        when(blockB) {
            String::class -> {
                stringList = blockA.filterIsInstance<String>()
                var result = ""
                stringList.forEach { result += it }
                return result
            }
            Int::class -> {
                intList = blockA.filterIsInstance<Int>()
                var result = 0
                intList.forEach { result += it }
                return result
            }
            else -> {
                dateList = blockA.filterIsInstance<LocalDate>()
                val max = dateList.max()?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                return max!!
            }
        }
    }
}