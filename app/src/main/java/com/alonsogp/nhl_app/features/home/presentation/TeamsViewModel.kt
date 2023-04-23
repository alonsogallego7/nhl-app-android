package com.alonsogp.nhl_app.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.home.domain.GetTeamsUseCase
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getTeams(divisionId: Int) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getTeamsUseCase.invoke(divisionId).fold({
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

    private fun successResponse(teams: List<TeamModel>) {
        _uiState.postValue(
            UiState(
                isLoading = false,
                teams = teams
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val teams: List<TeamModel>? = null,
        val error: ErrorApp? = null
    )
}
