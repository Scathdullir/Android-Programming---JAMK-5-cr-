package fi.jamk.launchmap

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMap(v: View) {
        //adding latitude and longitude values
        val lat = latitudeEditText.text.toString().toDouble()
        val lng = longitudeEditText.text.toString().toDouble()

        //creating the intent
        val location = Uri.parse("geo:$lat,$lng")
        val mapIntent = Intent(Intent.ACTION_VIEW, location)

        //verifying that the intent resolves
        val activities = packageManager.queryIntentActivities(mapIntent, 0)
        val isIntentSafe: Boolean = activities.isNotEmpty()

        //start the activity if it is safe
        if (isIntentSafe) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Error! There is no activity to show the map intent!", Toast.LENGTH_LONG).show();
        }
    }
}
