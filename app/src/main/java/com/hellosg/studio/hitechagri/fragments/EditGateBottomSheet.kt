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
import com.hellosg.studio.hitechagri.models.GateWay

class EditGateBottomSheet : BottomSheetDialogFragment() {
    private var activityCallback: OnEditClickListener? = null

    interface OnEditClickListener {
        fun onEditClick(gate: GateWay)
    }

    companion object {
        fun newInstance(gate: GateWay): EditGateBottomSheet {
            val args = Bundle()
            args.putString("name", gate.name)
            args.putString("id", gate.gateId)
            val fragment = EditGateBottomSheet()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_edit_gate, container, false)

        val edtName = view.findViewById<EditText>(R.id.edt_gate_name)
        val edtId = view.findViewById<EditText>(R.id.edt_gate_id)
        val btnEdit = view.findViewById<Button>(R.id.btn_edit)

        edtId.setText(arguments?.getString("id"))
        edtName.setText(arguments?.getString("name"))

        btnEdit.setOnClickListener {
            activityCallback
                ?.onEditClick(GateWay(edtName.text.toString(), edtId.text.toString()))
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as OnEditClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement OnClickListener")
        }
    }
}