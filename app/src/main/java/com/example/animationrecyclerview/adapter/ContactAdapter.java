package com.example.animationrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationrecyclerview.R;
import com.example.animationrecyclerview.activity.MainActivity;
import com.example.animationrecyclerview.model.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity mainActivity;
    Context context;
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactAdapter(MainActivity mainActivity, ArrayList<Contact> contacts) {
        this.mainActivity = mainActivity;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact = contacts.get(position);

        if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).name.setText(contact.getName());
            ((ContactViewHolder) holder).number.setText(contact.getNumber());
            ((ContactViewHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.openDetailPage(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView name;
        TextView number;
        LinearLayout layout;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            layout = view.findViewById(R.id.linear_layout);
            name = view.findViewById(R.id.tv_contact_name);
            number = view.findViewById(R.id.tv_contact_number);
        }
    }
}
