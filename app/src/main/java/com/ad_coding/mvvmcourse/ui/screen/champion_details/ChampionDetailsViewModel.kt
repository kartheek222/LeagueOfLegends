package com.ad_coding.mvvmcourse.ui.screen.champion_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.ad_coding.mvvmcourse.domain.model.ChampionModel
import com.ad_coding.mvvmcourse.domain.repository.ApiRepository
import com.ad_coding.mvvmcourse.ui.unil.ChampionDetails
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var champion = mutableStateOf<ChampionModel?>(null)

    init {

        val args = savedStateHandle.toRoute<ChampionDetails>()
        viewModelScope.launch {
            apiRepository.getChampinionByName(args.name)
                .onSuccess {
                    champion.value = data.champion.values.firstOrNull()
                }
        }
    }
}