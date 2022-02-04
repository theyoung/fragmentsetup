package com.example.fragmentsetup

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.example.fragmentsetup.data.DataViewModel

class ListViewAdapter(val context : Context, var list: DataViewModel) : BaseAdapter() {

    val layoutInflater : LayoutInflater = LayoutInflater.from(context)

    private fun deleteAt(idx: Int){
        list.removeDataAt(idx)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(idx : Int): String {
        return list.getMessagesAt(idx)
    }

    override fun getItemId(idx: Int): Long {
        return idx.toLong()
    }

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View? {
        var view : View?

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.element_single,container,false)
        } else {
            view = convertView
        }

        view?.findViewById<TextView>(R.id.text_string)?.text = list.getMessagesAt(position)



        view?.setOnClickListener() {
            val str = it.findViewById<TextView>(R.id.text_string).text.toString()
            Toast.makeText(context, "clicked " + str, Toast.LENGTH_SHORT).show()
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(str)
            it.findNavController().navigate(action)
            true
        }

//        val lamda : (v:View)-> Unit = {
//            Toast.makeText(context, "elements deleted", Toast.LENGTH_SHORT).show()
//            deleteAt(position)
//            true
//        }
//        view?.setOnLongClickListener(lamda)

        view?.setOnLongClickListener() {
            Toast.makeText(context, "long clicked" + position, Toast.LENGTH_SHORT).show()
            deleteAt(position)
            true
        }





        return view;
    }

}

