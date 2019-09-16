package net.furkanakdemir.shoplistsample.ui.data

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.mapper.Mapper
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_BANNER_CAROUSEL
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_BANNER_SINGLE
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_BANNER_SLIDER
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_PRODUCT_LISTING
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_UNKNOWN_DISPLAY_TYPE
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class ViewMapperTest {

    private lateinit var viewMapper: Mapper<Widget, ViewItem>

    @Before
    fun setUp() {
        viewMapper = ViewMapper()
    }

    @Test
    fun testNullInput() {
        val actual = viewMapper.map(null)
        assertThat(actual, instanceOf(ViewItem.DefaultViewItem::class.java))
    }

    @Test
    fun testUnknownInput() {
        val actual = viewMapper.map(TEST_WIDGET_UNKNOWN_DISPLAY_TYPE)
        assertThat(actual, instanceOf(ViewItem.DefaultViewItem::class.java))
    }

    @Test
    fun testMapSingleBanner() {
        val actual = viewMapper.map(TEST_WIDGET_BANNER_SINGLE)
        assertThat(actual, instanceOf(ViewItem.SingleViewItem::class.java))
    }

    @Test
    fun testMapSliderBanner() {
        val actual = viewMapper.map(TEST_WIDGET_BANNER_SLIDER)
        assertThat(actual, instanceOf(ViewItem.SliderViewItem::class.java))
    }

    @Test
    fun testMapListingProduct() {
        val actual = viewMapper.map(TEST_WIDGET_PRODUCT_LISTING)
        assertThat(actual, instanceOf(ViewItem.ListingViewItem::class.java))
    }

    @Test
    fun testMapCarouselBanner() {
        val actual = viewMapper.map(TEST_WIDGET_BANNER_CAROUSEL)
        assertThat(actual, instanceOf(ViewItem.CarouselViewItem::class.java))
    }
}