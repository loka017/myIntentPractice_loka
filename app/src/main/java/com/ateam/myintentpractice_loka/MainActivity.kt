package com.ateam.myintentpractice_loka

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    멤버변수
    val REQ_FOR_NICKNAME = 2222

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kakaoStoreBtn.setOnClickListener {

            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)

        }

        naverWebBtn.setOnClickListener {

            val myUri = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)

        }

        smsBtn.setOnClickListener {

//            phonNumEdt에 입력한 전화번호를 받아서 +.해당 번호에 전화 연결
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리내용 입력")
            startActivity(myIntent)
        }

        callBtn.setOnClickListener {

//            phonNumEdt에 입력한 전화번호를 받아서 +.해당 번호에 전화 연결
            val inputPhonNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhonNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

//        DIAL 액션 예제

        dialBtn.setOnClickListener {

//            phonNumEdt에 입력한 전화번호를 받아서 +.해당 번호에 전화 연결

            val inputPhonNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhonNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)
        }


        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity2::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }


        sendMessageBtn.setOnClickListener {

//          입력한 내용을 변수에 저장.
            val inputMessage = messageEdt.text.toString()
//          비행기 티켓 발권
            val myIntent = Intent(this,MessageActivity::class.java)
//          수하물 첨부
            myIntent.putExtra("message", inputMessage)
//            실제 출발
            startActivity(myIntent)
        }
        moveToBtn.setOnClickListener {
//
        // 다은 화면으로 이돟 OtherActivity
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if(requestCode ==REQ_FOR_NICKNAME){

//            추가질문 : 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK){

                //실제로 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영.
                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname
            }
        }
    }
}