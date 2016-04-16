package com.devmikroblog.model

/**
 * Created by pnet-46 on 22.03.16.
 */
class Result<T> constructor(val value:T, val messages:List<String> = listOf()){

    val isSuccess:Boolean = value != null;

    companion object Factory{
        fun <T>ErrorWhenNoData(value:T, messages: List<String> = listOf()):Result<T>{
            return Result(value, messages)
        }
    }
}