import android.util.Patterns
import com.core.common.state.State

data class RegistrationState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isRegistering: Boolean = false,
    val registrationSuccess: Boolean = false,
    val errorMessage: String? = null
) : State {
    // Helper computed properties
    val isValidEmail: Boolean get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isValidPassword: Boolean get() = password.length >= PASSWORD_LENGTH
    val passwordsMatch: Boolean get() = password == confirmPassword
    val isValidName: Boolean get() = name.length >= NAME_LENGTH

    private companion object {
        const val PASSWORD_LENGTH = 6
        const val NAME_LENGTH = 2
    }
}

sealed class NavState {
    data object None : NavState()
    data object NavigateToHome : NavState()
    data object NavigateToLogin : NavState()
}
