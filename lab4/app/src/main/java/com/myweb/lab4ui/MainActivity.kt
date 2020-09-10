package com.myweb.lab4ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var subject : String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subjectSpinner : Spinner = spiner_subject;
        val subjectArray = resources.getStringArray(R.array.subjectName_array)

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner.adapter = arrayAdapter

        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id:Long){
                subject = subjectArray[position]
            }
            override fun onNothingSelected(parent : AdapterView<*>){

            }
        }
//        fun showTimePickerDialog(v:View){
//            val newTimePickerFragment = TimePickerFragment()
//            newTimePickerFragment.show(supportFragmentManager,"Time Picker")
//        }

    }
    fun showDatePickerDialog(v:View) {
        val newDatePickerFragment = DatePickerFragment()
        newDatePickerFragment.show(supportFragmentManager, "Date Picker")
    }
    fun showDetail(view:View){
//            var radioGroup:RadioGroup = findViewById(R.id.radioGroup)
        var selectedId : Int = radio.checkedRadioButtonId;
        var radioButton : RadioButton = findViewById(selectedId);
        text_show.text = "Username: ${edit_name.text}\nPassword:${edit_pass.text}\nGender: ${radioButton.text}\nEmail: ${edit_email.text}\nBirthday: ${text_date.text}"

    }
    fun reset(v:View){
        edit_name.text.clear()
        edit_pass.text.clear()
        edit_email.text.clear()
        spiner_subject.setSelection(0)
        text_date.text="mm/dd/yy"
        text_show.text = "Show detail"
    }
}