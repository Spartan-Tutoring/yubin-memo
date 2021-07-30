package com.yubin.memo60.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.textfield.TextInputLayout
import com.yubin.memo60.BaseActivity
import com.yubin.memo60.R
import com.yubin.memo60.db_user.User
import com.yubin.memo60.db_user.UserDB

class SignUpActivity: BaseActivity() {
    var pwchecking : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val idTil = findViewById<TextInputLayout>(R.id.signup_id_til)
        val pwTil = findViewById<TextInputLayout>(R.id.signup_pw_til)
        val pwcheckTil = findViewById<TextInputLayout>(R.id.signup_pwcheck_til)
        val nameTil = findViewById<TextInputLayout>(R.id.signup_nickname_til)
        val signUpBtn = findViewById<Button>(R.id.signup_signup_bt)

        val idEt = idTil.editText
        val pwEt = pwTil.editText
        val pwcheckEt = pwcheckTil.editText
        val nameEt = nameTil.editText

        pwcheckEt?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (pwcheckEt.text.toString() != pwEt?.text.toString()){
                    pwcheckTil.error = getString(R.string.signup_pwcheck_error)
                    pwchecking = false
                }else {
                    pwcheckTil.error = null
                    pwchecking = true
                }
            }
        })

        signUpBtn.setOnClickListener{
            signUp(idEt?.text.toString(), pwEt?.text.toString(), nameEt?.text.toString(), pwchecking)
        }
    }
    private fun signUp(id: String, pw: String, name: String, pwchecking: Boolean){
        if(id.isEmpty() || pw.isEmpty() || name.isEmpty() || !pwchecking){
            Toast.makeText(this, "필수 정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        val userDB : UserDB = Room.databaseBuilder(this, UserDB::class.java, "user-db").allowMainThreadQueries().build()
        val user = User(id, pw, name)
        val alreadyUser = userDB.userDao().getUserById(id)
//        userDB.userDao().insertUser(user)
//        val users = userDB.userDao().getUsers()

        val idTil = findViewById<TextInputLayout>(R.id.signup_id_til)
//        val idEt = idTil.editText
        if (alreadyUser === null){
            val user = User(id = id, pw = pw, name = name)
            userDB.userDao().insertUser(user)
            val users = userDB.userDao().getUsers()
            for (user in users){
                Log.d("user-db", "idx : ${user.idx}, userId : ${user.id}, userPw: ${user.pw}, userName: ${user.name}")
            }

            showDialog("가입에 성공했습니다.")
        }else{
            idTil.error = "이미 존재하는 회원입니다."
        }
//        for (user in users){
//            Log.d("user-db", "idx : ${user.idx}, userId : ${user.id}, userPw: ${user.pw}, userName: ${user.name}")
//        }
    }

    override fun onOKClicked() {
        super.onOKClicked()
        finish()
    }
}