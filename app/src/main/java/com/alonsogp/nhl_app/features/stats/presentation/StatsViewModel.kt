package com.alonsogp.nhl_app.features.stats.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.stats.domain.GetGoalsPerGameUseCase
import com.alonsogp.nhl_app.features.stats.domain.GetShootingPctgUseCase
import com.alonsogp.nhl_app.features.stats.domain.GetShotsPerGameUseCase
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getGoalsPerGameUseCase: GetGoalsPerGameUseCase,
    private val getShotsPerGameUseCase: GetShotsPerGameUseCase,
    private val getShootingPctgUseCase: GetShootingPctgUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getGoalsPerGame() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getGoalsPerGameUseCase.invoke().fold({
                errorResponse(it)
            }, {
                successResponse(it)
            })
        }
    }

    fun getShotsPerGame() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getShotsPerGameUseCase.invoke().fold({
                errorResponse(it)
            }, {
                successResponse(it)
            })
        }
    }

    fun getShootingPctgPerGame() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getShootingPctgUseCase.invoke().fold({
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

    private fun successResponse(teams: List<TeamOneStatModel>?) {
        _uiState.postValue(
            UiState(
                isLoading = false,
                teams = teams
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val teams: List<TeamOneStatModel>? = null,
        val error: ErrorApp? = null
    )
}