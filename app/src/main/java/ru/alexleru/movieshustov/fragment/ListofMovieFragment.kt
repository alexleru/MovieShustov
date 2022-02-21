package ru.alexleru.movieshustov.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import ru.alexleru.movieshustov.R
import ru.alexleru.movieshustov.viewmodel.ShareActivityViewModel


class ListofMovieFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var recyclerView: RecyclerView
    private val sharedViewModel: ShareActivityViewModel by activityViewModels()
    private val adapter: ListofMovieAdapter by lazy { ListofMovieAdapter() }
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_listof_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_item)
        recyclerView.adapter = adapter
        sharedViewModel.movies.observe(viewLifecycleOwner) { adapter.listOfMovie = it }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val search = menu.findItem(R.id.search_menu)
        searchView = search.actionView as SearchView
        searchView.isSubmitButtonEnabled
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        checkTextAndLoadData(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        checkTextAndLoadData(newText)
        return true
    }

    private fun checkTextAndLoadData(text: String?){


        if (text.isNullOrBlank()){
            sharedViewModel.loadData()
        } else {
            sharedViewModel.searchData(text)
            Log.i("MOVIE", text)
        }
        sharedViewModel.movies.observe(viewLifecycleOwner){adapter.listOfMovie = it}
    }

}