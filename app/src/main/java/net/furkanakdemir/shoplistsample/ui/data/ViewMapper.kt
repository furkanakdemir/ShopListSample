package net.furkanakdemir.shoplistsample.ui.data

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.mapper.Mapper
import javax.inject.Inject

class ViewMapper @Inject constructor() : Mapper<Widget, ViewItem> {

    override fun map(input: Widget?): ViewItem {

        // TODO Fix this complexity
        input?.let {

            when (it.info.displayType) {

                "SINGLE" -> {
                    return when (it) {
                        is Widget.Banner -> ViewItem.SingleViewItem(it.bannerContents.first().imageUrl)
                        is Widget.Products -> ViewItem.SingleViewItem(it.products.first().imageUrl)
                        else -> ViewItem.DefaultViewItem
                    }
                }
                "SLIDER" -> {
                    return when (it) {
                        is Widget.Banner -> ViewItem.SliderViewItem(it.bannerContents.map { banner ->
                            Slide(
                                banner.title,
                                banner.subtitle,
                                banner.imageUrl,
                                it.info.displayCount
                            )
                        })
                        is Widget.Products -> ViewItem.SliderViewItem(it.products.map { product ->
                            Slide(
                                product.name,
                                product.categoryName,
                                product.imageUrl,
                                it.info.displayCount,
                                true
                            )
                        })
                        else -> ViewItem.DefaultViewItem
                    }
                }
                "LISTING" -> {
                    return when (it) {
                        is Widget.Banner -> ViewItem.ListingViewItem(it.bannerContents.map { banner ->
                            Slide(
                                banner.title,
                                banner.subtitle,
                                banner.imageUrl,
                                it.info.displayCount
                            )
                        })
                        is Widget.Products -> ViewItem.ListingViewItem(it.products.map { product ->
                            Slide(
                                product.name,
                                product.categoryName,
                                product.imageUrl,
                                it.info.displayCount,
                                isClickable = true
                            )
                        })
                        else -> ViewItem.DefaultViewItem
                    }
                }
                "CAROUSEL" -> {
                    return when (it) {
                        is Widget.Banner -> ViewItem.CarouselViewItem(
                            Carousel(it.bannerContents.map { banner -> banner.imageUrl })
                        )
                        is Widget.Products -> ViewItem.CarouselViewItem(
                            Carousel(
                                it.products.map { product -> product.imageUrl })
                        )
                        else -> ViewItem.DefaultViewItem
                    }
                }
                else -> return ViewItem.DefaultViewItem
            }
        }
        return ViewItem.DefaultViewItem
    }
}
