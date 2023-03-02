package com.example.note_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var name = findViewById(R.id.tdName) as EditText
//        var description = findViewById(R.id.description) as EditText
//        var word_letters = findViewById(R.id.word_letters) as EditText



//        val data = HashMap<String, Any>()
//        data["name"] = name;
//        data["description"] = description;
//        data["word_letters"] = word_letters;
//        var data = hashMapOf(
//            "name" to tdName.text.toString(),
//            "description" to description.text.toString(),
//            "word_letters" to word_letters.text.toString()
//        )
//        val data = hashMapOf(
//            "name" to tdName.text.toString(),
//            "description" to description.text.toString(),
//            "word_letters" to word_letters.text.toString()
//        )

        btn_add.setOnClickListener {
            var name = tdName.text.toString()
            var description = description.text.toString()
            var word_letters = word_letters.text.toString()

            val data = hashMapOf(

                "name" to name,
                "description" to description,
                "word_letters" to word_letters
            )
            db.collection("notes")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Log.e("MSG_BTN_ON_CLICK", "SUCESS");
                    Log.d(
                        "Added Successfully",
                        "DocumentSnapshot added with ID: ${documentReference.id}"
                    )
                    val i = Intent(applicationContext, MainActivity2::class.java)
                    startActivity(i)
                }
                .addOnFailureListener { e ->
                    Log.e("MSG_BTN_ON_CLICK", "ERROR");
                    Log.w("Added Failed", "Error adding document", e)
                }

        }
    }
}