package net.furkanakdemir.shoplistsample.data


import com.google.gson.annotations.SerializedName

data class WidgetResponse(
    @SerializedName("widgets") val widgetRaws: List<WidgetRaw?> = emptyList()
) {
    data class WidgetRaw(
        @SerializedName("id") val id: Int?,
        @SerializedName("title") val title: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("displayCount") val displayCount: Int?,
        @SerializedName("displayType") val displayType: String?,
        @SerializedName("bannerContents") val bannerContents: List<BannerContentRaw?>?,
        @SerializedName("products") val products: List<ProductRaw?>?
    ) {
        data class BannerContentRaw(
            @SerializedName("title") val title: String?,
            @SerializedName("subtitle") val subtitle: String?,
            @SerializedName("imageUrl") val imageUrl: String?
        )

        data class ProductRaw(
            @SerializedName("id") val id: Int?,
            @SerializedName("name") val name: String?,
            @SerializedName("categoryName") val categoryName: String?,
            @SerializedName("imageUrl") val imageUrl: String?,
            @SerializedName("averageRating") val averageRating: Double?
        )
    }
}
