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

    private val _eventLiveData = MutableLiveData<Event<String>>()
    val eventLiveData: LiveData<Event<String>>
        get() = _eventLiveData

    fun getWidgets() {
        viewModelScope.launch {
            when (val result = widgetRepository.getWidgets()) {
                is Result.Success -> {
                    if (result.data.isNullOrEmpty()) {
                        _eventLiveData.value = Event("Empty List")
                    } else {
                        val viewList = mutableListOf<ViewItem>()

                        result.data.forEach {
                            viewList += viewMapper.map(it)
                        }

                        _widgetsLiveData.value = viewList
                    }
                }
                is Result.Error -> {
                    _eventLiveData.value = Event("Error!")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        // TODO Cancel active jobs
    }
}
