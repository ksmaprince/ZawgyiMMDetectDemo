package com.example.zawgyimmdetectdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatTextView
import com.kbzbank.mmfont.Fonts
import com.kbzbank.mmfont.MMBindFontUtils
import com.kbzbank.mmfont.MMFontUtils

class MainActivity : AppCompatActivity() {

    private lateinit var tvUnicode: AppCompatTextView
    private lateinit var rbOption1: AppCompatRadioButton
    private lateinit var rbOption2: AppCompatRadioButton
    private lateinit var rbOption3: AppCompatRadioButton
    private lateinit var chkOption1: AppCompatCheckBox
    private lateinit var chkOption2: AppCompatCheckBox
    private lateinit var chkOption3: AppCompatCheckBox
    private lateinit var chkOption4: AppCompatCheckBox
    private lateinit var btnUnicode1: AppCompatButton
    private lateinit var btnUnicode2: AppCompatButton


    private lateinit var mmFontUtils: MMFontUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUnicode = findViewById(R.id.tvUnicode)
        rbOption1 = findViewById(R.id.rbOption1)
        rbOption2 = findViewById(R.id.rbOption2)
        rbOption3 = findViewById(R.id.rbOption3)
        chkOption1 = findViewById(R.id.chkOption1)
        chkOption2 = findViewById(R.id.chkOption2)
        chkOption3 = findViewById(R.id.chkOption3)
        chkOption4 = findViewById(R.id.chkOption4)
        btnUnicode1 = findViewById(R.id.btnUnicode1)
        btnUnicode2 = findViewById(R.id.btnUnicode2)


        mmFontUtils = MMFontUtils(this)
        MMBindFontUtils.checkSupportMMFontType(this)

        if(!MMBindFontUtils.isSupportUnicode()){
            tvUnicode.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(tvUnicode).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)

            rbOption1.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(rbOption1).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            rbOption2.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(rbOption2).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            rbOption3.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(rbOption3).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)

            chkOption1.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(chkOption1).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            chkOption2.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(chkOption2).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            chkOption3.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(chkOption3).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            chkOption4.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(chkOption4).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)

            btnUnicode1.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(btnUnicode1).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
            btnUnicode2.text = MMBindFontUtils.mmText(MMBindFontUtils.getMMText(btnUnicode2).toString(), MMBindFontUtils.ENCODING_ORIGIN_UN)
        }else{
            mmFontUtils.setTypeFaceTextview(Fonts.PYIDAUNGSU, tvUnicode)
            mmFontUtils.setTypeFaceRadioButton(Fonts.PYIDAUNGSU, rbOption1, rbOption2, rbOption3)
            mmFontUtils.setTypeFaceCheckBox(Fonts.PYIDAUNGSU, chkOption1, chkOption2, chkOption3, chkOption4)
            mmFontUtils.setTypeButton(Fonts.PYIDAUNGSU, btnUnicode1, btnUnicode2)
        }
    }
}