package net.furkanakdemir.shoplistsample.util

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.testObserver() = TestObserver<T>().also {
    observeForever(it)
}