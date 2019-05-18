package id.co.rezkyauliapratama.lib_presenter.views

import androidx.annotation.StringRes

abstract class BaseViewMvc: ViewMvc {

    protected fun getString(@StringRes id: Int): String? {
        return context.getString(id)
    }
}
