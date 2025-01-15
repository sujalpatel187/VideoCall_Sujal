package com.example.videocall_sujal

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class MainActivity : AppCompatActivity() {

    lateinit var username:EditText
    lateinit var login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        checkAndRequestAutoStartPermission()

        // Check and request lock screen notification permission
        checkAndRequestLockScreenNotificationPermission()

        // Check and request overlay permission (display popups)
        checkAndRequestOverlayPermission()

        username = findViewById(R.id.user_host)
        login = findViewById(R.id.login)

        login.setOnClickListener {
            val user ="doctor";
           val config= ZegoUIKitPrebuiltCallInvitationConfig()
            ZegoUIKitPrebuiltCallService.init(application,
                str.appid.toLong(), str.appsign,user,user,config)

            val intent = Intent(this,Connect::class.java)
            intent.putExtra("username",user)
            startActivity(intent)
        }

    }
    private fun checkAndRequestAutoStartPermission() {
        val manufacturer = Build.MANUFACTURER.lowercase()
        if (manufacturer.contains("xiaomi") || manufacturer.contains("oppo") || manufacturer.contains("vivo")) {
            // Direct the user to the specific settings page
            try {
                val intent = Intent()
                when (manufacturer) {
                    "xiaomi" -> {
                        intent.component = android.content.ComponentName(
                            "com.miui.securitycenter",
                            "com.miui.permcenter.autostart.AutoStartManagementActivity"
                        )
                    }
                    "oppo" -> {
                        intent.component = android.content.ComponentName(
                            "com.coloros.safecenter",
                            "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                        )
                    }
                    "vivo" -> {
                        intent.component = android.content.ComponentName(
                            "com.vivo.permissionmanager",
                            "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                        )
                    }
                }
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Please enable auto-start for this app.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkAndRequestLockScreenNotificationPermission() {
        val notificationManager = NotificationManagerCompat.from(this)
        if (!notificationManager.areNotificationsEnabled()) {
            Toast.makeText(this, "Please enable notifications for lock screen visibility.", Toast.LENGTH_LONG).show()
            val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
            }
            startActivity(intent)
        }
    }

    private fun checkAndRequestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                // Request permission
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                Toast.makeText(this, "Please enable 'Display over other apps' permission.", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}