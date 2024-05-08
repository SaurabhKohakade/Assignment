package com.example.assignment6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var lineGraphView: LineGraphView
    private lateinit var txtTotal : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotal=findViewById(R.id.txtTotal)

        lineGraphView = findViewById(R.id.lineGraphView)
        lineGraphView.runs = intArrayOf(12,5,17,10,5,20,3,36)
        var sum : Int = 0
        for(values in lineGraphView.runs){
           sum = sum + values
        }

        var str : String = sum.toString()

        txtTotal.setText("Total Runs Scored In Four Overs : "+str)

       // val runs = intArrayOf(10, 20, 15, 30)
      //  val lineGraphView = findViewById<LineGraphView>(R.id.lineGraphView)
      //  lineGraphView.setRuns(runs)


    }
}