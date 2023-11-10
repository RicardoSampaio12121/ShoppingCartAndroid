package com.RicardoSoftwareSolutions.shoppingcart.modules.listContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.RicardoSoftwareSolutions.shoppingcart.R
import com.RicardoSoftwareSolutions.shoppingcart.modules.myLists.ListItem
import com.RicardoSoftwareSolutions.shoppingcart.modules.myLists.RVListItemsAdapter

class ListContentActivity : AppCompatActivity() {
    private lateinit var rvItemsAdapter: RVItemsAdapter
    private var items: MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_content)

        setBackButtonClickListener()

        items.add(Item("Bananas", false))
        items.add(Item("Monster", false))
        items.add(Item("Laranjas", false))

        startItemsRecyclerView()
    }

    private fun setBackButtonClickListener(){
        val button = findViewById<AppCompatImageButton>(R.id.listContent_backArrow_ib)

        button.setOnClickListener{
            finish()
        }
    }


    private fun startItemsRecyclerView(){
        val rvLists = findViewById<RecyclerView>(R.id.listContent_items_rv)

        rvLists.layoutManager = LinearLayoutManager(this)
        rvItemsAdapter = RVItemsAdapter(items)
        rvLists.adapter = rvItemsAdapter

        rvItemsAdapter.setOnItemClickListener(object: RVItemsAdapter.OnItemCLickListener{
            override fun onItemClick(position: Int) {
                TODO("Not yet implemented")
            }
        })
    }
}