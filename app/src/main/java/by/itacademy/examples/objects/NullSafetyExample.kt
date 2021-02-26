package by.itacademy.examples.objects

import by.itacademy.examples.entities.Film
import by.itacademy.examples.entities.Genre
import by.itacademy.examples.entities.Producer

object NullSafetyExample {

    fun examples() {
        var notNullString: String = "Not Null"
        var nullableString: String? = "Nullable"

//        notNullString = null
        nullableString = null

        var film: Film = Film("Avatar", null, 2009, Genre.ScienceFiction, 237000000)

        // Null check - old version
        val producerName: String?
        if (film.producer != null) {
            val producer: Producer = film.producer!! // If producer is undefined - will throw NullPointer
            producerName = producer.firstName + producer.lastName
        }

        // Null check - way 2 - will be null if producer is undefined
        val producerName2 = film.producer?.firstName + " " + film.producer?.lastName

        // Null check - with default value
        val producerName3 = film.producer?.lastName ?: "Unknown Producer"
    }

    fun getProducerNameNullable(film: Film) : String? {
        if (film.producer != null) {
            val producer: Producer =
                film.producer!! // If producer is undefined - will throw NullPointer
            return producer.firstName + producer.lastName
        }
        return null
    }

    fun getProducerNameLet(film: Film) : String {
        film.producer?.let {
            return it.firstName + " " + it.lastName
        }
        return ""
    }

    fun getProducerName(film: Film) : String = film.producer?.firstName + " " + film.producer?.lastName

    fun getProducerNameWithDefault(film: Film) : String = film.producer?.lastName ?: "Unknown Producer"
}