package uk.co.darioghunneyware.exercises

class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val uniqueEmails = mutableSetOf<String>()

//        fixMe sanitiseEmail(emails, removeCharsAfterPlus())
        for (email in emails) {
            val plusesRemoved = removeCharsAfterPlus(email)
            val sanitisedEmail = removePeriodsInLocalName(plusesRemoved)

            uniqueEmails.add(sanitisedEmail)
        }

        return uniqueEmails.count()
    }

//    fixMe: Use lambdas and functional methods
//    fixMe: private fun sanitiseEmail(operation: (String) -> String) = operation

    private fun getLocalName(email: String): String {
        val atPos = email.indexOf('@')
        return email.substring(0..< atPos)
    }

    private fun removeCharsAfterPlus(email: String): String {
        val localName = getLocalName(email)

        return if (!localName.contains('+')) {
            email
        } else {
            val sanitisedLocalName = localName.removeRange(localName.indexOf('+')..<localName.length)
            email.replaceRange(0..< email.indexOf('@'), sanitisedLocalName)
        }
    }

    private fun removePeriodsInLocalName(email: String): String {
        val atPos = email.indexOf('@')
        val sanitisedLocalName = email.substring(0..atPos)
            .replace(".", "")

        return email.replaceRange(0..atPos, sanitisedLocalName)
    }
}