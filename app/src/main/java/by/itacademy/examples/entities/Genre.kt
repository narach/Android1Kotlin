package by.itacademy.examples.entities

sealed class Genre {
    object Action: Genre()
    object Adventure: Genre()
    object Comedy: Genre()
    object Crime: Genre()
    object Drama: Genre()
    object Epics: Genre()
    object ScienceFiction: Genre()
    /*
    Horror, Musicals, ScienceFiction, War, Western, etc...
     */
}
