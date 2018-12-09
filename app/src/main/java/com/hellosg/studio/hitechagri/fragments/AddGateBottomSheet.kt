package com.hellosg.studio.hitechagri.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hellosg.studio.hitechagri.R

class AddGateBottomSheet : BottomSheetDialogFragment() {
    private var activityCallback: OnAddClickListener? = null

    interface OnAddClickListener {
        fun onAddClick(name: String, id: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_add_gate, container, false)

        val edtGateName = view.findViewById<EditText>(R.id.edt_gate_name)
        val edtGateId = view.findViewById<EditText>(R.id.edt_gate_id)
        val btnAdd = view.findViewById<Button>(R.id.btn_add)

        btnAdd.setOnClickListener {
            activityCallback?.onAddClick(edtGateName.text.toString(), edtGateId.text.toString())
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as OnAddClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement OnClickListener")
        }
    }
}