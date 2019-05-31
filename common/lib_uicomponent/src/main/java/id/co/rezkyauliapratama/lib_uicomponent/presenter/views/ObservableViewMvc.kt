package id.co.rezkyauliapratama.lib_uicomponent.presenter.views


interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}
