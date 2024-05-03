package com.eitadevelopment.listing

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.eitadevelopment.invadetask.InvadeApplication
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.ui.SharedViewModel
import com.eitadevelopment.listing.databinding.FragmentListingScreenBinding
import com.eitadevelopment.listing.di.DaggerListingComponent
import com.eitadevelopment.invadetask.R
import javax.inject.Inject

class ListingScreenFragment : Fragment() {
    private lateinit var mBinding: FragmentListingScreenBinding

    @Inject
    lateinit var mViewModel: SharedViewModel

    @Inject
    lateinit var universitiesAdapter: UniversitiesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListingScreenBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel.universities.observe(viewLifecycleOwner, ::onUniversitiesRespond)
        universitiesAdapter.setOnItemClicked {
            mViewModel.universityDetails.value = it
            findNavController().navigate(getString(R.string.details_screen).toUri())
        }
    }

    private fun onUniversitiesRespond(universityDetails: List<UniversityDetails>?) {
        if (universityDetails != null) {

            universitiesAdapter.setUniversitiesList(universityDetails)
            mBinding.rvUniversities.adapter = universitiesAdapter
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val applicationComponent =
            (context.applicationContext as InvadeApplication).applicationComponent
        DaggerListingComponent.factory().create(applicationComponent).inject(this)

    }

    override fun onResume() {
        super.onResume()
        mViewModel.reloadButton.value = false
    }
}