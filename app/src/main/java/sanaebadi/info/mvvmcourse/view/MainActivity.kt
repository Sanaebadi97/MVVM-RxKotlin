package sanaebadi.info.mvvmcourse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sanaebadi.info.mvvmcourse.R
import sanaebadi.info.mvvmcourse.databinding.ActivityMainBinding
import sanaebadi.info.mvvmcourse.model.NameModel
import sanaebadi.info.mvvmcourse.utilitis.MainViewModelCallback
import sanaebadi.info.mvvmcourse.view.adapter.NameAdapter
import sanaebadi.info.mvvmcourse.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), MainViewModelCallback {

    lateinit var adapter: NameAdapter

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())
        val mainViewModel= MainViewModel(this)
        binding.viewModel=mainViewModel
        binding.rvName.setHasFixedSize(true)
        binding.rvName.adapter = adapter


    }

    override fun onDataFetched(names: ArrayList<NameModel>) {
        adapter.reloadData(names)
    }
}
