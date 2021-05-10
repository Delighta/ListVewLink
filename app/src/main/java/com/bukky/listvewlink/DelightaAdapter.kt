package com.bukky.listvewlink

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf

class DelightaAdapter(
    context: Context,
    layout: Int,
    people: List<DelightaFact>
) : ArrayAdapter<DelightaFact>(context, layout, people) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (convertView == null) {
            /**
             * The "parent?.context" is called an elvis operator. It is used for null checks
             **/
            listItem = LayoutInflater.from(parent?.context)
                .inflate(R.layout.delighta_item, parent, false)
        }

        listItem?.let {
            it.findViewById<TextView>(R.id.delighta_item_name).text = getItem(position)?.name
            it.findViewById<TextView>(R.id.delighta_item_desc).text = getItem(position)?.details
            it.findViewById<ImageView>(R.id.delighta_item_pic)
                .setBackgroundResource(getItem(position)?.logo!!)
        }
        /**
         * This is called a null assertion. This indicates that we will under no circumstance get a null value here.
         * This will cause a NullPointerException if listItem is null.
         **/
        return listItem!!
    }


}


