package c.bmartinez.flickrfindr.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import c.bmartinez.flickrfindr.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace<SearchPhotosFragment>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack("search_photos")
        }
    }
}