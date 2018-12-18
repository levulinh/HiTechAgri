package com.hellosg.studio.hitechagri.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.databinding.BottomSheetUserBinding

class UserBottomSheet : BottomSheetDialogFragment() {

    data class User(var name: String = "", var email: String = "")

    private lateinit var binding: BottomSheetUserBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_user, container, false)

        return binding.root
    }
}