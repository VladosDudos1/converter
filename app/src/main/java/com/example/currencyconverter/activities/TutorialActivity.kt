package com.example.currencyconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.currencyconverter.OnboardingScreen
import com.example.currencyconverter.R
import com.example.currencyconverter.TutorialResponse
import com.example.currencyconverter.app.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tutorial.*
import kotlinx.android.synthetic.main.vp_view.view.*
import java.lang.Exception

class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        btn_skip.setOnClickListener(this::toApp)
        btn_go.setOnClickListener(this::toApp)
        btn_next.setOnClickListener(this::next1)
        btn_next2.setOnClickListener(this::next2)



        val disp = App.dm.api
            .onboardingSkreen()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({o ->
                vp_tutorial.adapter = TutorialAdapter(o.onboarding_screens)
            },
                { Log.d("", "")})


    }

    fun toApp(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        App.dm.endFirstLaunch()
        finish()
    }
    fun next1(view: View){
        first.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp)
        second.setImageResource(R.drawable.ic_brightness_1_black_24dp)
        btn_next2.visibility = View.VISIBLE
        btn_next.visibility = View.GONE
    }
    fun next2(view: View){
        second.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp)
        third.setImageResource(R.drawable.ic_brightness_1_black_24dp)
        btn_skip.visibility = View.GONE
        btn_next2.visibility = View.GONE
        btn_go.visibility = View.VISIBLE
    }

}

class TutorialAdapter(val list: List<OnboardingScreen>) : RecyclerView.Adapter<TutorialAdapter.TutorialView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vp_view, parent, false)
        val tutorialView = TutorialView(view)
        return tutorialView
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: TutorialView, position: Int) {

            Glide.with(holder.itemView.vp_img)
                .load(list[position].img_url)
                .into(holder.itemView.vp_img)


            holder.itemView.vp_titile.text = list[position].title
            holder.itemView.vp_text.text = list[position].title
    }

    class TutorialView(view: View) : RecyclerView.ViewHolder(view)
}