package com.example.parayo.product.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parayo.base.BaseViewModel
import com.example.parayo.product.category.categoryList

class ProductRegistrationViewModel @ViewModelInject constructor() : BaseViewModel() {

    private val _imageUrls = mutableListOf<MutableLiveData<String>>()
    val imageUrls: List<LiveData<String>> get() = _imageUrls

    private val _imageIds = MutableLiveData<List<Long>>()
    val imageIds: LiveData<List<Long>> get() = _imageIds

    private val _productName = MutableLiveData<String>()
    val productName: LiveData<String> get() = _productName

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> get() = _description

    private val _price = MutableLiveData<String>()
    val price: LiveData<String> get() = _price

    private val _categories =
        MutableLiveData<List<String>>(categoryList.map { it.name })
    val categories: LiveData<List<String>> get() = _categories

    private var categoryIdSelected = categoryList[0].id

    private val descriptionLimit = 500
    private val productNameLimit = 40

    private val _productNameLength = MutableLiveData("0/$productNameLimit")
    val productNameLength: LiveData<String> get() = _productNameLength

    private val _descriptionLength = MutableLiveData("0/$descriptionLimit")
    val descriptionLength: LiveData<String> get() = _descriptionLength

    fun checkProductNameLength() {
        _productName.value?.let {
            if (it.length > productNameLimit) {
                _productName.value = it.take(productNameLimit)
            }
            _productNameLength.value = "${_productName.value?.length}/$productNameLimit"
        }
    }

    fun checkDescriptionLength() {
        _description.value?.let {
            if (it.length > descriptionLimit) {
                _description.value = it.take(descriptionLimit)
            }
            _descriptionLength.value = "${_description.value?.length}/$descriptionLimit"
        }
    }

    fun onCategorySelect(position: Int) {
        categoryIdSelected = categoryList[position].id
    }
}