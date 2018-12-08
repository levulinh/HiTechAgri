package com.hellosg.studio.hitechagri.activities

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.adapters.GateAdapter
import com.hellosg.studio.hitechagri.fragments.AddGateBottomSheet
import com.hellosg.studio.hitechagri.models.GateWay
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), AddGateBottomSheet.OnAddClickListener {
    override fun onAddClick(name: String, id: String) {
        Toast.makeText(this, "$name / $id", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setSupportActionBar(bottom_app_bar)
        val toolbar = supportActionBar
        toolbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }

        val gateList = arrayListOf<GateWay>()
        gateList.add(GateWay("Some long long name", "G001"))
        gateList.add(GateWay("Short name", "G001"))
        gateList.add(GateWay("Random name", "G001"))
        gateList.add(GateWay("Random name", "G001"))
        gateList.add(GateWay("Random name", "G001"))
        gateList.add(GateWay("Random name", "G001"))
        gateList.add(GateWay("Random name", "G001"))
        gateList.add(GateWay("Random name", "G001"))

        val adapter = GateAdapter(gateList, { gateWay ->
            Toast.makeText(
                this@DashboardActivity,
                "Clicked",
                Toast.LENGTH_SHORT
            ).show()
        },
            { gateWay ->
                Toast.makeText(
                    this@DashboardActivity,
                    "Edit",
                    Toast.LENGTH_SHORT
                ).show()
            },
            { gateWay ->
                Toast.makeText(
                    this@DashboardActivity,
                    "Delete",
                    Toast.LENGTH_SHORT
                ).show()
            })

        rv_list_device.apply {
            setAdapter(adapter)
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@DashboardActivity, RecyclerView.VERTICAL, false)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rv_list_device.setOnScrollChangeListener { _, _, _, _, _ ->
                header.isSelected = rv_list_device.canScrollVertically(-1)
            }
        }

        fab_add.setOnClickListener {
            val addBottomSheet = AddGateBottomSheet()
            addBottomSheet.show(supportFragmentManager, addBottomSheet.tag)
        }
    }
}
