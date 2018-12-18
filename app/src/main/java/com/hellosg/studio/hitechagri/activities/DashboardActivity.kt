package com.hellosg.studio.hitechagri.activities

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellosg.studio.hitechagri.adapters.GateAdapter
import com.hellosg.studio.hitechagri.fragments.AddGateBottomSheet
import com.hellosg.studio.hitechagri.fragments.DeleteGateBottomSheet
import com.hellosg.studio.hitechagri.fragments.EditGateBottomSheet
import com.hellosg.studio.hitechagri.models.GateWay
import com.hellosg.studio.hitechagri.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class DashboardActivity : AppCompatActivity(),
    AddGateBottomSheet.OnAddClickListener,
    EditGateBottomSheet.OnEditClickListener,
    DeleteGateBottomSheet.OnDeleteClickListener {

    private lateinit var addBottomSheet: AddGateBottomSheet
    private lateinit var editBottomSheet: EditGateBottomSheet
    private lateinit var deleteBottomSheet: DeleteGateBottomSheet

    override fun onAddClick(name: String, id: String) {
        Toast.makeText(this, "$name / $id", Toast.LENGTH_SHORT).show()
        addBottomSheet.dismiss()
    }

    override fun onEditClick(gate: GateWay) {
        editBottomSheet.dismiss()
    }

    override fun onDeleteClick(gate: GateWay) {
        deleteBottomSheet.dismiss()
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

        val adapter = GateAdapter(gateList,
            { gateWay ->
                startActivity(intentFor<GateMonitoringActivity>())
            },
            { gateWay ->
                editBottomSheet = EditGateBottomSheet.newInstance(gateWay)
                editBottomSheet.show(supportFragmentManager, editBottomSheet.tag)
            },
            { gateWay ->
                deleteBottomSheet = DeleteGateBottomSheet.newInstance(gateWay)
                deleteBottomSheet.show(supportFragmentManager, deleteBottomSheet.tag)
            })

        rv_list_node.apply {
            setAdapter(adapter)
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@DashboardActivity,
                RecyclerView.VERTICAL,
                false)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rv_list_node.setOnScrollChangeListener { _, _, _, _, _ ->
                header.isSelected = rv_list_node.canScrollVertically(-1)
            }
        }

        fab_add.setOnClickListener {
            addBottomSheet = AddGateBottomSheet()
            addBottomSheet.show(supportFragmentManager, addBottomSheet.tag)
        }

        topToolbar.inflateMenu(R.menu.menu_dashboard)
        topToolbar.title = "Tổng quan"
        topToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.test_setup_action -> {
                    startActivity(intentFor<NodeSetupActivity>())
                }

                R.id.test_chart_action -> {
                    startActivity(intentFor<ChartActivity>())
                }
            }
            true
        }

    }

}
