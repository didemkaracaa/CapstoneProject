package com.didemkaraca.ecommerce

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.didemkaraca.ecommerce.adapter.BagAdapter
import com.didemkaraca.ecommerce.databinding.FragmentBagBinding
import com.didemkaraca.ecommerce.viewmodel.BagViewModel


class BagFragment : Fragment() {
    private lateinit var fragmentBagBinding: FragmentBagBinding
    private val viewModel by lazy { BagViewModel() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBagBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_bag,container,false)
        return fragmentBagBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentBagBinding.button7.setOnClickListener {
            findNavController().navigate(R.id.action_bagFragment_to_successFragment)
        }
        viewModel.bagList.observe(viewLifecycleOwner, Observer { bagList ->
            Log.v("Bag ", "baggingList")
            val adapter = BagAdapter(bagList)
            fragmentBagBinding.setVariable(BR.adapter, adapter)

        })
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        fragmentBagBinding.recyclerView3.layoutManager = linearLayoutManager
    }

}