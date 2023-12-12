package ru.itmo.events.shared

actual fun getPlatformName(): String = "Android ${android.os.Build.VERSION.SDK_INT}"