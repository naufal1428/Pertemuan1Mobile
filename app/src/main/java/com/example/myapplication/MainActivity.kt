package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerprint(){
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("FEATURE", "FEATURE FINGERPRINT ON")
        } else {
            Log.w("FETAURE", "FEATURE FINGGERPRINT OFF")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        //commit 1

        checkFingerprint()

        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener{

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            Log.i("RAW", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("ASSET", json)

            Log.d("MV", "This is debug Log")
            Log.i("MV", "This is info Log")
            Log.w("MV", "This is warn Log")
            Log.e("MV", "This is error Log")

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("MV", it)
            }
        }
    }
}