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
    val isValidPassword: Boolean get() = password.length >= 6
    val passwordsMatch: Boolean get() = password == confirmPassword
    val isValidName: Boolean get() = name.length >= 2
}