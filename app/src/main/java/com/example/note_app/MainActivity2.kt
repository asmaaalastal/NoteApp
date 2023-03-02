package com.example.note_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.note_app.Adapter.NoteAdapter
import com.example.note_app.model.Note
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val notes = ArrayList<Note>()
        val noteAdapter = NoteAdapter(this@MainActivity2,notes)
        lvNotes.adapter = noteAdapter
       db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    notes.add(
                        Note(
                            document.getString("name").toString(),
                            document.getString("description").toString(),
//                            document.getLong("note_letters")?.toInt()
                            document.getString("word_letters").toString(),
                        )
                    )
                    noteAdapter.notifyDataSetChanged()
                    Log.d("Read Successfully", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Read Failed", "Error getting documents.", exception)
            }



        add_note.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
    }
}