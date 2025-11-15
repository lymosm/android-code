package com.example.test_kotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // custom titlebar 自定义标题栏
        try {
            // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE)
            setContentView(R.layout.activity_main)

         //   window.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_btn)
        }catch(e: Exception){
            e.printStackTrace()
        }
        setIconClick()
        setLoginClick()
    }

    private fun setFragHome(){
        replaceFragment(FragHome())
    }

    private fun goToActivity(){
        val intent = Intent(this, MyLoginActivity::class.java)
       // intent.setClass(this, MyLoginActivity::class.java)
        this?.startActivity(intent)
    }

    private fun setLoginClick(){
        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            goToActivity()
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frag, fragment)
        transaction.commit()
    }

    private fun goToFragList(){
        replaceFragment(FragList())
    }

    private fun alert(msg: String){
        val dialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_launcher_background)
            .setTitle("Tip")
            .setMessage(msg)
        dialog.create().show()
    }

    /**
     * set icon selected style
     */
    private fun setIconClick(){
        val icon1: RelativeLayout = findViewById(R.id.icon1)
        val icon1Text: TextView = findViewById(R.id.icon1_text)
        val icon1Img: ImageView = findViewById(R.id.icon1_img)

        val icon2: RelativeLayout = findViewById(R.id.icon2)
        val icon2Text: TextView = findViewById(R.id.icon2_text)
        val icon2Img: ImageView = findViewById(R.id.icon2_img)

        val icon3: RelativeLayout = findViewById(R.id.icon3)
        val icon3Text: TextView = findViewById(R.id.icon3_text)
        val icon3Img: ImageView = findViewById(R.id.icon3_img)

        icon1.setOnClickListener{
            icon1Text.setTextColor(Color.parseColor("#a423a5"))
            icon1Img.setImageResource(R.drawable.home_selected)
            icon2Text.setTextColor(Color.parseColor("#000000"))
            icon2Img.setImageResource(R.drawable.ic_launcher_background)
            icon3Text.setTextColor(Color.parseColor("#000000"))
            icon3Img.setImageResource(R.drawable.ic_launcher_background)

            setFragHome()
        }
        icon1.callOnClick()  // 触发点击

        icon2.setOnClickListener{
            icon2Text.setTextColor(Color.parseColor("#a423a5"))
            icon2Img.setImageResource(R.drawable.home_selected)
            icon1Text.setTextColor(Color.parseColor("#000000"))
            icon1Img.setImageResource(R.drawable.ic_launcher_background)
            icon3Text.setTextColor(Color.parseColor("#000000"))
            icon3Img.setImageResource(R.drawable.ic_launcher_background)

            goToFragList()
        }

        icon3.setOnClickListener{
            icon3Text.setTextColor(Color.parseColor("#a423a5"))
            icon3Img.setImageResource(R.drawable.home_selected)
            icon1Text.setTextColor(Color.parseColor("#000000"))
            icon1Img.setImageResource(R.drawable.ic_launcher_background)
            icon2Text.setTextColor(Color.parseColor("#000000"))
            icon2Img.setImageResource(R.drawable.ic_launcher_background)

            goToFragUser()
        }
    }

    private fun goToFragUser(){
        replaceFragment(FragUser())
    }
}

/**
 * create a fragment
 */
class FragHome: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.home, container, false)
    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)

    }
    */

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val btnLogin: Button = view?.findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            goToActivity()
        }
    }
     */

    private fun goToActivity(){
        val ac = MainActivity()
        val intent = Intent(ac, MyLoginActivity::class.java)
        // intent.setClass(this, MyLoginActivity::class.java)
        ac?.startActivity(intent)
    }

}