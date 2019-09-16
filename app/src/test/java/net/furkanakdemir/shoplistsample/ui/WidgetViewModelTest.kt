package net.furkanakdemir.shoplistsample.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import net.furkanakdemir.shoplistsample.data.WidgetRepository
import net.furkanakdemir.shoplistsample.result.Result
import net.furkanakdemir.shoplistsample.ui.data.ViewMapper
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_VIEW_ITEM_VALID
import net.furkanakdemir.shoplistsample.util.fakes.TestData.TEST_WIDGETS_VALID
import net.furkanakdemir.shoplistsample.util.testObserver
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.exceptions.base.MockitoException

@ExperimentalCoroutinesApi
class WidgetViewModelTest {

    private lateinit var widgetViewModel: WidgetViewModel
    private lateinit var widgetRepository: WidgetRepository
    private lateinit var viewMapper: ViewMapper

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewMapper = ViewMapper()
        widgetRepository = mock(WidgetRepository::class.java)
        widgetViewModel = WidgetViewModel(widgetRepository, viewMapper)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun testEmptyWidgets() = runBlockingTest {
        whenever(widgetRepository.getWidgets()).thenReturn(Result.Success(emptyList()))

        val testObserver = widgetViewModel.eventLiveData.testObserver()
        widgetViewModel.getWidgets()
        verify(widgetRepository).getWidgets()

        assertThat(testObserver.observedValues.size, `is`(2))
        assertThat(
            testObserver.observedValues[0]?.getContentIfNotHandled(),
            instanceOf(WidgetViewModel.ViewState.Loading::class.java)
        )
        assertThat(
            testObserver.observedValues[1]?.getContentIfNotHandled(),
            instanceOf(WidgetViewModel.ViewState.Empty::class.java)
        )
    }

    @Test
    fun testValidWidgets() = runBlockingTest {
        whenever(widgetRepository.getWidgets()).thenReturn(Result.Success(TEST_WIDGETS_VALID))

        val testObserver = widgetViewModel.eventLiveData.testObserver()
        val testWidgetObserver = widgetViewModel.widgetsLiveData.testObserver()
        widgetViewModel.getWidgets()

        assertThat(testObserver.observedValues.size, `is`(1))
        assertThat(
            testObserver.observedValues[0]?.getContentIfNotHandled(),
            instanceOf(WidgetViewModel.ViewState.Loading::class.java)
        )

        assertThat(testWidgetObserver.observedValues.size, `is`(1))
        assertThat(testWidgetObserver.observedValues[0], `is`(equalTo(TEST_VIEW_ITEM_VALID)))
    }

    @Test
    fun testErrorOnLoading() = runBlockingTest {
        whenever(widgetRepository.getWidgets()).thenReturn(Result.Error(MockitoException("FAILURE")))

        val testObserver = widgetViewModel.eventLiveData.testObserver()
        widgetViewModel.getWidgets()
        verify(widgetRepository).getWidgets()

        assertThat(testObserver.observedValues.size, `is`(2))
        assertThat(
            testObserver.observedValues[0]?.getContentIfNotHandled(),
            instanceOf(WidgetViewModel.ViewState.Loading::class.java)
        )
        assertThat(
            testObserver.observedValues[1]?.getContentIfNotHandled(),
            instanceOf(WidgetViewModel.ViewState.Error::class.java)
        )
    }
}
