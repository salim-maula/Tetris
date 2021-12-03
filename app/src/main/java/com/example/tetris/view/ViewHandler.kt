package com.example.tetris.view

import android.os.Handler
import android.widget.Toast
import androidx.core.app.NotificationCompat
import android.os.Message
import com.example.tetris.models.AppModel

class ViewHandler(private val owner: TetrisView) : Handler() {
    override fun handleMessage(message: Message) {
        if (message.what == 0) {
            if (owner.model != null) {
                if (owner.model!!.isGameOver()) {
                    owner.model?.endGame()
                    Toast.makeText(owner.activity, "Game over",
                        Toast.LENGTH_LONG).show();
                }
                if (owner.model!!.isGameActive()) {
                    owner.setGameCommandWithDelay(AppModel.Motions.DOWN)
                }
            }
        }
    }
    fun sleep(delay: Long) {
        this.removeMessages(0)
        sendMessageDelayed(obtainMessage(0), delay)
    }
}

