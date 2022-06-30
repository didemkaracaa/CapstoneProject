package com.didemkaraca.ecommerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.adapter.ProductsAdapter
import com.didemkaraca.ecommerce.viewmodel.HomeFragmentViewModel
import com.didemkaraca.ecommerce.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { HomeFragmentViewModel() }
    private val productsAdapter by lazy { ProductsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()

    }
    private fun initObserves(){
       with(binding){
           with(viewModel){
             productList.observe(viewLifecycleOwner) {list ->
                println(list)
               recyclerView.apply{
                 setHasFixedSize(true)
                  adapter= productsAdapter.also{adapter->
                      adapter.updateList(list)
                  }
                   }

               }
             }
             }

           }


       }

