package com.monitorelectricitybill;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

        View myView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myView=itemView;
        }

        public void setType(String type){
            TextView mType=myView.findViewById(R.id.name_id);
            mType.setText(type);
        }
        public void setNote(String note){
            TextView mNote=myView.findViewById(R.id.description);
            mNote.setText(note);
        }

        public void setImage(int id){
            ImageView imageView=myView.findViewById(R.id.image);
            imageView.setImageResource(id);
        }

        public void setPower(String p){
            TextView mPower=myView.findViewById(R.id.power);
            mPower.setText(p+ " Watts");
        }
    public void setUses(int h,int m,int day){
        TextView mPower=myView.findViewById(R.id.uses);
        mPower.setText(h+":"+m+" hour/"+day+" day");
    }
    }