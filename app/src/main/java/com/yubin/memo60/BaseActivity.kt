package com.yubin.memo60

import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity :AppCompatActivity(), View.OnClickListener, BaseDialog.BaseDialogClickListener {
    override fun onClick(v: View?) {
    }

    override fun onOKClicked() {
    }
}