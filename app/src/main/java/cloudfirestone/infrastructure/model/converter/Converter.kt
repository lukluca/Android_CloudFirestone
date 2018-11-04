package cloudfirestone.infrastructure.model.converter

interface Converter<T, V> {
    fun convert(from: T): V?
}