package com.alonsogp.nhl_app.features.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import com.alonsogp.nhl_app.features.home.domain.GetDivisionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DivisionsViewModel @Inject constructor(
    private val getDivisionsUseCase: GetDivisionsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getDivisions(conferenceId: Int) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getDivisionsUseCase.invoke(conferenceId).fold({
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

    private fun successResponse(divisions : List<DivisionModel>){
        _uiState.postValue(
            UiState(
                isLoading = false,
                divisions = divisions
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val divisions: List<DivisionModel>? = null,
        val error: ErrorApp? = null
    )
}
