package kurmakaeva.anastasia.presentation.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kurmakaeva.anastasia.domain.HeroRepositoryInterface
import kurmakaeva.anastasia.domain.entities.Hero
import kurmakaeva.anastasia.presentation.ui.paging.HeroPagingSource
import javax.inject.Inject

@HiltViewModel
class SuperHeroesViewModel @Inject constructor(private val repository: HeroRepositoryInterface): ViewModel() {
    val superHeroes: Flow<PagingData<Hero>> =
        Pager(PagingConfig(pageSize = 10)) { HeroPagingSource(repository) }
        .flow
        .cachedIn(viewModelScope)
}