package infrastructure.network.login

enum class LoginError {
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMAIL_BAD_FORMAT,
    EMAIL_NOT_FOUND,
    WRONG_PASSWORD,
    GENERIC
}