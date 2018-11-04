package cloudfirestone.infrastructure.firebase.network

import com.google.firebase.auth.*
import cloudfirestone.infrastructure.model.classes.UserInterface
import cloudfirestone.infrastructure.model.converter.UserConverter
import cloudfirestone.infrastructure.network.activity.ActivityLifeCycleInterface
import cloudfirestone.infrastructure.network.authentication.AuthenticationAPI
import cloudfirestone.infrastructure.network.authentication.login.LoginListener
import cloudfirestone.infrastructure.network.authentication.login.LoginError
import com.google.firebase.FirebaseNetworkException

private enum class FireBaseErrorCode(val value: String) {
    ERROR_INVALID_EMAIL("ERROR_INVALID_EMAIL"),
    ERROR_USER_NOT_FOUND("ERROR_USER_NOT_FOUND"),
    ERROR_WRONG_PASSWORD("ERROR_WRONG_PASSWORD")
}

class FireBaseAPIManager : ActivityLifeCycleInterface, AuthenticationAPI {

    private lateinit var auth: FirebaseAuth

    override fun onActivityCreate() {
        auth = FirebaseAuth.getInstance()
    }

    override fun onActivityStart() {

    }

    override fun login(email: String, password: String, listener: LoginListener) {

        email.isEmpty().takeIf { it }?.let {
            listener.error(LoginError.EMPTY_EMAIL)
            return
        }

        password.isEmpty().takeIf { it }?.let {
            listener.error(LoginError.EMPTY_PASSWORD)
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            when (task.isSuccessful) {
                false -> {

                    val exception = task.exception

                    val loginError: LoginError = when (exception) {

                        is FirebaseAuthException -> {

                            val fireBaseError = try {
                                FireBaseErrorCode.valueOf(exception.errorCode)
                            } catch (e: IllegalArgumentException) {
                                null
                            }

                            when (fireBaseError) {

                                FireBaseErrorCode.ERROR_WRONG_PASSWORD -> {
                                    LoginError.WRONG_PASSWORD
                                }

                                FireBaseErrorCode.ERROR_INVALID_EMAIL -> {
                                    LoginError.EMAIL_BAD_FORMAT
                                }

                                FireBaseErrorCode.ERROR_USER_NOT_FOUND -> {
                                    LoginError.EMAIL_NOT_FOUND
                                }

                                null -> LoginError.GENERIC
                            }

                        }

                        is FirebaseNetworkException -> {
                            LoginError.NETWORK_ERROR
                        }

                        else -> LoginError.GENERIC

                    }

                    listener.error(loginError)
                }

                true -> {
                    val user: UserInterface? = task.result.user?.let { fireBaseUser ->
                        UserConverter().convert(fireBaseUser)
                    }

                    user?.let {
                        listener.success(it)
                    } ?: run {
                        listener.error(LoginError.GENERIC)
                    }
                }
            }
        }
    }
}
