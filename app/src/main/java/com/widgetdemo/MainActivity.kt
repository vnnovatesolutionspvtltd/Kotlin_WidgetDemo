package com.widgetdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)

        val intent = Intent(this, SampleWidget::class.java)
        intent.action = "ACTIVITY_ACTION"

        //This action will send broadcast to update the widget
        button.setOnClickListener { _ ->
            AppWidgetManager.getInstance(application).getAppWidgetIds(ComponentName(application,SampleWidget::class.java))
            intent.putExtra("name", "Widget updated")
            sendBroadcast(intent)}

    }
}
