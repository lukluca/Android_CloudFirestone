package cloudfirestone.infrastructure.firebase.network

import com.google.firebase.auth.*
import cloudfirestone.infrastructure.dataclass.User
import cloudfirestone.infrastructure.dataclass.UserInterface
import cloudfirestone.infrastructure.network.activity.ActivityLifeCycleInterface
import cloudfirestone.infrastructure.network.authentication.AuthenticationAPI
import cloudfirestone.infrastructure.network.authentication.login.LoginError

private enum class FireBaseErrorCode(val value: String) {
    ERROR_INVALID_EMAIL("ERROR_INVALID_EMAIL"),
    ERROR_USER_NOT_FOUND("ERROR_USER_NOT_FOUND"),
    ERROR_WRONG_PASSWORD("ERROR_WRONG_PASSWORD")
}

class FireBaseAPIManager() : ActivityLifeCycleInterface, AuthenticationAPI {

    private lateinit var auth: FirebaseAuth


    override fun onActivityCreate() {
        auth = FirebaseAuth.getInstance()
    }

    override fun onActivityStart() {

    }

    override fun login(email: String, password: String, success: (user: UserInterface) -> Unit, error: (r: LoginError) -> Unit) {


        email.isEmpty().takeIf { it }?.let {
            error(LoginError.EMPTY_EMAIL)
            return
        }

        password.isEmpty().takeIf { it }?.let {
            error(LoginError.EMPTY_PASSWORD)
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            when (task.isSuccessful) {
                false -> {
                    val loginError: LoginError = (task.exception as? FirebaseAuthException)?.let { exception ->

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

                    } ?: run {
                        LoginError.GENERIC
                    }

                    error(loginError)
                }

                true -> {
                    task.result.user?.email?.let { emailFireBase ->
                        val user = User(emailFireBase)

                        success(user)
                    }
                }
            }
        }
    }

}