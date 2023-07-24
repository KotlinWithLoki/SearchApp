package android.atest.searchapp

import android.atest.searchapp.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = arrayOf("Anvar", "Botir", "Davron", "Elyor", "Odilbek", "Nusratillo", "MuhammadSodiq")

        val userAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, user
        )
        binding.listView.adapter=userAdapter

        binding.searcherView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searcherView.clearFocus()
                if (user.contains(p0)){
                    userAdapter.filter.filter(p0)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                userAdapter.filter.filter(p0)
                return false
            }

        })

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            Toast.makeText(
                applicationContext,
                selectedItem,
                Toast.LENGTH_SHORT
            ).show()
        }

        }
}
