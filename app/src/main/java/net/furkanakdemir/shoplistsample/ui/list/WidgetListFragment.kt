package net.furkanakdemir.shoplistsample.ui.list

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_widget_list.*
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader
import net.furkanakdemir.shoplistsample.result.EventObserver
import net.furkanakdemir.shoplistsample.ui.WidgetViewModel
import net.furkanakdemir.shoplistsample.ui.base.BaseFragment
import net.furkanakdemir.shoplistsample.ui.data.Slide
import net.furkanakdemir.shoplistsample.util.getWindowWidth
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WidgetListFragment : BaseFragment(), SliderAdapter.OnSlideCallback {

    private lateinit var widgetListAdapter: WidgetListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var widgetViewModel: WidgetViewModel

    @Inject
    lateinit var imageLoader: ImageLoader

    override val layoutId: Int
        get() = R.layout.fragment_widget_list

    override val title: String
        get() = TITLE_LIST

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        widgetViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get()

        setupRecyclerView()

        widgetViewModel.widgetsLiveData.observe(this, Observer {
            widgetListAdapter.widgets = it.toMutableList()
            showContent()
        })

        widgetViewModel.eventLiveData.observe(this, EventObserver {

            when (it) {
                is WidgetViewModel.ViewState.Loading -> showLoading()
                is WidgetViewModel.ViewState.Empty -> showMessage(it.message)
                is WidgetViewModel.ViewState.Error -> showMessage(it.message)
            }
        })

        widgetViewModel.getWidgets()
    }

    private fun setupRecyclerView() {
        val windowWidth = requireActivity().getWindowWidth()

        widgetListAdapter = WidgetListAdapter(imageLoader, windowWidth, this)

        widgetsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = widgetListAdapter
        }
    }

    private fun showLoading() {
        messageTextView.visibility = GONE
        widgetsRecyclerView.visibility = GONE
        progressBar.visibility = VISIBLE
    }

    private fun showMessage(message: String) {
        messageTextView.text = message
        messageTextView.visibility = VISIBLE
        widgetsRecyclerView.visibility = GONE
        progressBar.visibility = GONE
    }

    private fun showContent() {
        messageTextView.visibility = GONE
        widgetsRecyclerView.visibility = VISIBLE
        progressBar.visibility = GONE
    }

    override fun onSlideClicked(item: Slide) {

        val action = WidgetListFragmentDirections.actionWidgetListFragmentToWidgetDetailFragment()
            .setSlide(item)
        findNavController().navigate(action)
    }

    companion object {
        private const val TITLE_LIST = "Shopping"
    }
}
