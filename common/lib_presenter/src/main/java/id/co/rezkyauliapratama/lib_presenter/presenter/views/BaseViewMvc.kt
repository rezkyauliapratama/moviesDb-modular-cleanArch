package id.co.rezkyauliapratama.lib_presenter.presenter.views

import android.view.View
import androidx.annotation.StringRes

abstract class BaseViewMvc : ViewMvc {

    override lateinit var view: View

    protected fun getString(@StringRes id: Int): String? {
        return view.context.getString(id)
    }
}
