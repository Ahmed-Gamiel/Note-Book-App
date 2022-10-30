package com.example.viewpagerapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder
{
    LinearLayout noteModelLayout;
    ImageView options,isTask;
    private TextView title;
    private TextView content;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        title =itemView.findViewById(R.id.title_text);
        content =itemView.findViewById(R.id.body_text);
        noteModelLayout =itemView.findViewById(R.id.note_model_layout);
        options = itemView.findViewById(R.id.menu_popup);
        isTask = itemView.findViewById(R.id.is_task);

        //Animate Recyclerview
//            Animation translate_anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.translate_anim);
//            noteModelLayout.setAnimation(translate_anim);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }

    public LinearLayout getNoteModelLayout() {
        return noteModelLayout;
    }

    public void setNoteModelLayout(LinearLayout noteModelLayout) {
        this.noteModelLayout = noteModelLayout;
    }

    public ImageView getOptions() {
        return options;
    }

    public void setOptions(ImageView options) {
        this.options = options;
    }
    public ImageView getIsTask() {
        return isTask;
    }

    public void setIsTask(ImageView isTask) {
        this.isTask = isTask;
    }
    public void setListeners() {
        itemView.setOnClickListener((v)->{

        });
    }
}
