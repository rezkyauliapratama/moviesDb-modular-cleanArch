package id.co.rezkyauliapratama.lib_presenter.views

import android.content.Context
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding


abstract class BaseView: MvcView {
    
    protected fun getString(@StringRes id: Int): String? {
        return context.getString(id)
    }
}
