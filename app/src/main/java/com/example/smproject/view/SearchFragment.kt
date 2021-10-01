package com.example.smproject.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smproject.R
import com.example.smproject.model.Search
import com.example.smproject.model.SearchMovieResponse
import com.example.smproject.network.API_KEY
import com.example.smproject.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(), SearchMovieAdapter.Callback {
    private var adapter: SearchMovieAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var searchText: EditText? = null
    private var searchButton: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        searchText = view.findViewById(R.id.et_search)
        searchButton = view.findViewById(R.id.search)
        recyclerView?.layoutManager = LinearLayoutManager(context)

        searchButton?.setOnClickListener { getSearchList() }
        return view
    }

    fun getSearchList() {
        Api.getRetInterface().searchMovieByTitle(searchText?.text.toString(), API_KEY)
            .enqueue(object : Callback<SearchMovieResponse> {
                override fun onResponse(
                    call: Call<SearchMovieResponse>,
                    response: Response<SearchMovieResponse>
                ) {
                    adapter = SearchMovieAdapter(response.body()?.Search)
                    recyclerView?.adapter = adapter

                    adapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<SearchMovieResponse>, t: Throwable) {
                    Log.d("FAILED TAG", t.message.toString())
                }

            })
    }

    override fun onItemClick(searchItem: Search?) {
        val detailFragment = DetailFragment(searchItem)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, detailFragment)
            ?.commit()
    }
}