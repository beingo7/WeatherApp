package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {  //appcompatactivity bhanney class baata props ra methods inherit gariyeko chha into mainactivity cclass

    private val forecastRepository= forecastRepository()  //repository laai call gryo..now we can access whatever we've in repository form activity

    // region Setup Methods
    override fun onCreate(savedInstanceState: Bundle?) {   //oncreate is an activity life cycle method ..yo ni parent class kai ho o override gariyeko chha
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //R=resources(generated class) layout=layout resource activity_main:res(layout) folder maa xa ..so tyo syntax use bhako R.layout.activity_main......if laout ko thaau maa string yaa color bhako bhayesi we'd use R.color.----   ya R.string.----

    val zipcodeEditText:EditText=findViewById(R.id.zipcodeEditText) //what findview does is -it references to the Edittext viewlayout that we created in our xml file.
    val button:Button=findViewById(R.id.button )

        //this click on listener is a function(specifically a lambda):where we define what happens when we click the button for this case
     /*   button.setOnClickListener {
        Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show() //makeText is a fn that rwquires 3 args...Context:is speecial obj that knows present config of our app(this refers to enclosing class of our main activity)...2.string/some text...3.duration:

        }*/

        button.setOnClickListener {
            val zipcode:String=zipcodeEditText.text.toString()   //grab the text written into edittext and convert into string

            if (zipcode.length!=5){
                Toast.makeText(this,R.string.zipcodeEntryError,Toast.LENGTH_SHORT).show()

            }
            else{
                forecastRepository.loadForecast(zipcode)   //it loads the data from repository to our main activity..we called load forecast and so our repository updates live dta to mainactivity
            }


        }


        val forecastList:RecyclerView=findViewById(R.id.forecastList)
        forecastList.layoutManager=LinearLayoutManager(this)

        val dailyForecastAdapter=dailyForecastAdapter(){
            val msg=getString(R.string.forecast_clicked_format,it.temp,it.description)
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        }
        forecastList.adapter=dailyForecastAdapter

        //observer to see what data updates are being made in repository
    val weeklyForecastObserver= Observer<List<dailyForecast>> { forecastItems ->
        //update our list adapter
        dailyForecastAdapter.submitList(forecastItems)

    }
    forecastRepository.weeklyForecast.observe(this,weeklyForecastObserver ) //weeklyforecastobserver is a life cycle observer..and anything that changes in the repository will be observed by it
        }









    }


