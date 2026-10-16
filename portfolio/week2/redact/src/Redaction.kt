// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact(file: String, text: String, filter: Char = 'X'): String {
    val redaction = filter.toString().repeat(text.length)
    val redactedText = file.replace(text, redaction)

    return redactedText
}