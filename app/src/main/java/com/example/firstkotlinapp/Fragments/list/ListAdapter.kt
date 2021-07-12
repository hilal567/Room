package com.example.firstkotlinapp.Fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinapp.R
import com.example.firstkotlinapp.data.User
import kotlinx.android.synthetic.main.item_user.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var userList = emptyList<User>()

    
    override fun getItemCount(): Int {
        return  userList.size
    }

    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false))
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
       val  currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstname_txt.text = currentItem.firstName
        holder.itemView.last_name_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.age.toString()
    }
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}