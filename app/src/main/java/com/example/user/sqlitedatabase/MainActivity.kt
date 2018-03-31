package com.example.user.sqlitedatabase

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.io.OutputStreamWriter
import java.io.StringWriter
import java.io.Writer


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

            /*val company : Company = ReadJSONExample . readCompanyJSONFile (this);

            outputText!!.setText(company.toString());*/
           // var output : Writer = OutputStreamWriter(openFileOutput("res/raw/company.json", Context.MODE_PRIVATE))
            var output : StringWriter = StringWriter()
            var outputStreamWriter : OutputStreamWriter = OutputStreamWriter(openFileOutput("company.json", Context.MODE_PRIVATE))
            var company : Company = JsonWriterExample.createCompany()
            JsonWriterExample.writeJsonStream(output, company);
            var jsonText : String  = output.toString();
            outputStreamWriter.write(jsonText)
            outputStreamWriter.close()
            outputText!!.setText(jsonText)
        } catch (e : Exception) {
            outputText!!.setText(e.message)
            e.printStackTrace()
        }
    }

}
