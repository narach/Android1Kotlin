package by.itacademy.examples

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import by.itacademy.examples.databinding.ActivityMainBinding
import by.itacademy.examples.entities.*
import by.itacademy.examples.objects.Counter
import by.itacademy.examples.objects.NullSafetyExample
import by.itacademy.examples.objects.VarargFunctionExamples
import by.itacademy.examples.ui.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

const val TAG = "KotlinExamples"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    val producer1 = Producer("Guy", "Ritchie", LocalDate.parse("1968-10-09"))
    @RequiresApi(Build.VERSION_CODES.O)
    val producer2 = Producer("James", "Cameron", LocalDate.parse("1954-08-16"))

    private var film1 = Film("Lock, Stock and Two Smoking Barrels", null, 1998, Genre.Comedy, 25000000)
    private var film2 = Film("Avatar", producer2, 2009, Genre.ScienceFiction, 237000000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        val btnNullSafety: Button = findViewById(R.id.btnNullSafety)
        btnNullSafety.setOnClickListener {
            val producerName = NullSafetyExample.getProducerNameWithDefault(film1)
            Log.d(TAG, producerName)
        }

        val btnWhenExample = findViewById<Button>(R.id.btnWhenExample)
        btnWhenExample.setOnClickListener {
            whenExample(film1)
            whenExample(film2)
        }

        val onClickListener = View.OnClickListener {
            val someList = mutableListOf(1, 3, 5, 7, 10)
            Log.d(TAG, "InitialList: $someList")
            someList.swap(0, someList.size-1)
            Log.d(TAG, "After swap: $someList")

            var s1: String = "SomeString"
            Log.d(TAG, "$s1 contains only letters: ${s1.isLatinLettersOnly()}")

            var s2: String = "SomeStringWithDigits123"
            Log.d(TAG, "$s2 contains only letters: ${s2.isLatinLettersOnly()}")
        }

//        binding.btnExtention.setOnClickListener(onClickListener)
        btnExtention.setOnClickListener(onClickListener)

        binding.btnVarargExample.setOnClickListener {
            var pathLength = VarargFunctionExamples.polylineLength(
                Point(1.0, 2.0),
                Point(3.5, 4.5),
                Point(6.5, 8.5)
            )
            Log.d(TAG, "Path length: $pathLength")
        }

        val btnObjectExample = findViewById<Button>(R.id.btnObjectExample)
        btnObjectExample.setOnClickListener {
            objectExample()
        }
        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        tvCounter.text = Counter.currentCount().toString()

        binding.btnOperatorOverloading.setOnClickListener {
            operatorsOverloadingExample()
        }

        binding.btnSubmit.setOnClickListener {
            val secondActivityIntent : Intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("firstName", binding.etFirstName.text.toString())
                putExtra("lastName", binding.etLastName.text.toString())
            }
            startActivity(secondActivityIntent)
        }

        var s: String = "1234"
    }

    private fun whenExample(film: Film) {
        when (film.genre) {
            Genre.ScienceFiction -> Log.d(TAG, "Научная фантастика")
            Genre.Comedy -> Log.d(TAG, "Комедия")
            Genre.Action -> TODO()
            Genre.Adventure -> TODO()
            Genre.Crime -> TODO()
            Genre.Drama -> TODO()
            Genre.Epics -> TODO()
        }
    }

    private fun objectExample() {
        println("Initial count: ${Counter.currentCount()}")
        Counter.increment()
        println("After increment: ${Counter.currentCount()}")
        binding.tvCounter.text = Counter.currentCount().toString()
    }

    private fun String.isLatinLettersOnly() : Boolean {
        return this.trim().matches(Regex("[a-zA-Z]+"))
    }

    private fun <T> MutableList<T>.swap(ind1: Int, ind2: Int) {
        val tmp = this[ind1]
        this[ind1] = this[ind2]
        this[ind2] = tmp
    }

    private fun operatorsOverloadingExample() {
        val c1 = Complex(1.0, -1.0)
        val c2 = Complex(3.0, 6.0)
        Log.d(TAG,"Sum = ${c1 + c2}")
        Log.d(TAG,"Multiplication = ${c1 * c2}")
    }

    private fun scopeFunctionsExample() {

        var number: Int? = null

        var i = 0

        (i*i).also {
            i++
        } // Increase variable after square

        if (number != null) {
//            val num2 = number + 1 // Not Thread Safe
            val num2 = number!! + 1 // Again not thread safe, but will compile
        }

        val num2 = number?.let { num ->// Thread safe
            num + 1
        } ?: 3

        val intent = Intent().apply {
            putExtra("", "")
            putExtra("", 0)
            action = ""
        } // Returns Intent type

        val intent2 = Intent().run {
            putExtra("", "")
            putExtra("", 0)
            action = ""
//            this
        } // Return nothing(Unit)

        val intent3 = with(Intent()) {
            putExtra("", "")
            putExtra("", 0)
            action = ""
            this
        } // Just another syntax as run {}
    }
}