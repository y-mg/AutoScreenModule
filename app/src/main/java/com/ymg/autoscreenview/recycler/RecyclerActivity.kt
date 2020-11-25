package com.ymg.autoscreenview.recycler


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ymg.autoscreenmodule.AutoScreenDestiny
import com.ymg.autoscreenmodule.AutoScreenUtil
import com.ymg.autoscreenview.base.BasicActivity
import com.ymg.autoscreenview.databinding.ActivityRecyclerBinding
import com.ymg.autoscreenview.databinding.ActivityRecyclerItemBinding


class RecyclerActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityRecyclerBinding
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var listItems: MutableList<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        AutoScreenDestiny.setActivityScreen(this)

        recyclerAdapter = RecyclerAdapter()
        viewBinding.recyclerView.adapter = recyclerAdapter

        listItems = mutableListOf()
        listItems.apply {
            add(0, "A")
            add(1, "B")
            add(2, "C")
            add(3, "D")
            add(4, "E")
            add(5, "F")
            add(6, "G")
            add(7, "H")
            add(8, "I")
            add(9, "J")
            add(10, "K")
            add(11, "L")
            add(12, "M")
            add(13, "N")
            add(14, "O")
            add(15, "P")
            add(16, "Q")
            add(17, "R")
            add(18, "S")
            add(19, "T")
            add(20, "U")
            add(21, "V")
            add(22, "W")
            add(23, "X")
            add(24, "Y")
            add(25, "Z")
        }
    }





    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val viewBinding = ActivityRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ViewHolder(viewBinding).apply {
                AutoScreenUtil.auto(this.itemView)
            }
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = listItems[position]
            holder.textView.text = item
        }

        override fun getItemCount(): Int {
            return listItems.size
        }



        inner class ViewHolder(viewBinding: ActivityRecyclerItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
            val textView: AppCompatTextView = viewBinding.textView
        }
    }
}