package net.furkanakdemir.shoplistsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.data.WidgetRepository
import net.furkanakdemir.shoplistsample.mapper.Mapper
import net.furkanakdemir.shoplistsample.result.Event
import net.furkanakdemir.shoplistsample.result.Result
import net.furkanakdemir.shoplistsample.ui.data.ViewItem
import javax.inject.Inject

class WidgetViewModel @Inject constructor(
    private val widgetRepository: WidgetRepository,
    private val viewMapper: Mapper<Widget, ViewItem>
) : ViewModel() {

    private val _widgetsLiveData = MutableLiveData<List<ViewItem>>()
    val widgetsLiveData: LiveData<List<ViewItem>>
        get() = _widgetsLiveData

    private val _eventLiveData = MutableLiveData<Event<ViewState>>()
    val eventLiveData: LiveData<Event<ViewState>>
        get() = _eventLiveData

    fun getWidgets() {
        _eventLiveData.value = Event(ViewState.Loading)
        viewModelScope.launch {
            when (val result = widgetRepository.getWidgets()) {
                is Result.Success -> {
                    if (result.data.isNullOrEmpty()) {
                        _eventLiveData.value = Event(ViewState.Empty("Empty List"))
                    } else {
                        val viewList = mutableListOf<ViewItem>()
                        result.data.forEach { viewList += viewMapper.map(it) }
                        _widgetsLiveData.value = viewList
                    }
                }
                is Result.Error -> {
                    _eventLiveData.value = Event(ViewState.Error("Failed to load the data!"))
                }
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Empty(val message: String) : ViewState()
        data class Error(val message: String) : ViewState()
    }
}
