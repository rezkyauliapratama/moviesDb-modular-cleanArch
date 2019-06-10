package id.co.rezkyauliapratama.libuicomponent.common

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.core.content.ContextCompat
import id.co.rezkyauliapratama.lib_presenter.R
import java.lang.ref.WeakReference


object ProgressDialogUtil {
    private var dialog: Dialog? = null
    fun showProgressDialog(weakContext: WeakReference<Context>) {

        val context = weakContext.get()

        if (dialog == null && context != null) {
            dialog = Dialog(context)
            dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog?.setContentView(R.layout.dialog_progressbar)
            dialog?.window?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        context,
                        android.R.color.transparent
                    )
                )
            )
            dialog?.setCancelable(false)
        }
        dialog?.show()
    }

    fun hideProgressDialog() {
        if (dialog != null) {
            if (dialog!!.isShowing) {
                dialog?.dismiss()
            }
            dialog = null
        }
    }
}
