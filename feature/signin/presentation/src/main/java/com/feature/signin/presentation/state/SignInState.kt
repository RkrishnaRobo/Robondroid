import android.util.Patterns
import com.core.common.state.State

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : State {
    val isValidEmail: Boolean get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isValidPassword: Boolean get() = password.length >= PASSWORD_LENGTH

    companion object {
        const val PASSWORD_LENGTH = 6
    }
}

sealed class NavigationState {
    data object None : NavigationState()
    data object NavigateToHome : NavigationState()
    data object NavigateToRegister : NavigationState()
}
