package net.furkanakdemir.shoplistsample.ui.list


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.fragment_widget_list.*
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader
import net.furkanakdemir.shoplistsample.result.EventObserver
import net.furkanakdemir.shoplistsample.ui.WidgetViewModel
import net.furkanakdemir.shoplistsample.ui.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WidgetListFragment : BaseFragment() {

    private lateinit var widgetListAdapter: WidgetListAdapter


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var widgetViewModel: WidgetViewModel

    @Inject
    lateinit var imageLoader: ImageLoader


    override val layoutId: Int
        get() = R.layout.fragment_widget_list


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        widgetViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get()

        setupRecyclerView()

        widgetViewModel.widgetsLiveData.observe(this, Observer {
            widgetListAdapter.widgets = it.toMutableList()
        })

        widgetViewModel.eventLiveData.observe(this, EventObserver {
            // TODO Consume events
            println(it)
        })

        widgetViewModel.getWidgets()
    }

    private fun setupRecyclerView() {
        widgetListAdapter = WidgetListAdapter(imageLoader)

        widgets_recycler_view.apply {
            setHasFixedSize(true)
            adapter = widgetListAdapter
        }
    }

}
