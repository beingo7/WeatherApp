package com.example.myfirstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class forecastRepository {  //repository does 1.loading data for us 2. providing data to our activity(how?)

    private val _weeklyForecast = MutableLiveData<List<dailyForecast>>()  //daily forecast is a data class..data ko lists chha tesma ..tyo list mutablelivedata(constructor) laai chaa..which is assigned to our private val
    val weeklyForecast:LiveData<List<dailyForecast>> =_weeklyForecast    //livedata will be accessed/referenced to our mainactivity to publish data..but mainactivity cant modify it coz it aint mutable..so only in repository we can modify it
    //line 9,10 -> to update the data to our main activity from repository but repositiory don't have the data as of now.



    //the following lines is to load the data to our repository
    //line 17-20 generates us a set of 7 random temperature values with same description
    fun loadForecast(zipcode:String){
        val randomValues= List(7){ Random.nextFloat().rem(100)*100}  //random.nextfloat will generate us random float numvers for us...rem(100)*100 gives us values betn 0-100
        val forecastItems=randomValues.map { randomtemp->
            dailyForecast(randomtemp,getTempDescription(randomtemp))
        }
        //we provided data to our activity..we loaded data into repository..now we'll update data to our live data obj based on environment
        //here we send this list of 7 diff temp values to our live data
        //line 24 updates the values in _weekly forecast...and weeklyforecast gets the same values but which can't be altered elsewhere
        _weeklyForecast.setValue(forecastItems)

    }

    private fun getTempDescription(randomtemp:Float):String{

        return when(randomtemp){
             in Float.MAX_VALUE..0f->"Anything below 0 doesn't make sense"
            in 0f..32f->"Way too cold"
            in 32f..55f->"Colder than I'd prefer"
            in 55f..65f->"Geting better"
            in 65f..80f->"Sweeeeet"
            in 80f..100f->"warmer"
            in 100f..Float.MAX_VALUE->"Is it Desert?"
            else ->"Doesn't compute"
        }
    }



}
