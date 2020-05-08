package com.arpit.unacadmy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var progress: String = "0"
    var progressState: MutableLiveData<Int> = MutableLiveData()

    fun onAnimateClick() {
        progressState.postValue(Integer.parseInt(progress))
    }

    fun onTextChanged(s: CharSequence) {
        progress = if (s.isEmpty())
            "0"
        else
            s.toString()
    }

}