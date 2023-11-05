interface Auth {
    fun login()
    fun logout()
}

class AdminAuth : Auth {
    override fun login() {
        println("Admin logged in.")
    }

    override fun logout() {
        println("Admin logged out.")
    }
}

class UserAuth : Auth {
    override fun login() {
        println("User logged in.")
    }

    override fun logout() {
        println("User logged out.")
    }
}

class SystemUser(val name: String, val isAdmin: Boolean): Auth {
    val auth: Auth = if (isAdmin) AdminAuth() else UserAuth()
    override fun login() = auth.login()
    override fun logout() = auth.logout()
}
