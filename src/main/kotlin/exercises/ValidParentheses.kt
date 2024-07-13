package exercises

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val queue: ArrayDeque<Char> = ArrayDeque()

        for (char in s) {
            when (char) {
                '(', '{', '[' -> queue.add(char)
                ')' ->
                    if (queue.isEmpty() || (queue.removeAt(queue.size - 1) != '(')) {
                        return false
                    }
                '}' ->
                    if (queue.isEmpty() || (queue.removeAt(queue.size - 1) != '{')) {
                        return false
                    }
                ']' ->
                    if (queue.isEmpty() || (queue.removeAt(queue.size - 1) != '[')) {
                        return false
                    }
            }
        }

        return queue.isEmpty()
    }
}
