package com.platzi.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Speaker
import com.platzi.conf.network.Callback
import com.platzi.conf.network.FirestoreService


class SpeakersViewModel{
    val firestoreService = FirestoreService()
    var listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    fun getSpeakerFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeaker.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()

            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }

}