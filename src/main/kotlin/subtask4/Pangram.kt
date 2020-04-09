package subtask4

class Pangram {

    var alphabet = mutableListOf<Char>()
    var vowels = listOf('a','A', 'e','E', 'i','I', 'o','O', 'u', 'U', 'y', 'Y')
    var consonants = listOf('b', 'B', 'c', 'C', 'd', 'D', 'f', 'F',
        'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'p', 'P', 'q', 'Q', 'r', 'R',
        's', 'S', 't', 'T', 'v', 'V', 'w', 'W', 'x', 'X', 'z', 'Z')
    var list = listOf<String>()

    fun getResult(inputString: String): String {

        if(inputString.trim() == "") return ""
        list = inputString.trim().split(" ", "\n").filter { it!="" }.toList()
        return if (isPangram(inputString)) {
            pangram(list)
        } else {
            notPangram(list)
        }
    }

    private fun notPangram(list: List<String>): String {
        val resultList = mutableListOf<String>()
//        println(list)
        list.forEach { item ->
            val word = StringBuilder()
            var count = 0
            item.forEach { char ->
                when(char) {
                    in consonants -> {
                        word.append(char.toUpperCase())
                        count++
                    }
                    else -> word.append(char)
                }
            }
            word.insert(0, count)
            resultList.add(word.toString())
            count = 0
        }
        resultList.sortBy { it[0] }
//        println(result.joinToString(separator = " "))
        return resultList.joinToString(separator = " ")
    }

    fun pangram(list: List<String>): String {
        val resultList = mutableListOf<String>()
//        println(list)
        list.forEach { item ->
            val word = StringBuilder()
            var count = 0
            item.forEach { char ->
                when(char) {
                    in vowels -> {
                        word.append(char.toUpperCase())
                        count++
                    }
                    else -> word.append(char)
                }
            }
            word.insert(0, count)
            resultList.add(word.toString())
            count = 0
        }
        resultList.sortBy { it[0] }
//        println(result.joinToString(separator = " "))
        return resultList.joinToString(separator = " ")
    }

    private fun isPangram(inputString: String): Boolean {

        for(letter in 'a'..'z') alphabet.add(letter)

        inputString.forEach { char ->
            when(char) {
                in 'a'..'z' -> alphabet.remove(char)
                in 'A'..'Z' -> alphabet.remove(char.toLowerCase())
            }
        }
        return alphabet.isEmpty()
    }
}
