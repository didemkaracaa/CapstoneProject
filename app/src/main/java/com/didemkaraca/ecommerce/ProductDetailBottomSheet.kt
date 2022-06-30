package com.didemkaraca.ecommerce

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.didemkaraca.ecommerce.databinding.ProductDetailBinding
import com.didemkaraca.ecommerce.viewmodel.DetailViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso


class ProductDetailBottomSheet : BottomSheetDialogFragment() {
     private var _binding: ProductDetailBinding?=null
    private val binding get()= _binding!!
    private val viewModel by lazy { DetailViewModel(requireContext()) }
    private val args:ProductDetailBottomSheetArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.product_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product=args.productModel
        binding.productDetail=product
        Picasso.get().load(product.image).into(binding.imageView5)
        binding.button5.setOnClickListener {
            FirebaseAuth.getInstance().currentUser?.let { user ->
                viewModel.addToBag(
                    user.uid,
                    product.title,
                    product.price,
                    product.description,
                    product.category,
                    product.image,
                    product.rate,
                    product.count,
                    product.sale_state
                )

            }
            Log.v("POST","post oldu")
            findNavController().navigate(R.id.action_productDetailBottomSheet_to_bag)
        }

    }


}