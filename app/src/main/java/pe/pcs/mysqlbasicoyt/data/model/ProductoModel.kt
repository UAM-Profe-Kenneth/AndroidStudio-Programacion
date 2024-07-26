package pe.pcs.mysqlbasicoyt.data.model


/**
 *
 * It is a class that is designed to store data.
 * Data classes simplify the creation of classes that are only
 * intended to contain and manipulate data
 */
data class ProductoModel(
    var id: Int = 0,
    var descripcion: String = "",
    var codigobarra: String = "",
    var precio: Double = 0.0
)
