package com.RicardoSoftwareSolutions.shoppingcart.modules.myLists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.RicardoSoftwareSolutions.shoppingcart.R
import com.RicardoSoftwareSolutions.shoppingcart.modules.listContent.ListContentActivity

class MyListsActivity : AppCompatActivity() {

    private lateinit var rvAdapter: RVListItemsAdapter
    private var lists: MutableList<ListItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lists)

        lists.add(ListItem("Compras semana", 20, 49))
        lists.add(ListItem("Compras mensais", 27, 65))
        lists.add(ListItem("Compras natal", 4, 5))

        startListsRecyclerView()
    }

    private fun startListsRecyclerView(){
        val rvLists = findViewById<RecyclerView>(R.id.myLists_lists_rv)

        rvLists.layoutManager = LinearLayoutManager(this)
        rvAdapter = RVListItemsAdapter(lists)
        rvLists.adapter = rvAdapter

        rvAdapter.setOnItemClickListener(object: RVListItemsAdapter.OnItemCLickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MyListsActivity, ListContentActivity::class.java)
                startActivity(intent)
            }
        })
    }
}