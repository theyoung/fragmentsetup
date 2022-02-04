package com.example.fragmentsetup.data

import androidx.lifecycle.ViewModel

public class DataViewModel : ViewModel() {

    val lists : MutableList<String> = ArrayList<String>()
    val size get() = lists.size

    public fun addMessage(message:String){
        lists.add(message)
    }

    public fun getMessages() : List<String>{
        return lists.toList()
    }

    public fun getMessagesAt(idx : Int) : String{
        return lists.get(idx)
    }

    public fun removeDataAt(index:Int){
        lists.removeAt(index)
    }
}