package cloudfirestone.infrastructure.firebase.converter

interface Converter<T, V> {
    fun convert(from: T): V?
}