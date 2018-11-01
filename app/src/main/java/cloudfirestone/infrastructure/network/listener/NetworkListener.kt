package cloudfirestone.infrastructure.network.listener

typealias SuccessListener<T> = (value:T) -> Unit

typealias ErrorListener<E> = (error:E) -> Unit

data class NetworkListener<T, E>(val success: SuccessListener<T>, val error: ErrorListener<E>)
