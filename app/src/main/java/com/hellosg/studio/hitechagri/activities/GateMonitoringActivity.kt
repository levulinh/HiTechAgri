package com.hellosg.studio.hitechagri.activities

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.adapters.NodeAdapter
import com.hellosg.studio.hitechagri.fragments.AddNodeBottomSheet
import com.hellosg.studio.hitechagri.fragments.DeleteNodeBottomSheet
import com.hellosg.studio.hitechagri.fragments.EditGateBottomSheet
import com.hellosg.studio.hitechagri.fragments.EditNodeBottomSheet
import com.hellosg.studio.hitechagri.models.Node
import kotlinx.android.synthetic.main.activity_gate_monitoring.*

class GateMonitoringActivity : AppCompatActivity(),
    EditNodeBottomSheet.OnEditClickListener,
    DeleteNodeBottomSheet.OnDeleteClickListener,
    AddNodeBottomSheet.OnAddClickListener {
    override fun onEditClick(node: Node) {
        editBottomSheet.dismiss()
    }

    override fun onDeleteClick(node: Node) {
        deleteBottomSheet.dismiss()

    }

    override fun onAddClick(name: String, id: String) {
        Toast.makeText(this, "$name / $id", Toast.LENGTH_SHORT).show()
        addBottomSheet.dismiss()
    }


    private lateinit var addBottomSheet: AddNodeBottomSheet
    private lateinit var editBottomSheet: EditNodeBottomSheet
    private lateinit var deleteBottomSheet: DeleteNodeBottomSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gate_monitoring)

        setSupportActionBar(bottom_app_bar)
        val toolbar = supportActionBar
        toolbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rv_list_node.setOnScrollChangeListener { _, _, _, _, _ ->
                header.isSelected = rv_list_node.canScrollVertically(-1)
            }
        }

        val nodeList = arrayListOf<Node>()
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))
        nodeList.add(Node("Node 1", "E-001-F:0", 30f, 75f, 5f, 250f))

        val adapter = NodeAdapter(nodeList, {
            editBottomSheet = EditNodeBottomSheet.newInstance(it)
            editBottomSheet.show(supportFragmentManager, editBottomSheet.tag)
        }, {
            deleteBottomSheet = DeleteNodeBottomSheet.newInstance(it)
            deleteBottomSheet.show(supportFragmentManager, deleteBottomSheet.tag)
        }, {

        })

        rv_list_node.apply {
            setAdapter(adapter)
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@GateMonitoringActivity, RecyclerView.VERTICAL, false)
        }

        fab_add.setOnClickListener {
            addBottomSheet = AddNodeBottomSheet()
            addBottomSheet.show(supportFragmentManager, addBottomSheet.tag)
        }

        topToolbar.inflateMenu(R.menu.menu_dashboard)
        topToolbar.title = "Random Name"
        topToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
    }
}
