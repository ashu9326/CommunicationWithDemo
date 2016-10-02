package com.example.ashutosh.communicationwithdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashutosh.communicationwithdemo.R;
import com.example.ashutosh.communicationwithdemo.model.Contact;

import java.util.List;

public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Contact> mData;
    private LayoutInflater mInflater;

    public ContactsRecyclerAdapter(Context context, List<Contact> mData) {

        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contact_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       Contact currentContact= mData.get(position);
        holder.setData(currentContact, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextName,mTextEmail,mTextMobile;
        private int position;
        private  Contact currentContact;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.row_name);
            mTextEmail= (TextView) itemView.findViewById(R.id.row_email);
            mTextMobile= (TextView) itemView.findViewById(R.id.row_mobile);

            mTextName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,currentContact.getEmail(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setData(Contact currentContact, int position) {
            this.position = position;
            this.currentContact = currentContact;
            mTextName.setText(currentContact.getName());
            mTextEmail.setText(currentContact.getEmail());
            mTextMobile.setText(currentContact.getMobile());

        }
    }
}