package ru.alexleru.gims.questions.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.alexleru.gims.questions.api.ApiFactory
import ru.alexleru.gims.questions.database.AppDatabase

class ShareActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val movies = db.gimsDao().queryMovieList()

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getPopularMovie()
            .subscribeOn(Schedulers.io())
            .subscribe({
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