package id.co.rezkyauliapratama.lib_uicomponent.presenter.viewmodels

import androidx.lifecycle.MediatorLiveData

abstract class BaseViewModelState<STATE>: BaseViewModel() {
    val stateLiveData: MediatorLiveData<STATE> = MediatorLiveData()

}