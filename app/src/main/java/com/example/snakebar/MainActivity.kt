package com.example.snakebar

import android.app.Dialog
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var btnsnack : Button
    lateinit var btnview : Button
    lateinit var btndilog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsnack = findViewById(R.id.btnsnackBar)
        btnview = findViewById(R.id.btnview)
        btndilog = findViewById(R.id.btndilog)

        btnsnack.setOnClickListener {
            var snackbar = Snackbar.make(btnsnack,"This is Snackbar",Snackbar.LENGTH_LONG)

            snackbar.setAnchorView(R.id.btnsnackBar)
            snackbar.setAction("OK"){
                Toast.makeText(this,"SnackBar",Toast.LENGTH_LONG).show()
            }


            snackbar.show()
        }
        btnview.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("this is Title")
                .setMessage("Chose Title")
                .setPositiveButton("positive"){_,_->
                }
                .setNegativeButton("Nagitive"){_,_->
                }
                .setNeutralButton("Neutral"){_,_->
                }
                .show()
        }
        btndilog.setOnClickListener {
            var dialog = Dialog(this@MainActivity)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            var btnset = dialog.findViewById<Button>(R.id.btnset)
            var btncencel = dialog.findViewById<Button>(R.id.btncencel)
                btnset.setOnClickListener {
                    dialog.dismiss()
                }
            btncencel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}