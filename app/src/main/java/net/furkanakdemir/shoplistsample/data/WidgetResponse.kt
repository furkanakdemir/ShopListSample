package net.furkanakdemir.shoplistsample.data


import com.google.gson.annotations.SerializedName

data class WidgetResponse(
    @SerializedName("widgets") val widgetRaws: List<WidgetRaw?> = emptyList()
) {
    data class WidgetRaw(
        @SerializedName("bannerContents") val bannerContents: List<BannerContentRaw?>?,
        @SerializedName("displayCount") val displayCount: Int?,
        @SerializedName("displayOptions") val displayOptions: DisplayOptionsRaw?,
        @SerializedName("displayOrder") val displayOrder: Int?,
        @SerializedName("displayType") val displayType: String?,
        @SerializedName("endDate") val endDate: String?,
        @SerializedName("eventKey") val eventKey: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("products") val products: List<ProductRaw?>?,
        @SerializedName("startDate") val startDate: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("widgetNavigation") val widgetNavigationRaw: WidgetNavigationRaw?
    ) {
        data class BannerContentRaw(
            @SerializedName("bannerEventKey") val bannerEventKey: String?,
            @SerializedName("bannerPosition") val bannerPosition: String?,
            @SerializedName("displayOrder") val displayOrder: Int?,
            @SerializedName("height") val height: Int?,
            @SerializedName("imageUrl") val imageUrl: String?,
            @SerializedName("navigation") val navigation: NavigationRaw?,
            @SerializedName("width") val width: Int?,
            @SerializedName("title") val title: String?,
            @SerializedName("subtitle") val subtitle: String?
        ) {
            data class NavigationRaw(
                @SerializedName("deeplink") val deeplink: String?,
                @SerializedName("id") val id: Int?,
                @SerializedName("landingTitle") val landingTitle: String?,
                @SerializedName("navigationType") val navigationType: String?,
                @SerializedName("title") val title: String?
            )
        }

        data class DisplayOptionsRaw(
            @SerializedName("showClearButton") val showClearButton: Boolean?,
            @SerializedName("showCountdown") val showCountdown: Boolean?,
            @SerializedName("showProductFavoredButton") val showProductFavoredButton: Boolean?,
            @SerializedName("showProductPrice") val showProductPrice: Boolean?
        )

        data class ProductRaw(
            @SerializedName("averageRating") val averageRating: Double?,
            @SerializedName("boutiqueEndDate") val boutiqueEndDate: String?,
            @SerializedName("boutiqueId") val boutiqueId: Int?,
            @SerializedName("brandName") val brandName: String?,
            @SerializedName("businessUnit") val businessUnit: String?,
            @SerializedName("categoryHierarchy") val categoryHierarchy: String?,
            @SerializedName("categoryName") val categoryName: String?,
            @SerializedName("colorId") val colorId: Int?,
            @SerializedName("colorName") val colorName: String?,
            @SerializedName("contentId") val contentId: Int?,
            @SerializedName("discountPercentage") val discountPercentage: String?,
            @SerializedName("freeCargo") val freeCargo: Boolean?,
            @SerializedName("id") val id: Int?,
            @SerializedName("imageUrl") val imageUrl: String?,
            @SerializedName("mainId") val mainId: Int?,
            @SerializedName("marketPrice") val marketPrice: Double?,
            @SerializedName("merchantId") val merchantId: Int?,
            @SerializedName("name") val name: String?,
            @SerializedName("promotionList") val promotionList: List<Any?>?,
            @SerializedName("promotions") val promotions: List<Any?>?,
            @SerializedName("ratingCount") val ratingCount: Int?,
            @SerializedName("rushDelivery") val rushDelivery: Boolean?,
            @SerializedName("salePrice") val salePrice: Double?,
            @SerializedName("stamps") val stamps: List<Any?>?,
            @SerializedName("stockStatus") val stockStatus: Int?,
            @SerializedName("variants") val variants: List<VariantRaw?>?
        ) {
            data class VariantRaw(
                @SerializedName("campaignId") val campaignId: Int?,
                @SerializedName("listingId") val listingId: String?,
                @SerializedName("name") val name: String?,
                @SerializedName("price") val price: PriceRaw?,
                @SerializedName("value") val value: String?
            ) {
                data class PriceRaw(
                    @SerializedName("marketPrice") val marketPrice: Double?,
                    @SerializedName("salePrice") val salePrice: Double?
                )
            }
        }

        data class WidgetNavigationRaw(
            @SerializedName("deeplink") val deeplink: String?,
            @SerializedName("id") val id: Int?,
            @SerializedName("landingTitle") val landingTitle: String?,
            @SerializedName("navigationType") val navigationType: String?
        )
    }
}