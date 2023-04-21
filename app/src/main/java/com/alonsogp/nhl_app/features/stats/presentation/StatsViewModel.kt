package com.alonsogp.nhl_app.features.stats.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.stats.domain.GetStatsUseCase
import com.alonsogp.nhl_app.features.stats.domain.PlayerWithStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getStatsUseCase: GetStatsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getStats() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getStatsUseCase.invoke().fold({
                errorResponse(it)
            }, {
                successResponse(it)
            })
        }
    }

    private fun errorResponse(error: ErrorApp) {
        _uiState.postValue(
            UiState(
                isLoading = false,
                error = error
            )
        )
    }

    private fun successResponse(playersWithStats: List<PlayerWithStats>?) {
        _uiState.postValue(
            UiState(
                isLoading = false,
                playersWithStats = playersWithStats
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val playersWithStats: List<PlayerWithStats>? = null,
        val error: ErrorApp? = null
    )
}