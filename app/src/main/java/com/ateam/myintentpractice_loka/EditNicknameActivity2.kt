package com.ateam.myintentpractice_loka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname2.*

class EditNicknameActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname2)

        okBtn.setOnClickListener {

//            입력한 새 닉네임이 뭔지? 변수로 저항
            val inputNickname = newNicknameEdt.text.toString()

//            입력한 닉네임을 가지고 메인으로 복귀
//            입력한 닉제임을 담아주기 위환 용도로만 사용하는 Intent
            val resultIntent = Intent()
            resultIntent.putExtra("nicknme", inputNickname)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
   }
}