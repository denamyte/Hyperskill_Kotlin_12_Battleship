interface UserSettings {
    var language: String
    var theme: String
}
class UserSettingsImpl : UserSettings {
    override var language: String = "English"
    override var theme: String = "Light"
}

class LoggingUserSettingsDelegate(val us: UserSettingsImpl): UserSettings by us {
    override var language: String
        get() = us.language
        set(value) {
            println("Language changed from ${us.language} to $value")
            us.language = value
        }
    override var theme: String
        get() = us.theme
        set(value) {
            println("Theme changed from ${us.theme} to $value")
            us.theme = value
        }
}

class UserSettingsWithLogging(userSettings: UserSettingsImpl) : UserSettings by LoggingUserSettingsDelegate(userSettings)