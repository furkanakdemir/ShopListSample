package net.furkanakdemir.shoplistsample.data

import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import net.furkanakdemir.shoplistsample.data.source.WidgetDataSource
import net.furkanakdemir.shoplistsample.result.Result
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGETS_VALID
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import java.io.IOException
import org.hamcrest.core.Is.`is` as Is


@ExperimentalCoroutinesApi
class WidgetRepositoryTest {

    private lateinit var widgetRepository: WidgetRepository
    private lateinit var widgetDataSource: WidgetDataSource

    @Before
    fun setUp() {
        widgetDataSource = Mockito.mock(WidgetDataSource::class.java)
        widgetRepository = RealWidgetRepository(widgetDataSource)
    }


    @Test
    fun testErrorList() = runBlockingTest {

        given(widgetDataSource.getWidgets()).willAnswer { throw IOException() }

        val actual = widgetRepository.getWidgets()

        assertThat(actual, instanceOf(Result.Error::class.java))
        assertThat((actual as Result.Error).exception, instanceOf(IOException::class.java))
    }


    @Test
    fun testEmptyList() = runBlockingTest {
        whenever(widgetDataSource.getWidgets()).thenReturn(emptyList())

        val actual = widgetRepository.getWidgets()
        val expected = emptyList<Widget>()

        assertThat(actual, instanceOf(Result.Success::class.java))
        assertThat((actual as Result.Success).data, Is(expected))
    }

    @Test
    fun testValidList() = runBlockingTest {
        whenever(widgetDataSource.getWidgets()).thenReturn(TEST_WIDGETS_VALID)

        val actual = widgetRepository.getWidgets()
        val expected = TEST_WIDGETS_VALID

        assertThat(actual, instanceOf(Result.Success::class.java))
        assertThat((actual as Result.Success).data, Is(expected))
    }
}
