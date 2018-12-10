package com.hellosg.studio.hitechagri.fragments

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.models.Node

class DeleteNodeBottomSheet : BottomSheetDialogFragment() {

    private var activityCallback: OnDeleteClickListener? = null

    interface OnDeleteClickListener {
        fun onDeleteClick(node: Node)
    }

    companion object {
        fun newInstance(node: Node): DeleteNodeBottomSheet {
            val args = Bundle()
            args.putString("name", node.name)
            args.putString("id", node.nodeId)
            val fragment = DeleteNodeBottomSheet()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_delete_node, container, false)

        val txtWarningMessage = view.findViewById<TextView>(R.id.txt_warning_message)
        val btnDelete = view.findViewById<Button>(R.id.btn_delete)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtWarningMessage.text =
                    Html.fromHtml("Bạn đang chuẩn bị xóa <span style=\"color: red\">${arguments?.getString("name", "null")}</span>, hành động này không thể quay lại, bạn có chắc chắn?", Html.FROM_HTML_MODE_COMPACT)
        } else {
            txtWarningMessage.text =
                    Html.fromHtml("Bạn đang chuẩn bị xóa <span style=\"color: red\">${arguments?.getString("name", "null")}</span>, hành động này không thể quay lại, bạn có chắc chắn?")
        }

        btnDelete.setOnClickListener {
            activityCallback
                ?.onDeleteClick(Node(arguments?.getString("name")!!, arguments?.getString("id")!!))
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as OnDeleteClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context?.toString()
                        + " must implement OnClickListener"
            )
        }
    }
}