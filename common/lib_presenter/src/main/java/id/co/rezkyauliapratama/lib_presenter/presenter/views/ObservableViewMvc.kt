package id.co.rezkyauliapratama.lib_presenter.presenter.views


interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}
