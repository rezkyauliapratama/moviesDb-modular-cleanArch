package id.co.rezkyauliapratama.multimodulecleanarchkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.rezkyauliapratama.libnavigation.Actions

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        startActivity(Actions.openHomeIntent(this))
        finish()
    }


}
