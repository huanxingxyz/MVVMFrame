package com.king.mvvmframe.kotlin.app.base

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.DataViewModel
import com.king.mvvmframe.kotlin.bean.Result
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class BaseViewModel @ViewModelInject constructor(application: Application, model: BaseModel) : DataViewModel(application, model) {


    fun isSuccess(result : Result<*>?, showError: Boolean = true): Boolean{
        if(result?.isSuccess == true){
            return true
        }
        if(showError){
            result?.message?.let {
                sendMessage(it)
            }
        }
        return false
    }

    fun launch(showLoading: Boolean = true, block: suspend () -> Unit){
        launch(showLoading, block, {
            Timber.w(it)
            sendMessage(it.message)
        })
    }

    fun launch(showLoading: Boolean, block: suspend () -> Unit, error: suspend (Throwable) -> Unit) = viewModelScope.launch {
        try {
            if(showLoading) {
                showLoading()
            }
            block()
        } catch (e: Throwable) {
            error(e)
        }
        if(showLoading){
            hideLoading()
        }

    }
}