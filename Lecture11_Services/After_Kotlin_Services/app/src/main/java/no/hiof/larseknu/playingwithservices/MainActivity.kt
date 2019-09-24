package no.hiof.larseknu.playingwithservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import no.hiof.larseknu.playingwithservices.service.ACTION_RETREIVE_AND_SAVE_ADDRESS
import no.hiof.larseknu.playingwithservices.service.EXTRA_FILENAME
import no.hiof.larseknu.playingwithservices.service.MyIntentService
import no.hiof.larseknu.playingwithservices.service.MyStartedService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startStartedService(view: View) {
        startService(Intent(this, MyStartedService::class.java))
    }

    fun stopStartedService(view: View) {
        stopService(Intent(this, MyStartedService::class.java))
    }

    fun saveAddressIntentService(view: View) {
        val intent = Intent(this, MyIntentService::class.java)
        intent.action = ACTION_RETREIVE_AND_SAVE_ADDRESS
        intent.putExtra(EXTRA_FILENAME, "MyIntentService.txt")
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, MyStartedService::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.goToBoundActivity -> startActivity(Intent(this, BoundActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
