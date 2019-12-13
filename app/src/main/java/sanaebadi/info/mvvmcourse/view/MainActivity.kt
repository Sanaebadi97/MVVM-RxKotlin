package sanaebadi.info.mvvmcourse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import sanaebadi.info.mvvmcourse.R
import sanaebadi.info.mvvmcourse.databinding.ActivityMainBinding
import sanaebadi.info.mvvmcourse.view.adapter.NameAdapter
import sanaebadi.info.mvvmcourse.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NameAdapter
    private lateinit var binding: ActivityMainBinding

    //define view model
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())


        binding.viewModel = viewModel
        binding.rvName.setHasFixedSize(true)
        binding.rvName.adapter = adapter


        viewModel.names.observe(this, Observer { nameList ->
            adapter.reloadData(nameList)

        })

    }


}
