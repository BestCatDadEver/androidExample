package com.example.exercise.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.exercise.R
import com.example.exercise.model.Player
import com.example.exercise.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

        fun leagueNextActivityButtonClicked(view: View){
            if(player.league != ""){
                val skill = Intent(this, SkillActivity::class.java)
                skill.putExtra(EXTRA_PLAYER, player)
                startActivity(skill)
            }else{
                Toast.makeText(this,"Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }


        fun onMenLeagueButtonClicked(view : View){
            womenLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false

            player.league = "men"
        }

        fun onWomenLeagueButtonClicked(view : View){
            menLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false

            player.league = "women"
        }

        fun onCoEdLeagueButtonClicked(view : View){
            womenLeagueBtn.isChecked = false
            menLeagueBtn.isChecked = false

            player.league = "co-ed"
        }

}