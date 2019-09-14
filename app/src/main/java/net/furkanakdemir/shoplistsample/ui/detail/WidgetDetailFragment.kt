package net.furkanakdemir.shoplistsample.ui.detail


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_widget_detail.*
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader
import net.furkanakdemir.shoplistsample.ui.base.BaseFragment
import net.furkanakdemir.shoplistsample.ui.data.Slide
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WidgetDetailFragment : BaseFragment() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override val title: String
        get() = TITLE_DETAIL

    override val layoutId: Int
        get() = R.layout.fragment_widget_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val slide: Slide = arguments?.getParcelable<Slide>("slide") as Slide
        imageLoader.load(productImageView, slide.imageUrl)
        nameTextView.text = slide.title
        categoryTextView.text = slide.subtitle
    }

    companion object {
        private val TITLE_DETAIL: String = "Detail"
    }
}
