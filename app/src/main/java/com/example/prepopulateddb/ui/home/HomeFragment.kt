package com.example.prepopulateddb.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prepopulateddb.Models.Parcel
import com.example.prepopulateddb.Utils.DataHandler
import com.example.prepopulateddb.databinding.FragmentHomeBinding
import com.example.prepopulateddb.ui.home.Adapters.ParcelAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val parcelList : MutableList<Parcel> = arrayListOf()

    private lateinit var parcelAdapter: ParcelAdapter

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        parcelDataObserver()

        return root
    }

    private fun parcelDataObserver() {
        homeViewModel.trackLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataHandler.Success -> {
                    it.data?.let { it1 -> parcelList.addAll(it1) }
                    Timber.e(it.toString())

                    //val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)

                    /*binding.parcelRView.addItemDecoration(
                        DividerItemDecoration(
                            activity,
                            layoutManager.height
                        )
                    )*/

                    parcelAdapter = ParcelAdapter(parcelList)

                    // attach adapter to the recycler view
                    binding.parcelRView.adapter = parcelAdapter

                    val layoutManager = GridLayoutManager(requireActivity(), 2)

                    binding.parcelRView.layoutManager = layoutManager

                    // pass it to rvLists layoutManager
                    binding.parcelRView.layoutManager = layoutManager

                    binding.parcelRView.itemAnimator = DefaultItemAnimator()

                    parcelAdapter.notifyDataSetChanged()

                }

                is DataHandler.Error -> {
                    Timber.e("Data fetch error")
                }

                is DataHandler.Loading -> {
                    Timber.e("Loading... Please wait")
                }

                else -> {
                    Timber.e("Else-block")
                }
            }
        })

        homeViewModel.getTrackList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}