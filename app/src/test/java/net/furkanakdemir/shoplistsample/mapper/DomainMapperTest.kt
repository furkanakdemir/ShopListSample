package net.furkanakdemir.shoplistsample.mapper

import net.furkanakdemir.shoplistsample.data.Widget
import net.furkanakdemir.shoplistsample.data.WidgetResponse
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_BANNER_CONTENTS
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_PRODUCTS
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_RAW_BANNER
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_RAW_PRODUCT
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGET_RAW_UNKNOWN
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as Is

class DomainMapperTest {

    private lateinit var domainMapper: Mapper<WidgetResponse.WidgetRaw?, Widget>

    @Before
    fun setUp() {
        domainMapper = DomainMapper()
    }

    @Test
    fun testNullInput() {
        val actual = domainMapper.map(null)
        assertThat(actual, instanceOf(Widget.Default::class.java))
    }


    @Test
    fun testUnknownInput() {
        val actual = domainMapper.map(TEST_WIDGET_RAW_UNKNOWN)
        assertThat(actual, instanceOf(Widget.Default::class.java))
    }

    @Test
    fun testProductsInput() {
        val actual = domainMapper.map(TEST_WIDGET_RAW_PRODUCT)
        assertThat(actual, instanceOf(Widget.Products::class.java))
        assertThat((actual as Widget.Products).products.size, Is(1))
        assertThat(actual.products, Is(TEST_PRODUCTS))
    }


    @Test
    fun testBannersInput() {
        val actual = domainMapper.map(TEST_WIDGET_RAW_BANNER)
        assertThat(actual, instanceOf(Widget.Banner::class.java))
        assertThat((actual as Widget.Banner).bannerContents.size, Is(1))
        assertThat(actual.bannerContents, Is(TEST_BANNER_CONTENTS))
    }


}