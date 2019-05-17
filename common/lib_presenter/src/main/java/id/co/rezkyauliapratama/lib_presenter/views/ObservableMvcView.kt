package id.co.rezkyauliapratama.lib_presenter.views


interface ObservableMvcView<ListenerType> : MvcView {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}
