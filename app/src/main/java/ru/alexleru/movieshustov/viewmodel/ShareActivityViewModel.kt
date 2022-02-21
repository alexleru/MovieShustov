package ru.alexleru.movieshustov.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.alexleru.movieshustov.api.ApiFactory
import ru.alexleru.movieshustov.database.AppDatabase

class ShareActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val movies = db.gimsDao().queryMovieList()

    init {
        loadData()
    }

    fun loadData() {
        val disposable = ApiFactory.apiService.getPopularMovie()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.gimsDao().deleteAll()
                db.gimsDao().insertMovieList(it.results)
            }, {
                Log.e("Error", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    fun searchData(text: String) {
        val disposable = ApiFactory.apiService.getSearchMovie(search = text)
            .doOnError {  }
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.gimsDao().deleteAll()
                db.gimsDao().insertMovieList(it.results)
            }, {
                Log.e("Error", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}