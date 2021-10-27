package c.bmartinez.flickrfindr.presentation

sealed class Screen(val route: String) {
    object MainScreen: Screen("mainScreen")
    object FullImageScreen: Screen("fullImageScreen")
}
