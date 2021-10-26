package c.bmartinez.flickrfindr.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.flickrfindr.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchPhotosFragment: Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_photos_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.state.observe(viewLifecycleOwner, Observer {
            val photoList = it.photosMetaData?.photo
            Log.d("SearchPhotoFragment", "$photoList")
            photoList?.let { list ->
                linearLayoutManager = LinearLayoutManager(requireContext())
                recyclerView.layoutManager = linearLayoutManager
                photoAdapter = PhotoAdapter(list, requireContext())
                recyclerView.adapter = photoAdapter
            }
        })
    }
}