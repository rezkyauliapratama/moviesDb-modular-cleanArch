package id.co.rezkyauliapratama.libuicomponent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.rezkyauliapratama.lib_presenter.R
import id.co.rezkyauliapratama.libcore.presenter.views.BaseViewMvc
import kotlinx.android.synthetic.main.widget_progressbar.view.*

class LoaderAdapterViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) : BaseViewMvc(),
    LoaderAdapterViewMvc {

    init {
        view = inflater.inflate(R.layout.widget_progressbar, parent, false)
    }

    override fun displayProgressBar() {
        view.pbFooter.visibility = View.VISIBLE
        view.tvFooterMessage.visibility = View.GONE
    }

    override fun displayMessage(message: String?) {
        view.pbFooter.visibility = View.GONE
        view.tvFooterMessage.visibility = View.VISIBLE
        view.tvFooterMessage.text = message ?: getString(R.string.footer_message)
    }

}