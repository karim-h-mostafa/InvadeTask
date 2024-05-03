package com.eitadevelopment.listing

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.listing.databinding.ListItemUniversityBinding
import javax.inject.Inject

class UniversitiesAdapter @Inject constructor() :
    RecyclerView.Adapter<UniversitiesAdapter.UniversityViewHolder>() {

    private lateinit var _dataList: List<UniversityDetails>
    private var _selectedUniversity: ((UniversityDetails) -> Unit)? = null
    fun setOnItemClicked(selectedItem: (UniversityDetails) -> Unit) {
        _selectedUniversity = selectedItem
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUniversitiesList(dataList: List<UniversityDetails>?) {
        _dataList = dataList ?: listOf()
        notifyDataSetChanged()
    }

    inner class UniversityViewHolder(private val mBinding: ListItemUniversityBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bindUniversity(universityDetails: UniversityDetails) {
            mBinding.tvName.text = universityDetails.name
            mBinding.tvState.text = universityDetails.stateProvince
        }

        init {
            itemView.setOnClickListener {
                _selectedUniversity?.let { it(_dataList[adapterPosition]) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            ListItemUniversityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bindUniversity(_dataList[position])
    }

    override fun getItemCount(): Int {
        return _dataList.size
    }
}