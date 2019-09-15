package net.furkanakdemir.shoplistsample.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader


class CarouselAdapter(
    private val context: Context,
    private val images: List<String>,
    private val imageLoader: ImageLoader
) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout =
            inflater.inflate(R.layout.list_item_carousel_item, collection, false) as ViewGroup
        val pagerImageView = layout.findViewById<ImageView>(R.id.imageTextView)
        imageLoader.load(pagerImageView, images[position])
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return this.images.size
    }

    override fun isViewFromObject(view: View, other: Any): Boolean {
        return view == other
    }
}