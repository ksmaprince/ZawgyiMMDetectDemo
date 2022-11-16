@file:Suppress("unused")

package com.kbz.mmlibs

import android.content.Context
import com.google.myanmartools.TransliterateU2Z
import com.google.myanmartools.TransliterateZ2U
import com.google.myanmartools.ZawgyiDetector

//change unicode into device encoding
fun String.encodeText(): String {
   val z2U = TransliterateZ2U("Zawgyi to Unicode")
    val u2Z = TransliterateU2Z("Unicode to Zawgyi")
    val zSystem = Detector.detectedZawgyi()
    val zEncode = this.isZawgyi()

    if(zSystem.not() && zEncode) return z2U.convert(this)
    if(zSystem && zEncode.not()) return u2Z.convert(this)
    return this
}

fun String.isZawgyi(): Boolean {
    val score =  ZawgyiDetector().getZawgyiProbability(this)
    return score > 0.8
}

object MMLibs {
    fun initialize(context: Context) {
        Detector.initialize(context)
    }
}