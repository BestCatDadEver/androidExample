package com.example.exercise.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.exercise.R
import com.example.exercise.model.Player
import com.example.exercise.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClicked(view : View){
        ballerBtn.isChecked = false
        player.category = "beginner"
    }

    fun onBallerClicked(view: View){
        beginnerBtn.isChecked = false
        player.category = "baller"
    }

    fun onFinishClicked(view: View){
        if(player.category != ""){
            val finishedActivity = Intent(this,FinishActivity::class.java)
            finishedActivity.putExtra(EXTRA_PLAYER,player)

            startActivity(finishedActivity)
        }else{
            Toast.makeText(this,"Please select a category.", Toast.LENGTH_SHORT).show()
        }
    }
}