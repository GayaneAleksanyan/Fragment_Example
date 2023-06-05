package com.example.myfragment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FirstFragment())
            .addToBackStack(null)
            .commit()
    }

    fun startSecondFragment(imageButton: ImageView) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(imageButton, "transition_1")
            .addToBackStack(null)
            .replace(R.id.fragment_container, SecondFragment())
            .commit()
    }

    fun startExampleFragment(textView: TextView) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(textView, "tv_android")
            .addToBackStack(null)
            .replace(R.id.fragment_container, ExampleFragment())
            .commit()
    }

    fun startHelloFragment(imageButton: ImageView) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(imageButton, "transition_1")
            .addToBackStack(null)
            .replace(R.id.fragment_container, HelloFragment())
            .commit()
    }

    fun passData(editText: String) {
        val bundle = Bundle()
        bundle.putString("input", editText)

        val textFromHelloFragment = TextFromHelloFragment()
        textFromHelloFragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, textFromHelloFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()
    }

}