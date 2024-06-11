package demo

class LambdaExpressions {
    fun walk1To(
        n: Int,
        action: (Int) -> Unit,
    ) = (1..n).forEach(action)

    fun predicateOfLength(length: Int) = { input: String -> input.length == length }
}
