package com.RicardoSoftwareSolutions.shoppingcart.modules.listContent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.RicardoSoftwareSolutions.shoppingcart.databinding.ActivityListContentItemBinding
import com.RicardoSoftwareSolutions.shoppingcart.databinding.ActivityMyListsItemListBinding

class RVItemsAdapter(private var items: MutableList<Item>):
    RecyclerView.Adapter<RVItemsAdapter.ToDoViewHolder>(){

    private lateinit var clickListener: OnItemCLickListener

    interface OnItemCLickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemCLickListener){
        clickListener = listener
    }

    inner class ToDoViewHolder(
        val binding: ActivityListContentItemBinding,
        listener: OnItemCLickListener
    ): RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVItemsAdapter.ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityListContentItemBinding.inflate(layoutInflater, parent, false)

        return ToDoViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: RVItemsAdapter.ToDoViewHolder, position: Int) {
        holder.binding.apply {
            val current = items[position]

            listContentItemItemTv.text = current.name
            listContentItemItemRb.isChecked = current.selected
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}