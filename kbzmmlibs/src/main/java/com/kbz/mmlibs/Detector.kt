package com.kbz.mmlibs

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

object Detector {
    private const val TAG = "Detector"
    var codeType: CodeType = CodeType.UNICODE
        private set

    @SuppressLint("SetTextI18n")
    fun initialize(context: Context) {
        Log.i(TAG, "Detector is initialized.")

        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        val textView = TextView(context)
        textView.apply {
            layoutParams = ViewGroup.LayoutParams(wrapContent, wrapContent)

            text = "\u1000"
            measure(wrapContent, wrapContent)
            val length1 = measuredWidth

            text = "\u1000\u1039\u1000"
            measure(wrapContent, wrapContent)
            val length2 = measuredWidth

            if(length1 != length2) codeType = CodeType.ZAWGYI
        }
    }

    fun detectedZawgyi(): Boolean {
        return codeType == CodeType.ZAWGYI
    }

    fun detectedUnicode(): Boolean {
        return codeType == CodeType.UNICODE
    }

    //will implement later
    private fun detectString(string: String) : CodeType {
        return CodeType.UNICODE
    }
}