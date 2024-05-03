package com.eitadevelopment.invadetask.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.eitadevelopment.invadetask.core.utils.Constants
import com.eitadevelopment.invadetask.core.utils.doIfFailure
import com.eitadevelopment.invadetask.core.utils.doIfSuccess
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.domain.usecase.GetUniversitiesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) : ViewModel() {

    val universityDetails = MutableLiveData<UniversityDetails?>(null)
    private val _errorHandler = MutableLiveData<Exception?>(null)
    val errorHandler get() = _errorHandler.distinctUntilChanged()
    private val _loadingHandler = MutableLiveData(false)
    val loadingHandler get() = _loadingHandler.distinctUntilChanged()


    val reloadButton = MutableLiveData(false)
    private val _universities = MutableLiveData<List<UniversityDetails>?>()
        get() {
            viewModelScope.launch {
                _loadingHandler.value=true
                getUniversitiesUseCase().collect { result ->
                    result.doIfSuccess {
                        field.value = it

                    }
                    result.doIfFailure {
                        _errorHandler.value = it

                    }
                    _loadingHandler.value=false
                }
            }
            return field
        }
    val universities get() = _universities.distinctUntilChanged()

}

class SharedViewModelFactory @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SharedViewModel::class.java))
            SharedViewModel(getUniversitiesUseCase) as T
        else throw IllegalArgumentException(Constants.APP_MISS_CONTEXT)
    }
}