package fi.jamk.citymapexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker home and move the camera
        val home = LatLng(59.432500, 24.471442)
        mMap.addMarker(MarkerOptions().position(home).title("Marker in Ilmandu, Estonia, home"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 6F))
        // another marker - mikkeli home
        val mikkelihome = LatLng(61.707005, 27.284254)
        mMap.addMarker(MarkerOptions().position(mikkelihome).title("Marker in Mikkeli, Finland, home"))
        // add marker in tampere
        val tampere = LatLng(61.523396, 23.671748)
        mMap.addMarker(MarkerOptions().position(tampere).title("Marker in Tampere, Finland"))
        // add marker in Uus Kasepää
        val uuskasepaa = LatLng(58.517967, 27.237881)
        mMap.addMarker(MarkerOptions().position(uuskasepaa).title("Marker in Uus Kasepää, Estonia"))
        // add marker in kohtla järve
        val kohtlajarve = LatLng(59.399221, 27.284667)
        mMap.addMarker(MarkerOptions().position(kohtlajarve).title("Marker in Kohtla Järve, Estonia"))
    }
}
