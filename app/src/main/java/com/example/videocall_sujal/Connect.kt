package com.example.videocall_sujal

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import java.util.Collections

class Connect : AppCompatActivity() {
    lateinit var username:TextView
    lateinit var friendname:EditText
    lateinit var voiceCall : ZegoSendCallInvitationButton
    lateinit var videoCall : ZegoSendCallInvitationButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_connect)

        username=findViewById(R.id.user_host)
        friendname=findViewById(R.id.friend_name)
        voiceCall=findViewById(R.id.voicecall)
        videoCall=findViewById(R.id.videocall)

        username.text="Hello 😃 "+intent.getStringExtra("username")

        friendname.addTextChangedListener {
            val target=friendname.text.toString()
            setvoiceCall(target)
            setvideoCall(target)
        }
    }

    fun setvoiceCall(user : String){
        voiceCall.setIsVideoCall(false)
        voiceCall.resourceID="zego_uikit_call"
        voiceCall.setInvitees(Collections.singletonList(ZegoUIKitUser(user,user)))
    }
    fun setvideoCall(user : String){
        videoCall.setIsVideoCall(true)
        videoCall.resourceID="zego_uikit_call"
        videoCall.setInvitees(Collections.singletonList(ZegoUIKitUser(user,user)))
    }
}