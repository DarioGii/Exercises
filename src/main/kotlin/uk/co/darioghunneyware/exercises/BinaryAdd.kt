package uk.co.darioghunneyware.exercises

class BinaryAdd {
    fun addBinary(
        a: String,
        b: String,
    ): String {
        var i = 0
        var j = 0
        var sumString = ""

        while (i < a.length) {
            while (j < b.length) {
                sumString += add(a[i].toString(), b[j].toString())
                i++
                j++
            }
            sumString += a.substring(i)
            break
        }

        return sumString.reversed()
    }

    private fun add(
        a: String,
        b: String,
    ): String =
        if ((a == "1" && b == "0") || (a == "0" && b == "1")) {
            "1"
        } else if (a == "0" && b == "0") {
            "0"
        } else {
            "10"
        }
}
