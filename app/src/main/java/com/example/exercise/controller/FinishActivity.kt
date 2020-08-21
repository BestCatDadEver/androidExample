package com.example.exercise.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise.R
import com.example.exercise.model.Player
import com.example.exercise.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueText.text = "Looking for a ${player.league} ${player.category} near you."
    }
}