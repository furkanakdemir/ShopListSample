package net.furkanakdemir.shoplistsample.ui.data

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

    data class ListingViewItem(val imageUrl: String) : ViewItem() {
        override fun viewType(): Int = VIEW_TYPE_LISTING
    }

    data class CarouselViewItem(val imageUrl: String) : ViewItem() {
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


class Slide(
    val title: String,
    val subtitle: String,
    val imageUrl: String
)