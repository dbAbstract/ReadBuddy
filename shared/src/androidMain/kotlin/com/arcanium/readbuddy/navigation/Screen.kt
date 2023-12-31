package com.arcanium.readbuddy.navigation

interface Screen {
    val route: String
}

data object OnboardingGraph : Screen {
    override val route: String = "Onboarding"

    data object SignUp : Screen {
        override val route: String = "Onboarding.SignUp"
    }

    data object Personalize : Screen {
        override val route: String = "Onboarding.Personalize"
    }
}