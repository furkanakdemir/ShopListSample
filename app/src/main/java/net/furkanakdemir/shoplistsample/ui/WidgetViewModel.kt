package net.furkanakdemir.shoplistsample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.furkanakdemir.shoplistsample.data.WidgetRepository
import javax.inject.Inject

class WidgetViewModel @Inject constructor(
    private val widgetRepository: WidgetRepository
) : ViewModel() {


    fun getWidgets() {
        viewModelScope.launch {
            val widgets = widgetRepository.getWidgets()

            widgets.forEach {
                println(it.toString())
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        // TODO Cancel active jobs
    }
}