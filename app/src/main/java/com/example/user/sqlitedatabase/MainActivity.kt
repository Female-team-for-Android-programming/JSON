package com.example.user.sqlitedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    private var outputText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        outputText = this.findViewById<View>(R.id.editText) as EditText
    }

    public fun runExample(view : View)
    {
        try {

            val company : Company = ReadJSONExample . readCompanyJSONFile (this);

            outputText!!.setText(company.toString());
        } catch (e : Exception) {
            outputText!!.setText(e.message)
            e.printStackTrace()
        }
    }

}
