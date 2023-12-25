package za.co.bb.readbuddy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform