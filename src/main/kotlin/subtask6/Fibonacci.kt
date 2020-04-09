package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {

        val result = IntArray(3)
        var previous = 0
        var next = 1

        while (previous * next <= n) {
            if(previous * next == n) return result.apply {
                set(0, previous)
                set(1, next)
                set(2, 1)
            }
            next += previous
            previous = next - previous
        }
        return result.apply {
            set(0, previous)
            set(1, next)
            set(2, 0)
        }
    }
}
