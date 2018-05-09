package kuku.chickenmanagement.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kuku.chickenmanagement.R
import kuku.chickenmanagement.model.KukuModel

/**
 * Created by Fredy on 05/05/2018.
 */
class kukuAdapter(private var list: ArrayList<KukuModel>, private var context: Context)
        : RecyclerView.Adapter<kukuAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, Position: Int): ViewHolder {

        //create a view from xml
        val view = LayoutInflater.from(context).inflate(R.layout.list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.bindItem(list[position])
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(kukuModel: KukuModel){

            var ListTittleID: TextView = itemView.findViewById(R.id.ListTittleID) as TextView
            var ListContentID: TextView = itemView.findViewById(R.id.ListContentID) as TextView
            var ListPic: ImageView = itemView.findViewById(R.id.ListPicID) as ImageView

            ListTittleID.text = kukuModel.Title
            ListContentID.text = kukuModel.Content
        }
    }
}