package com.example.note_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.note_app.MainActivity2
import com.example.note_app.R
import com.example.note_app.model.Note
import kotlinx.android.synthetic.main.lvnote_card.view.*

class NoteAdapter(var activity: MainActivity2, var data:ArrayList<Note>) : BaseAdapter(){
    override fun getCount(): Int {
       return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val root = LayoutInflater.from(activity).inflate(R.layout.lvnote_card,null,false)
        root.noteName.text = data[position].name
        root.noteDescription.text = data[position].description
        root.noteLetters.text = data[position].word_letters.toString()
        return root
    }

}
