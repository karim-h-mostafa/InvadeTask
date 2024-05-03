package com.eitadevelopment.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eitadevelopment.details.databinding.FragmentDetailsScreenBinding
import com.eitadevelopment.details.di.DaggerDetailsComponent
import com.eitadevelopment.invadetask.InvadeApplication
import com.eitadevelopment.invadetask.domain.entity.UniversityDetails
import com.eitadevelopment.invadetask.ui.SharedViewModel
import javax.inject.Inject

class DetailsScreenFragment : Fragment() {
    private lateinit var mBinding: FragmentDetailsScreenBinding

    @Inject
    lateinit var mViewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsScreenBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel.reloadButton.value = true
        mViewModel.universityDetails.observe(viewLifecycleOwner, ::onUniversityDetailsUpdated)
    }

    private fun onUniversityDetailsUpdated(universityDetails: UniversityDetails?) {

        universityDetails?.let { university ->
            mBinding.tvName.text = university.name
            mBinding.tvState.text = university.stateProvince
            mBinding.tvCountry.text = university.country
            mBinding.tvCountryCode.text = university.alphaTwoCode
            mBinding.tvWebPage.text = university.webPages[0]
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val applicationComponent =
            (context.applicationContext as InvadeApplication).applicationComponent
        DaggerDetailsComponent.factory().create(applicationComponent).inject(this)
    }
}