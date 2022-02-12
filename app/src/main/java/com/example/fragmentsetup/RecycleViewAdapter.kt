package com.example.fragmentsetup

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsetup.data.DataViewModel
import android.view.View;
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import java.lang.ref.WeakReference

class RecycleViewAdapter(val context : Context, var list: DataViewModel) : RecyclerView.Adapter<RecycleViewAdapter.Holder>() {

    val layoutInflater : LayoutInflater = LayoutInflater.from(context)

    fun deleteAt(position: Int){
        list.removeDataAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.inflateHolder(parent, layoutInflater)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list.getMessagesAt(position),position,this)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class Holder(val item : View) : RecyclerView.ViewHolder(item) {
        companion object {
            fun inflateHolder(parent: ViewGroup, layoutInflater: LayoutInflater) : Holder {
                val view = layoutInflater.inflate(R.layout.element_single, parent, false)
                return Holder(view)
            }
        }

//        lateinit var weak : RecycleViewAdapter

        fun bind(str: String,position: Int, adapter: RecycleViewAdapter){
//            weak = WeakReference(adapter).get()!!
            val weak = adapter
            item.findViewById<TextView>(R.id.text_string).text = str
            item?.setOnClickListener() {
                val str = it.findViewById<TextView>(R.id.text_string).text.toString()
                Toast.makeText(item.context, "clicked " + str, Toast.LENGTH_SHORT).show()
                val action = RecycleFragmentDirections.actionRecycleFragmentToThirdFragment(str)
                it.findNavController().navigate(action)
                true
            }
            item?.setOnLongClickListener() {
                Toast.makeText(item.context, "long clicked" + position, Toast.LENGTH_SHORT).show()
                weak?.deleteAt(position)
                true
            }
        }

    }
}