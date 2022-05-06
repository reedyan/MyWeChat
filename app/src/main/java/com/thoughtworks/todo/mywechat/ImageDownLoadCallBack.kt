package com.thoughtworks.todo.mywechat

import android.graphics.Bitmap
import java.io.File


interface ImageDownLoadCallBack {
    fun onDownLoadSuccess(file: File?)
    fun onDownLoadSuccess(bitmap: Bitmap?)
    fun onDownLoadFailed()
}