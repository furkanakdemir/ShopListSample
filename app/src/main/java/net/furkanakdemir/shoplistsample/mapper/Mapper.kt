package net.furkanakdemir.shoplistsample.mapper

interface Mapper<I, O> {
    fun map(input: I?): O
}
