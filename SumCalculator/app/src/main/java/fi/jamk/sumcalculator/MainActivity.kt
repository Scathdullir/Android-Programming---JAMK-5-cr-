package fi.jamk.sumcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberInput (view: View) {
        // view is a button (pressed one) get text and convert to Int
        val digit = (view as Button).text.toString().toInt()

// append a new string to textView
       textView2.append(digit.toString())
    }

    // clicked number, like 55
    private var number: Int = 0

    // calculated sum
    private var sum: Int = 0


}
