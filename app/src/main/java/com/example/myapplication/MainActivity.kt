package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProfiles.setHasFixedSize(true)
        showRecyclerList(onAddMockProfiles())
    }


    private fun onAddMockProfiles(): ArrayList<Profile> {
        val listData = ArrayList<Profile>();
        for (i in 1..9) {
            listData.add(Profile("Adrian $i", "hello world", R.drawable.ic_people ))
        }
        return listData
    }

    private fun showRecyclerList(listProfiles: ArrayList<Profile>) {

        binding.rvProfiles.layoutManager = LinearLayoutManager(this)

        val listProfileAdapter = ListProfileAdapter(listProfiles)
        binding.rvProfiles.adapter = listProfileAdapter

        listProfileAdapter.setOnItemClickCallback(object : ListProfileAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Profile) {
                onShowSelectedHero(data)
            }
        })
    }

    private fun onShowSelectedHero(hero: Profile) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}