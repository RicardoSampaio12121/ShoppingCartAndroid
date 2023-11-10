package com.RicardoSoftwareSolutions.shoppingcart.modules.myLists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.RicardoSoftwareSolutions.shoppingcart.databinding.ActivityMyListsItemListBinding

class RVListItemsAdapter(private var lists: MutableList<ListItem>) :
    RecyclerView.Adapter<RVListItemsAdapter.ToDoViewHolder>() {

    private lateinit var clickListener: OnItemCLickListener

    interface OnItemCLickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemCLickListener){
        clickListener = listener
    }

    inner class ToDoViewHolder(
        val binding: ActivityMyListsItemListBinding,
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
    ): RVListItemsAdapter.ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMyListsItemListBinding.inflate(layoutInflater, parent, false)

        return ToDoViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: RVListItemsAdapter.ToDoViewHolder, position: Int) {
        holder.binding.apply {
            val current = lists[position]

            myListsListItemTv.text = current.name
            myListsListItemAmountTv.text = "${current.selectedAmount}/${current.totalAmount}" //TODO: See this suggestion
            myListsListItemPb.max = current.totalAmount
            myListsListItemPb.progress = current.selectedAmount
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }

}
