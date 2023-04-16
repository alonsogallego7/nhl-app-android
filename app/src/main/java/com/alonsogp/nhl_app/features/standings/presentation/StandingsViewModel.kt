package com.alonsogp.nhl_app.features.standings.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.standings.domain.GetStandingsUseCase
import com.alonsogp.nhl_app.features.standings.domain.RecordModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getStandingsUseCase: GetStandingsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getStandings() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getStandingsUseCase.invoke().fold({
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

    private fun successResponse(records : List<RecordModel>){
        _uiState.postValue(
            UiState(
                isLoading = false,
                records = records
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val records: List<RecordModel>? = null,
        val error: ErrorApp? = null
    )
}