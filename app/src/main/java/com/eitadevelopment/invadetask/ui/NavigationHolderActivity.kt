package com.eitadevelopment.invadetask.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.eitadevelopment.invadetask.InvadeApplication
import com.eitadevelopment.invadetask.R
import com.eitadevelopment.invadetask.databinding.ActivityNavigationHolderBinding
import javax.inject.Inject
import kotlin.system.exitProcess

class NavigationHolderActivity : AppCompatActivity() {
    @Inject
    lateinit var mViewModel: SharedViewModel
    lateinit var loadingDialog: ProgressDialog
    private lateinit var mBinding: ActivityNavigationHolderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as InvadeApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        mBinding = ActivityNavigationHolderBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadingDialog = ProgressDialog(this).apply {
            setMessage("Loading...")
            isIndeterminate = true
            setCancelable(false)
        }

        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        mViewModel.reloadButton.observe(this, ::reloadButtonStatus)
        mViewModel.errorHandler.observe(this, ::onErrorOccurred)
        mViewModel.loadingHandler.observe(this, ::onLoading)
        mBinding.fabReload.setOnClickListener {
            mViewModel.universities
            navController.popBackStack()
        }

    }

    private fun onLoading(isLoading: Boolean) {
        if (isLoading) loadingDialog.show() else loadingDialog.dismiss()
    }

    private fun onErrorOccurred(exception: Exception?) {
        exception?.let {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("sorry we run into a problem,\nplease try again latter")
            builder.setTitle("Alert!")
            builder.setPositiveButton("Exit the application") { dialog, which ->
                // Action on button click
                dialog.dismiss()
                finishAffinity()
                exitProcess(0)
            }

            builder.show()
        }

    }

    private fun reloadButtonStatus(status: Boolean) {
        mBinding.fabReload.visibility = if (status) View.VISIBLE else View.GONE
    }

}