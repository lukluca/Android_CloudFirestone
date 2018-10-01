package cloudfirestone.infrastructure.network.authentication.login

enum class LoginError {
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMAIL_BAD_FORMAT,
    EMAIL_NOT_FOUND,
    WRONG_PASSWORD,
    GENERIC
}