package com.didemkaraca.ecommerce

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.didemkaraca.ecommerce.adapter.CategoryAdapter
import com.didemkaraca.ecommerce.databinding.FragmentShopBinding
import com.didemkaraca.ecommerce.viewmodel.ShopFragmentViewModel


class ShopFragment : Fragment() {
    private lateinit var fragmentShopBinding: FragmentShopBinding
    private val shoppingViewModel by lazy { ShopFragmentViewModel{} }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentShopBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
        return fragmentShopBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        shoppingViewModel.categoryList.observe(viewLifecycleOwner, Observer { shopList ->
            Log.v("Bag FRAGMENT", "$shopList")
            val adapter = CategoryAdapter(shopList)
            fragmentShopBinding.setVariable(BR.adapter, adapter)

        })
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        fragmentShopBinding.recyclerView2.layoutManager = linearLayoutManager

    }
}

