package id.co.rezkyauliapratama.libcore.presenter.controllers.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRvAdapter<VIEWHOLDER : RecyclerView.ViewHolder> : RecyclerView.Adapter<VIEWHOLDER>() {

    abstract fun inject()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        inject()
    }
}
