package net.furkanakdemir.shoplistsample.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader
import net.furkanakdemir.shoplistsample.ui.base.BaseViewHolder
import net.furkanakdemir.shoplistsample.ui.data.ViewItem
import net.furkanakdemir.shoplistsample.ui.data.ViewItem.Companion.VIEW_TYPE_CAROUSEL
import net.furkanakdemir.shoplistsample.ui.data.ViewItem.Companion.VIEW_TYPE_LISTING
import net.furkanakdemir.shoplistsample.ui.data.ViewItem.Companion.VIEW_TYPE_SINGLE
import net.furkanakdemir.shoplistsample.ui.data.ViewItem.Companion.VIEW_TYPE_SLIDER


class WidgetListAdapter(
    val imageLoader: ImageLoader,
    val windowWidth: Int,
    val onSlideCallback: SliderAdapter.OnSlideCallback
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    var widgets: MutableList<ViewItem> = mutableListOf()
        set(value) {
            widgets.clear()
            widgets.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        return when (viewType) {
            VIEW_TYPE_SINGLE -> SingleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_widget, parent, false)
            )

            VIEW_TYPE_SLIDER -> SliderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_slider, parent, false)
            )

            VIEW_TYPE_LISTING -> ListingViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_slider, parent, false)
            )

            VIEW_TYPE_CAROUSEL -> CarouselViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_carousel, parent, false)
            )

            else -> throw IllegalArgumentException("Invalid view type $viewType")
        }
    }

    override fun getItemCount() = widgets.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val viewItem = widgets[position]

        when (holder) {
            is SingleViewHolder -> holder.bind(viewItem as ViewItem.SingleViewItem)
            is SliderViewHolder -> {
                holder.bind(viewItem as ViewItem.SliderViewItem)
            }
            is ListingViewHolder -> holder.bind(viewItem as ViewItem.ListingViewItem)
            is CarouselViewHolder -> holder.bind(viewItem as ViewItem.CarouselViewItem)
            else -> throw IllegalArgumentException("Invalid view holder $holder")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val viewItem = widgets[position]
        return viewItem.viewType()
    }

    inner class SingleViewHolder(itemView: View) :
        BaseViewHolder<ViewItem.SingleViewItem>(itemView) {
        override fun bind(item: ViewItem.SingleViewItem) {
            val imageView = itemView.findViewById<ImageView>(R.id.imageTextView)
            imageLoader.load(imageView, item.imageUrl)
        }
    }

    inner class SliderViewHolder(itemView: View) :
        BaseViewHolder<ViewItem.SliderViewItem>(itemView) {
        override fun bind(item: ViewItem.SliderViewItem) {
            val sliderRecyclerView = itemView.findViewById<RecyclerView>(R.id.sliderRecyclerView)
            sliderRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                adapter = SliderAdapter(item.slides, imageLoader, windowWidth, onSlideCallback)
                setRecycledViewPool(viewPool)
            }
        }
    }

    inner class ListingViewHolder(itemView: View) :
        BaseViewHolder<ViewItem.ListingViewItem>(itemView) {
        override fun bind(item: ViewItem.ListingViewItem) {
            val sliderRecyclerView = itemView.findViewById<RecyclerView>(R.id.sliderRecyclerView)
            sliderRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                adapter = SliderAdapter(item.slides, imageLoader, windowWidth, onSlideCallback)
                setRecycledViewPool(viewPool)
            }
        }
    }

    inner class CarouselViewHolder(itemView: View) :
        BaseViewHolder<ViewItem.CarouselViewItem>(itemView) {
        override fun bind(item: ViewItem.CarouselViewItem) {
            val viewPager = itemView.findViewById<ViewPager>(R.id.carouselViewPager)
            viewPager.adapter = CarouselAdapter(itemView.context, item.carousel.images, imageLoader)
        }
    }
}
