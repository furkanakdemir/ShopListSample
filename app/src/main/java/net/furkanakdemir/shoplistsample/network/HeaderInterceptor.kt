package net.furkanakdemir.shoplistsample.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest: Request = request.newBuilder()
            .addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE)
            .addHeader(HEADER_BUILD, HEADER_BUILD_VALUE)
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_CONTENT_TYPE_VALUE = "application/json"
        private const val HEADER_BUILD = "Build"
        private const val HEADER_BUILD_VALUE = "85"
    }
}
