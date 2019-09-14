package net.furkanakdemir.shoplistsample.mapper

class RealListMapper<I, O>(
    private val mapper: Mapper<I?, O>
) : ListMapper<I, O> {
    override fun map(input: List<I?>?): List<O> = input?.map { mapper.map(it) } ?: emptyList()
}
