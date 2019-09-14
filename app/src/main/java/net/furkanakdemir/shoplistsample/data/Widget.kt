package net.furkanakdemir.shoplistsample.data


sealed class Widget {
    object Ignored : Widget()
    data class Banner(val info: WidgetInfo, val bannerContents: List<BannerContent>) : Widget()
    data class Products(val info: WidgetInfo, val bannerContents: List<Product>) : Widget()
}


data class WidgetInfo(
    val id: Int,
    val displayCount: Int,
    val title: String,
    val displayType: String,
    val type: String
)

data class BannerContent(
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val height: Int,
    val width: Int
)

data class Product(
    val id: Int,
    val name: String,
    val categoryName: String,
    val imageUrl: String,
    val averageRating: Double
)
