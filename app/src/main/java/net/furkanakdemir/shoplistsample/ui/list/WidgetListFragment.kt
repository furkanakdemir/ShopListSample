package net.furkanakdemir.shoplistsample.ui.list


import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.ui.WidgetViewModel
import net.furkanakdemir.shoplistsample.ui.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WidgetListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var widgetViewModel: WidgetViewModel


    override val layoutId: Int
        get() = R.layout.fragment_widget_list


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        widgetViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get()


        widgetViewModel.getWidgets()


        // TODO Remove UI is implemented
        Handler().postDelayed({
            findNavController().navigate(R.id.action_widgetListFragment_to_widgetDetailFragment)
        }, 1500)
    }
}
