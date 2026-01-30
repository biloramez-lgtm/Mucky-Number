package com.muckynumber.game

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var score = 0
    private var level = 1
    private var coins = 0

    private lateinit var scoreTextView: TextView
    private lateinit var levelTextView: TextView
    private lateinit var coinsTextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var gameImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        startGame()
    }

    private fun initializeViews() {
        scoreTextView = findViewById(R.id.scoreText)
        levelTextView = findViewById(R.id.levelText)
        coinsTextView = findViewById(R.id.coinsText)
        messageTextView = findViewById(R.id.messageText)
        gameImageView = findViewById(R.id.gameImage)

        val playButton: Button = findViewById(R.id.playButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val luckyButton: Button = findViewById(R.id.luckyButton)

        playButton.setOnClickListener { playGame() }
        resetButton.setOnClickListener { resetGame() }
        luckyButton.setOnClickListener { useLucky() }
    }

    private fun startGame() {
        updateUI()
        messageTextView.text = "🎮 مرحباً بك في لعبة الأرقام الحظية!\nاضغط 'لعب' للبدء"
    }

    private fun playGame() {
        val randomNumber = Random.nextInt(1, 100)

        when {
            randomNumber > 80 -> {
                score += 100
                coins += 50
                messageTextView.text = "🎉 ممتاز! +100 نقطة!"
            }
            randomNumber > 50 -> {
                score += 50
                coins += 25
                messageTextView.text = "👍 جيد! +50 نقطة!"
            }
            else -> {
                score += 10
                coins += 5
                messageTextView.text = "✓ محاولة! +10 نقاط"
            }
        }

        if (score >= level * 500) {
            level++
            messageTextView.text = "🏆 تقدمت للمستوى $level!"
        }

        updateUI()
    }

    private fun useLucky() {
        if (coins < 100) {
            messageTextView.text = "❌ تحتاج 100 عملة للحظ الجيد"
            return
        }

        coins -= 100
        score += 500
        messageTextView.text = "⭐ حظ جيد! +500 نقطة!"
        updateUI()
    }

    private fun resetGame() {
        score = 0
        level = 1
        coins = 0
        messageTextView.text = "تم إعادة تعيين اللعبة ✓"
        updateUI()
    }

    private fun updateUI() {
        scoreTextView.text = "النقاط: $score"
        levelTextView.text = "المستوى: $level"
        coinsTextView.text = "العملات: $coins"
    }
}
