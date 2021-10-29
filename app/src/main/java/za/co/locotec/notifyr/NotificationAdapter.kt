package za.co.locotec.notifyr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NotificationAdapter(private val context: Context,
                          private val dataSource: ArrayList<NotificationData>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_notification, parent, false)
        val appTextView = rowView.findViewById(R.id.item_app) as TextView
        val titleTextView = rowView.findViewById(R.id.item_title) as TextView
        val detailTextView = rowView.findViewById(R.id.item_detail) as TextView
        val notificationData = getItem(position) as NotificationData

        titleTextView.text = notificationData.title
        appTextView.text = notificationData.app
        detailTextView.text = notificationData.detail

        return rowView
    }

}