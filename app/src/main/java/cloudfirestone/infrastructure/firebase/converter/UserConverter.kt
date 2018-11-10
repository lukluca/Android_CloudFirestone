package cloudfirestone.infrastructure.firebase.converter

import cloudfirestone.infrastructure.model.classes.User
import cloudfirestone.infrastructure.model.interfaces.UserInterface
import com.google.firebase.auth.FirebaseUser

class UserConverter: Converter<FirebaseUser, UserInterface> {

    override fun convert(from: FirebaseUser): UserInterface? {
        return from.email?.let {
            User(it)
        }
    }
}