package net.furkanakdemir.shoplistsample.util.fakes

import net.furkanakdemir.shoplistsample.data.*
import net.furkanakdemir.shoplistsample.ui.data.ViewItem

object TestData {

    const val TEST_TITLE = "title"
    const val TEST_SUBTITLE = "subtitle"
    const val TEST_IMAGE_URL = "imageUrl"
    const val TEST_NAME = "name"
    const val TEST_CATEGORY = "category"
    const val TEST_ID = 1
    const val TEST_RATING = 5.0
    const val TEST_DISPLAY_COUNT = 1

    const val TEST_TYPE_UNKNOWN = "UNKNOWN"
    const val TEST_TYPE_BANNER = "BANNER"
    const val TEST_TYPE_PRODUCT = "PRODUCT"
    const val TEST_DISPLAY_TYPE_UNKNOWN = "UNKNOWN"
    const val TEST_DISPLAY_TYPE_SINGLE = "SINGLE"
    const val TEST_DISPLAY_TYPE_SLIDER = "SLIDER"
    const val TEST_DISPLAY_TYPE_LISTING = "LISTING"
    const val TEST_DISPLAY_TYPE_CAROUSEL = "CAROUSEL"

    val TEST_WIDGET_INFO = WidgetInfo(
        TEST_ID,
        TEST_DISPLAY_COUNT,
        TEST_TITLE,
        TEST_DISPLAY_TYPE_SINGLE,
        TEST_TYPE_BANNER
    )

    val TEST_WIDGET_INFO_SLIDER = WidgetInfo(
        TEST_ID,
        TEST_DISPLAY_COUNT,
        TEST_TITLE,
        TEST_DISPLAY_TYPE_SLIDER,
        TEST_TYPE_BANNER
    )

    val TEST_WIDGET_INFO_CAROUSEL = WidgetInfo(
        TEST_ID,
        TEST_DISPLAY_COUNT,
        TEST_TITLE,
        TEST_DISPLAY_TYPE_CAROUSEL,
        TEST_TYPE_BANNER
    )

    val TEST_WIDGET_INFO_LISTING = WidgetInfo(
        TEST_ID,
        TEST_DISPLAY_COUNT,
        TEST_TITLE,
        TEST_DISPLAY_TYPE_LISTING,
        TEST_TYPE_PRODUCT
    )

    val TEST_WIDGET_INFO_UNKNOWN = WidgetInfo(
        TEST_ID,
        TEST_DISPLAY_COUNT,
        TEST_TITLE,
        TEST_DISPLAY_TYPE_UNKNOWN,
        TEST_TYPE_BANNER
    )

    val TEST_BANNER_CONTENTS = listOf(
        BannerContent(
            TEST_TITLE,
            TEST_SUBTITLE,
            TEST_IMAGE_URL
        )
    )

    val TEST_PRODUCTS = listOf(
        Product(
            1,
            TEST_NAME,
            TEST_CATEGORY,
            TEST_IMAGE_URL,
            TEST_RATING
        )
    )

    val TEST_WIDGETS_VALID = listOf(
        Widget.Banner(TEST_WIDGET_INFO, TEST_BANNER_CONTENTS),
        Widget.Products(TEST_WIDGET_INFO, TEST_PRODUCTS),
        Widget.Banner(TEST_WIDGET_INFO, TEST_BANNER_CONTENTS),
        Widget.Products(TEST_WIDGET_INFO, TEST_PRODUCTS),
        Widget.Banner(TEST_WIDGET_INFO, TEST_BANNER_CONTENTS)
    )

    val TEST_VIEW_ITEM_VALID: List<ViewItem> = listOf(
        ViewItem.SingleViewItem(TEST_IMAGE_URL),
        ViewItem.SingleViewItem(TEST_IMAGE_URL),
        ViewItem.SingleViewItem(TEST_IMAGE_URL),
        ViewItem.SingleViewItem(TEST_IMAGE_URL),
        ViewItem.SingleViewItem(TEST_IMAGE_URL)
    )

    val TEST_WIDGET_UNKNOWN_DISPLAY_TYPE =
        Widget.Banner(TEST_WIDGET_INFO_UNKNOWN, TEST_BANNER_CONTENTS)

    val TEST_WIDGET_BANNER_SINGLE =
        Widget.Banner(TEST_WIDGET_INFO, TEST_BANNER_CONTENTS)

    val TEST_WIDGET_BANNER_SLIDER =
        Widget.Banner(TEST_WIDGET_INFO_SLIDER, TEST_BANNER_CONTENTS)

    val TEST_WIDGET_BANNER_CAROUSEL =
        Widget.Banner(TEST_WIDGET_INFO_CAROUSEL, TEST_BANNER_CONTENTS)

    val TEST_WIDGET_PRODUCT_LISTING =
        Widget.Products(TEST_WIDGET_INFO_LISTING, TEST_PRODUCTS)


    val TEST_BANNER_CONTENTS_RAW = WidgetResponse.WidgetRaw.BannerContentRaw(
        TEST_TITLE,
        TEST_SUBTITLE,
        TEST_IMAGE_URL
    )

    val TEST_PRODUCTS_RAW = WidgetResponse.WidgetRaw.ProductRaw(
        TEST_ID,
        TEST_NAME,
        TEST_CATEGORY,
        TEST_IMAGE_URL,
        TEST_RATING
    )

    val TEST_WIDGET_RAW_BANNER = WidgetResponse.WidgetRaw(
        TEST_ID,
        TEST_TITLE,
        TEST_TYPE_BANNER,
        TEST_DISPLAY_COUNT,
        TEST_DISPLAY_TYPE_SINGLE,
        listOf(TEST_BANNER_CONTENTS_RAW),
        emptyList()
    )

    val TEST_WIDGET_RAW_PRODUCT = WidgetResponse.WidgetRaw(
        TEST_ID,
        TEST_TITLE,
        TEST_TYPE_PRODUCT,
        TEST_DISPLAY_COUNT,
        TEST_DISPLAY_TYPE_SINGLE,
        emptyList(),
        listOf(TEST_PRODUCTS_RAW)
    )

    val TEST_WIDGET_RAW_UNKNOWN = WidgetResponse.WidgetRaw(
        TEST_ID,
        TEST_TITLE,
        TEST_TYPE_UNKNOWN,
        TEST_DISPLAY_COUNT,
        TEST_DISPLAY_TYPE_SINGLE,
        emptyList(),
        emptyList()
    )


}