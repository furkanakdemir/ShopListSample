package net.furkanakdemir.shoplistsample.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.furkanakdemir.shoplistsample.R
import net.furkanakdemir.shoplistsample.image.ImageLoader
import net.furkanakdemir.shoplistsample.ui.base.BaseViewHolder
import net.furkanakdemir.shoplistsample.ui.data.Slide

class SliderAdapter(
    private val slides: List<Slide>,
    val imageLoader: ImageLoader,
    val windowWidth: Int,
    val onSlideCallback: OnSlideCallback
) :
    RecyclerView.Adapter<BaseViewHolder<Slide>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Slide> =
        SlideViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_slide, parent, false)
        )

    override fun getItemCount(): Int = slides.size

    override fun onBindViewHolder(holder: BaseViewHolder<Slide>, position: Int) =
        holder.bind(slides[position])


    inner class SlideViewHolder(itemView: View) :
        BaseViewHolder<Slide>(itemView) {
        override fun bind(item: Slide) {

            // Set width according to server response
            itemView.layoutParams.width = windowWidth / item.displayCount

            // Set a margin to render the next item
            itemView.layoutParams.width -= windowWidth / 10

            val imageView = itemView.findViewById<ImageView>(R.id.slideImageView)
            val slideTitleTextView = itemView.findViewById<TextView>(R.id.slideTitleTextView)
            val slideSubtitleTextView = itemView.findViewById<TextView>(R.id.slideSubtitleTextView)

            slideTitleTextView.text = item.title
            slideSubtitleTextView.text = item.subtitle
            imageLoader.load(imageView, item.imageUrl)

            if (item.isClickable) {
                itemView.setOnClickListener {
                    onSlideCallback.onSlideClicked(item)
                }
            }
        }
    }

    interface OnSlideCallback {
        fun onSlideClicked(item: Slide)
    }
}
