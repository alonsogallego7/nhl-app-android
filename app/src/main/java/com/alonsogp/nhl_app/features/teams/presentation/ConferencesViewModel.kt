package com.alonsogp.nhl_app.features.teams.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.teams.domain.ConferenceListModel
import com.alonsogp.nhl_app.features.teams.domain.ConferenceModel
import com.alonsogp.nhl_app.features.teams.domain.GetConferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConferencesViewModel @Inject constructor(
    private val getConferencesUseCase: GetConferencesUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getConferences() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getConferencesUseCase.invoke().fold({
                errorResponse(it)
            },{
                successResponse(it)
            })
        }
    }

    private fun errorResponse(error : ErrorApp){
        _uiState.postValue(
            UiState(
                isLoading = false,
                error = error
            )
        )
    }

    private fun successResponse(conferences : List<ConferenceListModel>){
        _uiState.postValue(
            UiState(
                isLoading = false,
                conferences = conferences
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val conferences: List<ConferenceListModel>? = null,
        val  error: ErrorApp? = null
    )
}