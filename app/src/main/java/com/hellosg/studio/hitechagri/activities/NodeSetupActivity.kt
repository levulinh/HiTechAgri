package com.hellosg.studio.hitechagri.activities

import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import com.hellosg.studio.hitechagri.R
import kotlinx.android.synthetic.main.activity_node_setup.*

class NodeSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_setup)

        topToolbar.apply {
            setTitle("Cài đặt node abc")
            setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        }
    }

}
