package net.furkanakdemir.shoplistsample.data

sealed class Widget(open val info: WidgetInfo) {
    data class Default(override val info: WidgetInfo) : Widget(info)
    data class Banner(override val info: WidgetInfo, val bannerContents: List<BannerContent>) :
        Widget(info)

    data class Products(override val info: WidgetInfo, val products: List<Product>) : Widget(info)
}

data class WidgetInfo(
    val id: Int = -1,
    val displayCount: Int = 0,
    val title: String = "",
    val displayType: String = "",
    val type: String = ""
)

data class BannerContent(
    val title: String,
    val subtitle: String,
    val imageUrl: String
)

data class Product(
    val id: Int,
    val name: String,
    val categoryName: String,
    val imageUrl: String,
    val averageRating: Double
)
