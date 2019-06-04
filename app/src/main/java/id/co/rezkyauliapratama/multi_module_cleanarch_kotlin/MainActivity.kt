package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import id.co.rezkyauliapratama.lib_navigation.Actions

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
