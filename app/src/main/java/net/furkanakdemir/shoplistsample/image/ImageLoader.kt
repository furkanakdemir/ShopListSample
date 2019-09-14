package net.furkanakdemir.shoplistsample.image

import android.widget.ImageView

interface ImageLoader {

    fun load(imageView: ImageView, imageUrl: String)
}
