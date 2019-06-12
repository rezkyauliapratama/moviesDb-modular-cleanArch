package id.co.rezkyauliapratama.libnavigation

import android.content.Context
import android.content.Intent


object Actions {
    fun openHomeIntent(context: Context) : Intent = internalIntent(context, HOME)

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}

private const val HOME = "action.home.open"
