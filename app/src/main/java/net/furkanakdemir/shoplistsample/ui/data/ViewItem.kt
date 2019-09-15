package net.furkanakdemir.shoplistsample.ui.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class ViewItem {
    abstract fun viewType(): Int

    object DefaultViewItem : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_IGNORED
    }

    data class SingleViewItem(val imageUrl: String) : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_SINGLE
    }

    data class SliderViewItem(val slides: List<Slide>) : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_SLIDER
    }

    data class ListingViewItem(val slides: List<Slide>) : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_LISTING
    }

    data class CarouselViewItem(val carousel: Carousel) : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_CAROUSEL
    }

    companion object {
        internal const val VIEW_TYPE_IGNORED = -1
        internal const val VIEW_TYPE_SINGLE = 1
        internal const val VIEW_TYPE_SLIDER = 2
        internal const val VIEW_TYPE_LISTING = 3
        internal const val VIEW_TYPE_CAROUSEL = 4
    }
}


@Parcelize
data class Slide(
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val displayCount: Int = 1,
    val isClickable: Boolean = false
) : Parcelable


data class Carousel(val images: List<String>)
