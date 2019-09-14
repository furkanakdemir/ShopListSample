package net.furkanakdemir.shoplistsample.mapper

import net.furkanakdemir.shoplistsample.data.*
import javax.inject.Inject

class DomainMapper @Inject constructor() : Mapper<WidgetResponse.WidgetRaw?, Widget> {
    override fun map(input: WidgetResponse.WidgetRaw?): Widget {

        return input?.let {


            return when (it.type) {

                "PRODUCT" -> {
                    val widgetInfo: WidgetInfo = buildWidgetInfo(it)
                    val products: List<Product> = buildProducts(it)

                    return Widget.Products(widgetInfo, products)
                }
                "BANNER" -> {
                    val widgetInfo: WidgetInfo = buildWidgetInfo(it)
                    val bannerContents: List<BannerContent> = buildBannerContents(it)

                    return Widget.Banner(widgetInfo, bannerContents)
                }


                else -> Widget.Ignored
            }
        } ?: Widget.Ignored

    }

    private fun buildBannerContents(widgetRaw: WidgetResponse.WidgetRaw): List<BannerContent> {
        val bannerContents = mutableListOf<BannerContent>()

        widgetRaw.bannerContents?.let {
            it.forEach { contentRaw ->
                bannerContents += BannerContent(
                    contentRaw?.title ?: "",
                    contentRaw?.subtitle ?: "",
                    contentRaw?.imageUrl ?: "",
                    contentRaw?.height ?: 0,
                    contentRaw?.width ?: 0
                )
            }
        }

        return bannerContents

    }

    private fun buildProducts(widgetRaw: WidgetResponse.WidgetRaw): List<Product> {
        val products = mutableListOf<Product>()

        widgetRaw.products?.let {
            it.forEach { productRaw ->
                products += Product(
                    productRaw?.id ?: -1,
                    productRaw?.name ?: "",
                    productRaw?.categoryName ?: "",
                    productRaw?.imageUrl ?: "",
                    productRaw?.averageRating ?: 0.0
                )
            }
        }

        return products
    }

    private fun buildWidgetInfo(widgetRaw: WidgetResponse.WidgetRaw): WidgetInfo {

        return with(widgetRaw) {
            WidgetInfo(
                id ?: -1,
                displayCount ?: 0,
                title ?: "",
                displayType ?: "",
                type ?: ""
            )
        }
    }
}