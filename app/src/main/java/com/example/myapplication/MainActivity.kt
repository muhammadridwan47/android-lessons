package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProfiles.setHasFixedSize(true)
        showRecylerView(onAddMockProfiles())
    }

    private fun onAddMockProfiles(): ArrayList<Profile> {
        val listData = ArrayList<Profile>()
        for (i in 1..9) {
            listData.add(Profile("Andrian $i", "Hello world", R.drawable.people))
        }
        return listData
    }

    private fun showRecylerView(listProfile: ArrayList<Profile>) {
        binding.rvProfiles.layoutManager = LinearLayoutManager(this)
        val listProfileAdapter = ListProfileAdapter(listProfile)
        binding.rvProfiles.adapter = listProfileAdapter
        listProfileAdapter.setOnItemClickCallback(object : ListProfileAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Profile) {
                onShowSelectedHero(data)
            }
        })
    }

    fun onShowSelectedHero(profile: Profile) {
        Toast.makeText(this, "Kamu memilih " + profile.name , Toast.LENGTH_SHORT).show()
    }

}