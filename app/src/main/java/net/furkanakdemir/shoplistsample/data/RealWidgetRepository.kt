package net.furkanakdemir.shoplistsample.data

import net.furkanakdemir.shoplistsample.data.source.WidgetDataSource
import net.furkanakdemir.shoplistsample.result.Result
import java.io.IOException
import javax.inject.Inject

class RealWidgetRepository @Inject constructor(
    private val remoteDataSource: WidgetDataSource
) : WidgetRepository {
    override suspend fun getWidgets(): Result<List<Widget>> {
        return try {
            val releases = remoteDataSource.getWidgets()
            Result.Success(releases)
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}
