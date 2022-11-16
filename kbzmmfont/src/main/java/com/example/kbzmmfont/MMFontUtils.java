/*
 * Copyright 2014 Myanmar Android User Group(MMAUG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kbzmmfont;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;

import com.example.kbzmmfont.materialtext.MaterialAutoCompleteTextView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MMFontUtils {

    private Context mContext;

    public MMFontUtils(Context context) {
        this.mContext = context;
    }


    public void setTypeFaceTextview(String font, TextView... textViews) {
        for (TextView t : textViews) {
            if (MMBindFontUtils.isSupportUnicode()) {
                t.setTypeface(KbzMMFontCache.get(font, mContext));
            }
        }
    }

    public void setTypeButton(String fontName, Button... buttons) {
        for (Button b : buttons) {
            if (MMBindFontUtils.isSupportUnicode()) {
               b.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceTextInputLayout(String fontName, TextInputLayout... txtInputLayout) {
        for (TextInputLayout txtInLay : txtInputLayout) {
            if (MMBindFontUtils.isSupportUnicode()) {
                txtInLay.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }

        }
    }

    public void setTypeFaceTextInputEditText(String fontName, TextInputEditText... textInputEdit) {
        for (TextInputEditText txtInEdit : textInputEdit) {
            if (MMBindFontUtils.isSupportUnicode()) {
                txtInEdit.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceSpinner(String fontName, MaterialAutoCompleteTextView... materialBetterSpinners) {
        for (MaterialAutoCompleteTextView mAComTextview : materialBetterSpinners) {
            if (MMBindFontUtils.isSupportUnicode()) {
              //  mAComTextview.setTypeface(KbzMMFontCache.get(fontName, mContext));
                mAComTextview.setAccentTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceRadioButton(String fontName, RadioButton... radioButtons) {
        for (RadioButton radioButton : radioButtons) {
            if (MMBindFontUtils.isSupportUnicode()) {
                radioButton.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceSegmentRadioButton(String fontName, AppCompatRadioButton... radioButtons) {
        for (AppCompatRadioButton radioButton : radioButtons) {
            if (MMBindFontUtils.isSupportUnicode()) {
                radioButton.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceCheckBox(String fontName, AppCompatCheckBox... checkBoxes) {
        for (AppCompatCheckBox appCompatCheckBox : checkBoxes) {
            appCompatCheckBox.setTypeface(KbzMMFontCache.get(fontName, mContext));
        }
    }

    public SpannableString setTypeFaceSpanStrMsg(String fontName, String errorMessage) {
        SpannableString sp = new SpannableString(errorMessage);
        if (MMBindFontUtils.isSupportUnicode()) {
            sp.setSpan(new KbzMMFontSpan(KbzMMFontCache.get(fontName, mContext)), 0, sp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return sp;
    }

    public void setTypeFaceSearchEditText(String fontName, AppCompatEditText... searchEditText) {
        for (AppCompatEditText searchEdt : searchEditText) {
            if (MMBindFontUtils.isSupportUnicode()) {
                searchEdt.setTypeface(KbzMMFontCache.get(fontName, mContext));
            }
        }
    }

    public void setTypeFaceTabLayout(String fontName, TabLayout... tabLayout) {
        for (TabLayout tbl : tabLayout) {
            ViewGroup vg = (ViewGroup) tbl.getChildAt(0);
            int tabsCount = vg.getChildCount();
            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        if (MMBindFontUtils.isSupportUnicode()) {
                            ((TextView) tabViewChild).setTypeface(KbzMMFontCache.get(fontName, mContext));
                        }else {
                            ((TextView) tabViewChild).setText(MMBindFontUtils.mmText(((TextView) tabViewChild).getText().toString(), MMBindFontUtils.TEXT_UNICODE));
                        }
                    }
                }
            }
        }
    }
}
