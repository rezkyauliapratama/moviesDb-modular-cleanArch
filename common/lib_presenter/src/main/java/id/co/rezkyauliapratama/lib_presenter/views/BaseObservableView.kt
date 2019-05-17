package id.co.rezkyauliapratama.lib_presenter.views

import java.util.*

abstract class BaseObservableView<ListenerType> : BaseView(), ObservableMvcView<ListenerType> {

    private val mListeners = HashSet<ListenerType>()

    protected val listeners: Set<ListenerType>
        get() = Collections.unmodifiableSet(mListeners)


    override fun registerListener(listener: ListenerType) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        mListeners.remove(listener)
    }
}
