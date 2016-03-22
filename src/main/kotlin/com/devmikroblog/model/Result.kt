package com.devmikroblog.model

/**
 * Created by pnet-46 on 22.03.16.
 */
class Result<T> constructor(val value:T){
    val isSuccess:Boolean = value != null;
}