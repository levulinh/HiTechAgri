package com.hellosg.studio.hitechagri.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.hellosg.studio.hitechagri.R
import kotlinx.android.synthetic.main.activity_chart.*
import kotlin.random.Random

class ChartActivity : AppCompatActivity() {

    var entries = mutableListOf<Entry>()
    lateinit var dataSet: LineDataSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        fakeData()
        dataSet = LineDataSet(entries, "Nhiệt độ")
            .also {
                it.apply {
                    color = Color.RED
                    circleColors = listOf(Color.RED)
                    setDrawFilled(true)
                    fillColor = Color.parseColor("#ffc9c7")
                    valueTextColor = Color.parseColor("#000000")
                }

                line_chart.data = LineData(it)
            }

        line_chart.axisLeft.apply {
            axisMinimum = 0f
            setDrawGridLines(false)
        }

        line_chart.axisRight.apply {
            setDrawGridLines(false)
        }

        line_chart.xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            setDrawGridLines(false)
        }

        line_chart.axisRight.isEnabled = false

        line_chart.apply {
            isDragEnabled = true
            val mDescription = Description()
            mDescription.text = "Sensor Nhiệt độ"
            description = mDescription
            isScaleYEnabled = false
            isScaleXEnabled = true
            setVisibleXRangeMaximum(12f)
            animateX(1000, Easing.Linear)
            moveViewToX(100f)
        }

        line_chart.legend.apply {
            isEnabled = true

        }
        line_chart.invalidate()

    }

    private fun fakeData() {
        entries.add(Entry(1f, 20 + Random.nextInt(0, 100) / 10f))
        entries.add(Entry(2f, 20 + Random.nextInt(0, 100) / 10f))
        entries.add(Entry(3f, 20 + Random.nextInt(0, 100) / 10f))
    }
}
