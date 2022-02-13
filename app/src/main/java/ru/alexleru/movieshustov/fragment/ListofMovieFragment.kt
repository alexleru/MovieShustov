package ru.alexleru.movieshustov.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.alexleru.gims.questions.viewmodel.ShareActivityViewModel
import ru.alexleru.movieshustov.R


class ListofMovieFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val sharedViewModel: ShareActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listof_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListofMovieAdapter()
        recyclerView = view.findViewById(R.id.recycler_item)
        recyclerView.adapter = adapter
        sharedViewModel.movies.observe(viewLifecycleOwner) { adapter.listOfMovie = it }
    }

}