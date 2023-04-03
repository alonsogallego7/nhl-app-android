package com.alonsogp.nhl_app.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.features.home.domain.GetTeamDetailUseCase
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailWithRosterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val getTeamDetailByIdUseCase: GetTeamDetailUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getTeamDetail(teamId: Int) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getTeamDetailByIdUseCase.invoke(teamId).fold({
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

    private fun successResponse(teamDetail : TeamDetailWithRosterModel){
        _uiState.postValue(
            UiState(
                isLoading = false,
                teamDetail = teamDetail
            )
        )
    }

    data class UiState(
        val isLoading: Boolean = true,
        val teamDetail: TeamDetailWithRosterModel? = null,
        val error: ErrorApp? = null
    )
}
