package pe.pcs.mysqlbasicoyt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.pcs.libpcs.UtilsCommon
import pe.pcs.mysqlbasicoyt.data.model.ProductoModel
import pe.pcs.mysqlbasicoyt.databinding.ItemsProductoBinding

/**
 * ------------------------------------------- Context and Use-------------------------------------------------------
 * ProductAdapter specializes in handling and displaying data of type ProductModel in a RecyclerView.
 *
 * -- RecyclerView :
 *      Its an UI component used to display a list or a set of items efficiently.It is a more
 *      advanced and flexible version of the ListView
 * -- Data Binding :
 *      Use ItemsProductoBinding to link the views in each item of the RecyclerView with the model data.
 *      This makes it easier to manipulate and display data in the user interface.
 * -- Click Events :
 *      By providing the IOnClickListener interface, the adapter allows the RecyclerView to handle click events on
 *      each item's buttons in a flexible and reusable way. In short, this adapter makes it easy to view and manage
 *      a list of products in a RecyclerView, allowing you to edit and delete products via click events.
 *
 * -------------------------------------------------------------------------------------------------------------------
 **/

class ProductoAdapter(
    /**
     * listener is an instance of IOnClickListener, which is an interface that defines two methods:
     * clickEdit and clickDelete. This allows handling click events on the edit and delete buttons
     */
    private val listener: IOnClickListener
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    private var lista = emptyList<ProductoModel>()

    /**
     * Defines two methods clickEdit and clickDelete that must be implemented by the class that uses this adapter.
     * These methods receive an object of type ProductModel and are called when the corresponding buttons are clicked.
     */
    interface IOnClickListener {
        fun clickEditar(producto: ProductoModel)
        fun clickEliminar(producto: ProductoModel)
    }

    /**
     * Adapters and ViewHolders:
     *
     *      -- RecyclerView uses an Adapter to provide the data and a ViewHolder to hold and manage the
     *          views of the individual elements.
     *      -- The Adapter is responsible for creating and binding the ViewHolder to the data.
     *          The ViewHolder maintains references to the views of an item to optimize interaction with them.
     *
     * An inner class :  is a class that is defined inside another class and has access
     * to the external instance of the class in which it is contained.As an example, to maintain a
     * reference to the instance of the activity or fragment that uses the adapter
     *
     */

    inner class ProductoViewHolder(private val binding: ItemsProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //This method binds the data of a ProductModel object to the views in the layout of an item
        fun enlazar(producto: ProductoModel) {
            binding.tvTitulo.text = producto.descripcion
            binding.tvCodigoBarra.text = producto.codigobarra
            binding.tvPrecio.text = UtilsCommon.formatFromDoubleToString(producto.precio)

            binding.ibEditar.setOnClickListener { listener.clickEditar(producto) }
            binding.ibEliminar.setOnClickListener { listener.clickEliminar(producto) }
        }
    }

    // Creates and returns an instance of ProductViewHolder by inflating the layout of an item using ItemsProductBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        return ProductoViewHolder(
            ItemsProductoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.enlazar(lista[position])
    }

    fun setData(listaProducto: List<ProductoModel>) {
        this.lista = listaProducto
        notifyDataSetChanged()
    }

}