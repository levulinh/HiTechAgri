package com.hellosg.studio.hitechagri.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.models.Node

class NodeAdapter(var mNodeList: ArrayList<Node>,
                  var mEditListener: (Node) -> Unit,
                  var mDeleteListener: (Node) -> Unit,
                  var mReloadListener: (Node) -> Unit)
    : RecyclerView.Adapter<NodeAdapter.MonitorNodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonitorNodeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_monitor_node, parent, false)

        return MonitorNodeViewHolder(view, mEditListener, mDeleteListener, mReloadListener)
    }

    override fun getItemCount(): Int {
        return mNodeList.size
    }

    override fun onBindViewHolder(holder: MonitorNodeViewHolder, position: Int) {
        val node = mNodeList[position]

        holder.txtNodeName.text = node.name
        holder.txtNodeId.text = node.nodeId
        holder.txtTempValue.text = "${node.temp}"
        holder.txtAirHumiValue.text = "${node.airHumi}"
        holder.txtSoilHumiValue.text = "${node.soilHumi}"
        holder.txtLightValue.text = "${node.light}"

        holder.btnEdit.setOnClickListener { holder.editListener(node) }
        holder.btnDelete.setOnClickListener { holder.deleteListener(node) }
        holder.btnReload.setOnClickListener { holder.reloadListener(node) }

    }

    inner class MonitorNodeViewHolder(itemView: View,
                                      val editListener: (Node) -> Unit,
                                      val deleteListener: (Node) -> Unit,
                                      val reloadListener: (Node) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        var txtNodeName = itemView.findViewById<TextView>(R.id.txt_node_name)
        var txtNodeId = itemView.findViewById<TextView>(R.id.txt_node_id)
        var txtTempValue = itemView.findViewById<TextView>(R.id.txt_temp_value)
        var txtAirHumiValue = itemView.findViewById<TextView>(R.id.txt_air_humi_value)
        var txtSoilHumiValue = itemView.findViewById<TextView>(R.id.txt_soil_humi_value)
        var txtLightValue = itemView.findViewById<TextView>(R.id.txt_light_value)

        var btnEdit = itemView.findViewById<ImageView>(R.id.btn_edit)
        var btnDelete = itemView.findViewById<ImageView>(R.id.btn_delete)
        var btnReload = itemView.findViewById<ImageView>(R.id.btn_reload)
    }

}