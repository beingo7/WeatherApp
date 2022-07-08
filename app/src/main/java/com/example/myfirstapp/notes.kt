package com.example.myfirstapp

/*
*week 3: Recycler View
*
* data class(dailyForecast)...to hold data
*
* inside repository:    live data   observer    map function    toast   set values
* Repository class(forecastRepository)...1.to load data from internet or database   2. to paas that data to our activity
* for  2nd purpose:
* live data: --is observable data holder and is lifecycle aware
*          :Working with Live DAta
*           --create an instance(obj) of live data to hold data
*           --create an observer  obj(in UI..i.e. activity)
*           --live data ko obj ra observer ko obj laai connect/attach garney(using observe()    (in activity)
*               -jab live data ko obj le held gareko data haru maa kei changes aauxa...
*               it checks life cycle of activity..agar active state maa chha bhanesi
*               UI maa bhako observer laai nii data chyanges ko baarema update grdinxa
*
*
* for 1st purpose:to load data
*       -create a fn to load data using zipcode of that area(country)
*
*
*
* for Recycler view:
*   --View holders
*   --adapters
*
* --view holders
*       --just an obj which  stores our obj
*       --oncreateviewholder
*           --creates view holder to hold views
*       --onbindviwholder
*           --position ke according hmro data bind grxa view maa.
*
* --adapters
*       --to convert a form of data into another view
*       --hmle deko data laai recycler view laai dinxa
*
*
* -- In recycler view, viewholder ko duita elements(oncreate/onbind) le viewholder banaux ra view maa data bind grxa...
*    and then that data is provided to recycler view by adapter.
*
* euta view banaaiyo in xml file..which contains 2 text views(temp and description)
*
* tyo text views haru ko reference adapter class maa haalyo
* now we've acess to views..aba bind fn le temp ra desc(forecast items) laai tyo view sanga bind grxa.
*
* oncreateviewholder fn maa view holder banaauxau..using inflater
*
* onbind view holder le view holder maa data haaldixa
*
*
*
*
*
*
*
*
*
*
* STEPS:
* -data class
* -repository:live data to transfer data...loadfn to load the data from net/database
* -recycler view:
* -adapters+viewholders
* -view layout banaaau....paas ythat view to view holder
*
*
*
*
* */