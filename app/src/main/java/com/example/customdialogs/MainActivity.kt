package com.example.customdialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_button.setOnClickListener {
            Snackbar.make(it, "You have clicked image button.", Snackbar.LENGTH_SHORT).show()
        }
        btn_alert_dialog.setOnClickListener {
            alertDialogFunction()
        }
        btn_custom_dialog.setOnClickListener {
            customDialogFunction()
        }
        btn_custom_progress_dialog.setOnClickListener {
            customProgressDialogFunction()
        }

    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is used to show alert dialog.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){ dialogInterface , which ->
            Toast.makeText(applicationContext, "Clicked Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){ dialogInterface , which ->
            Toast.makeText(applicationContext, "Clicked No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){ dialogInterface , which ->
            Toast.makeText(applicationContext, "Clicked Cancel", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()

    }

    private fun customDialogFunction(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)

        customDialog.tv_submit.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Clicked Submit", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        })
        customDialog.tv_cancel.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Clicked Cancel", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        })

        customDialog.show()
    }

    private fun customProgressDialogFunction(){
        val customProgressDialog = Dialog(this)

        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        customProgressDialog.show()
    }
}