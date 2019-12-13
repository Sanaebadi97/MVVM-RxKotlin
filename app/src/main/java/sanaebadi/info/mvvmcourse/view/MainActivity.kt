package sanaebadi.info.mvvmcourse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sanaebadi.info.mvvmcourse.R
import sanaebadi.info.mvvmcourse.androidWrapper.NetworkManager
import sanaebadi.info.mvvmcourse.databinding.ActivityMainBinding
import sanaebadi.info.mvvmcourse.extension.MainViewModelFactory
import sanaebadi.info.mvvmcourse.view.adapter.NameAdapter
import sanaebadi.info.mvvmcourse.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NameAdapter
    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(NetworkManager(this))
        ).get(MainViewModel::class.java)

        binding.viewModel = mainViewModel
        binding.rvName.setHasFixedSize(true)
        binding.rvName.adapter = adapter


        mainViewModel.names.observe(this, Observer { nameList ->
            adapter.reloadData(nameList)

        })

    }


}
