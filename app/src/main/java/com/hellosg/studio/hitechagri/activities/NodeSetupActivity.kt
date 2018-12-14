package com.hellosg.studio.hitechagri.activities

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hellosg.studio.hitechagri.R
import com.hellosg.studio.hitechagri.databinding.ActivityNodeSetupBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE

class NodeSetupActivity : AppCompatActivity() {

    data class NodeSetting(
        var title: String = "Cài đặt cho node",
        var sensorType: Int = 0,
        var profileType: Int = 0,
        var time: String = "--:--"
    )

    private lateinit var binding: ActivityNodeSetupBinding
    private lateinit var nodeSetting: NodeSetting
    private val hourMinuteFormat = SimpleDateFormat("hh:mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_node_setup)

        nodeSetting = NodeSetting("Cài đặt cho node test")
        nodeSetting.time = hourMinuteFormat.format(Calendar.getInstance().time)

        binding.nodeSetting = nodeSetting

        binding.topToolbar.apply {
            title = nodeSetting.title
            setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
            setNavigationOnClickListener { onBackPressed() }
        }

        val sensorList = listOf("Nhiệt độ", "Độ ẩm không khí", "Độ ẩm đất", "Ánh sáng")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, sensorList).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.selectSensorSpinner.adapter = adapter
        }

        binding.selectedTimeText.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val mHour = currentTime.get(HOUR_OF_DAY)
            val mMinute = currentTime.get(MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                nodeSetting.time = "$hourOfDay:$minute"
                binding.invalidateAll()
            }, mHour, mMinute, true).show()
        }
    }

}
