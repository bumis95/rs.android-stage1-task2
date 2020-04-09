package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        var result = ""
        for (letter in a) {
            if (letter in b || letter.toUpperCase() in b)
                result += letter.toUpperCase()
        }

        return if(result == b) "YES" else "NO"
    }
}
