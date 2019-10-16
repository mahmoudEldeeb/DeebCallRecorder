package com.g2m.deebcallrecorder.views.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.g2m.deebcallrecorder.R
import com.g2m.deebcallrecorder.models.dataModels.AudioModel
import com.g2m.deebcallrecorder.views.activities.PlayerActivity
import kotlinx.android.synthetic.main.item_call_record.view.*

class InboxAdapter : RecyclerView.Adapter<InboxAdapter.viewholder> (){

    object  Global{
        var context: Context? =null
        val list:MutableList<AudioModel> = ArrayList()


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item_call_record,parent,false);
        Global.context=parent.context
        return viewholder(v)

    }

    override fun getItemCount(): Int {
return Global.list.size
    }
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.itemView.item_call_record_txt_namecontact.text=Global.list.get(position).name

    }

    fun addall(it: MutableList<AudioModel>?) {
        Global.list.addAll(it!!)
        notifyDataSetChanged()
    }


    class viewholder (itemView: View): RecyclerView.ViewHolder(itemView) ,View.OnClickListener{
        override fun onClick(p0: View?) {
            Log.v("aaaa","ddddddddddddddddd")
            var intent=Intent(Global.context, PlayerActivity::class.java)
            intent.putExtra("record",Global.list[adapterPosition])
           Global.context?.startActivity(intent)
            Log.v("aaaa","ddddddddddddddddd")

        }

        init {
            itemView.setOnClickListener(this)
        }
}
}