package com.example.firstkotlinapp.Fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinapp.R
import com.example.firstkotlinapp.data.User
import kotlinx.android.synthetic.main.item_user.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    //step 1 - create a list called users
    private var userList = emptyList<User>()

    //step 2 - count how many items are there in the list
    override fun getItemCount(): Int {
        return  userList.size
    }


    //step 3 - empty view holder class - it defines the link between the recyclerview and the itemview
    //recycler view
    //item view
    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    //inside the recycler view place this item view.
    //specifying which item view will go here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false))
    }

    //it defines which data will go into the individual views inside the itemview
    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        //checks all the ids in the list
       val  currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstname_txt.text = currentItem.firstName
        holder.itemView.last_name_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.password.toString()

        //list of users - userlist
        // 1 fatma ali 23
        //2 name  last name  21
        //3 joram  lname 18
    }
    //
    fun setData(user: List<User>){
        //the user list we created put inside it our user class
        //user table
        this.userList = user
        //update the recyclerview
        //refresh the recyclerview whenever there is new data
        notifyDataSetChanged()
    }
}