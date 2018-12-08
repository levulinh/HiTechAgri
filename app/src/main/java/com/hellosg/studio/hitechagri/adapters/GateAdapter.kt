package com.hellosg.studio.hitechagri.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.models.GateWay

class GateAdapter(var mGateList: ArrayList<GateWay> = arrayListOf(),
                  var mListener: (GateWay) -> Unit,
                  var mEditListener: (GateWay) -> Unit,
                  var mDeleteListener: (GateWay) -> Unit
) : RecyclerView.Adapter<GateAdapter.GateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GateViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gate_way, parent, false)
        return GateViewHolder(itemView, mListener, mEditListener, mDeleteListener)
    }

    override fun getItemCount(): Int {
        return mGateList.size
    }

    override fun onBindViewHolder(holder: GateViewHolder, position: Int) {
        val gate = mGateList[position]
        holder.txtGateName.text = gate.name
        holder.txtGateId.text = gate.gateId
        holder.layoutParent.setOnClickListener { holder.listener(gate) }
        holder.btnEdit.setOnClickListener { holder.editListener(gate) }
        holder.btnDelete.setOnClickListener { holder.deleteListener(gate) }
    }

    inner class GateViewHolder(itemView: View,
                               val listener: (GateWay) -> Unit,
                               val editListener: (GateWay) -> Unit,
                               val deleteListener: (GateWay) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        var txtGateName = itemView.findViewById<TextView>(R.id.txt_gate_name)
        var txtGateId   = itemView.findViewById<TextView>(R.id.txt_gate_id)
        var layoutParent = itemView.findViewById<FrameLayout>(R.id.layout_parent)
        var btnEdit = itemView.findViewById<ImageView>(R.id.btn_edit)
        var btnDelete = itemView.findViewById<ImageView>(R.id.btn_delete)
    }
}