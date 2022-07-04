package com.example.addfield

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.parentLinearLayout)
        val fieldName = findViewById<EditText>(R.id.fieldNameEditText)
        val addField = findViewById<Button>(R.id.addFieldButton)
        val checkBox = findViewById<CheckBox>(R.id.checkbox)


        addField.setOnClickListener{

            createAndAddView(fieldName.text.toString(), checkBox.isChecked)

            fieldName.text.clear()
        }

    }

    private fun createAndAddView(stringFieldName: String, check: Boolean) {

        val edit = EditText(this)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                     LinearLayout.LayoutParams.WRAP_CONTENT)

        edit.layoutParams = params
        if(check) edit.inputType = InputType.TYPE_CLASS_NUMBER
            else edit.inputType = InputType.TYPE_CLASS_TEXT
        edit.hint = stringFieldName
        edit.textSize = 20F

        linearLayout.addView(edit)

    }
}
