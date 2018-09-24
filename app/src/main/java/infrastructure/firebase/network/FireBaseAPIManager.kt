package infrastructure.firebase.network

import android.app.Activity
import android.text.TextUtils
import com.google.firebase.auth.*
import infrastructure.dataclass.User
import infrastructure.dataclass.UserInterface
import infrastructure.network.activity.ActivityLifeCycleInterface
import infrastructure.network.login.LoginAPI
import infrastructure.network.login.LoginError

class FireBaseAPIManager(private val activity: Activity): ActivityLifeCycleInterface, LoginAPI {

    private lateinit var auth: FirebaseAuth

    private companion object {
        const val WRONG_PASSWORD_ERROR_CODE = "ERROR_WRONG_PASSWORD"
    }

    override fun onActivityCreate() {
        auth = FirebaseAuth.getInstance()
    }

    override fun onActivityStart() {

    }

    override fun login(email: String, password: String, success: (user: UserInterface) -> Unit, error: (r: LoginError) -> Unit) {

        TextUtils.isEmpty(email).takeIf { it }?.let {
            error(LoginError.EMPTY_EMAIL)
            return
        }

        TextUtils.isEmpty(password).takeIf { it }?.let{
            error(LoginError.EMPTY_PASSWORD)
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity) { task ->

            when (task.isSuccessful) {
                false -> {
                    task.exception?.let { exception ->
                        try {
                            throw exception
                        } catch (e: FirebaseAuthInvalidUserException) {
                            error(LoginError.EMAIL_NOT_FOUND)
                        } catch (e: FirebaseAuthInvalidCredentialsException) {
                            when (e.errorCode) {
                                WRONG_PASSWORD_ERROR_CODE -> {
                                    error(LoginError.WRONG_PASSWORD)
                                }

                                else -> {
                                    error(LoginError.EMAIL_BAD_FORMAT)
                                }
                            }
                        } catch (e: FirebaseAuthUserCollisionException) {
                            print("Failure login")
                            print(e.message)
                            print(e.localizedMessage)
                            print(e.cause)

                        } catch (e: Exception) {
                            error(LoginError.GENERIC)
                        }
                    }
                }

                true -> {
                    task.result.user?.email?.let {emailFireBase ->
                        val user = User(emailFireBase)

                        success(user)
                    }
                }
            }
        }
    }

}
