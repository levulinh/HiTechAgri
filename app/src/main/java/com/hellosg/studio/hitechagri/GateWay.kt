package com.hellosg.studio.hitechagri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gate_way.*

class GateWay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gate_way)

        tab.addTab(tab.newTab().setText("Giám sát").setIcon(R.drawable.ic_insert_chart_black_36dp))
        tab.addTab(tab.newTab().setText("Điều khiển").setIcon(R.drawable.ic_settings_remote_black_36dp))

        val toolbar = supportActionBar
        toolbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }
    }
}
