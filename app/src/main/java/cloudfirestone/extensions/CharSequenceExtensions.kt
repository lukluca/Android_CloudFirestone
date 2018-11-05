package cloudfirestone.extensions

import java.util.regex.Pattern

private const val PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"

private val PASSWORD = Pattern.compile(PASSWORD_REGEX)

fun CharSequence.isEmailValid(): Boolean {
    return this.validate(android.util.Patterns.EMAIL_ADDRESS)
}

fun CharSequence.isPasswordValid(): Boolean {
    return this.validate(PASSWORD)
}

fun CharSequence.validate(pattern: Pattern): Boolean {
    return pattern.matcher(this).matches()
}