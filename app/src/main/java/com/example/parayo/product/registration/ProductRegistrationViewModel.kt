package com.example.parayo.product.registration

import android.net.Uri
import androidx.core.net.toUri
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.parayo.base.BaseViewModel
import com.example.parayo.domain.product.ProductRepository
import com.example.parayo.product.category.categoryList
import com.example.parayo.util.Result
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductRegistrationViewModel @ViewModelInject constructor(
    private val productRepository: ProductRepository
) : BaseViewModel() {

    private val _imageUris =
        arrayOf(MutableLiveData<Uri>(), MutableLiveData(), MutableLiveData(), MutableLiveData())
    val imageUris: Array<LiveData<Uri>> get() = _imageUris.map { it }.toTypedArray()

    private val _imageIds = MutableLiveData<List<Long>>()
    val imageIds: LiveData<List<Long>> get() = _imageIds

    val productName = MutableLiveData<String>()

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> get() = _description

    private val _price = MutableLiveData<String>()
    val price: LiveData<String> get() = _price

    private val _categories =
        MutableLiveData<List<String>>(categoryList.map { it.name })
    val categories: LiveData<List<String>> get() = _categories

    private var categoryIdSelected = categoryList[0].id

    private val descriptionLimit = 500

    private val _descriptionLength = MutableLiveData("0/$descriptionLimit")
    val descriptionLength: LiveData<String> get() = _descriptionLength

    val imgUpload = fun(index: Int, uri: Uri) {
        _imageUris[index].value = uri
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

    fun uploadProduct() = viewModelScope.launch {
        val imageUriList = _imageUris.map { it.value ?: "".toUri() }
        val requestList = mutableListOf<Deferred<Result<Boolean>>>()
        for (uri in imageUriList) {
            requestList.add(async { productRepository.uploadProductImage(uri) })
        }

        for (request in requestList) {
            when (val result = request.await()) {
                is Result.Success -> {
                    if (!result.data) return@launch
                }
                is Result.Failure -> {
                    return@launch
                }
            }
        }
    }
}