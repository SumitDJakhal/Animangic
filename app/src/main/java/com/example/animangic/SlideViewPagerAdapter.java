package com.example.animangic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        View view = layoutInflater.inflate ( R.layout.slidescreen, container, false );

        ImageView ind1=view.findViewById ( R.id.ind1);
        ImageView ind2=view.findViewById ( R.id.ind2 );
        ImageView ind3= view.findViewById ( R.id.ind3 );

        TextView tiletxt=view.findViewById ( R.id.titletxt );
        TextView desc=view.findViewById ( R.id.desc);

        ImageView back=view.findViewById ( R.id.back );
        ImageView next=view.findViewById ( R.id.next );
        Button startbtn=view.findViewById ( R.id.startbtn );
        startbtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (ctx,MainActivity.class);
                intent.setFlags ( Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity ( intent );
            }
        } );
        next.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v){
                    SlideActivity.viewPager.setCurrentItem ( position+1 );
            }
        } );
        back.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v){
                SlideActivity.viewPager.setCurrentItem ( position-1 );
            }
        } );
        switch (position)
        {
            case 0:
                ind1.setImageResource ( R.drawable.selected );
                ind2.setImageResource ( R.drawable.unselected );
                ind3.setImageResource ( R.drawable.unselected );

                tiletxt.setText ( "Step of Add Extensions" );
                desc.setText ( "Click on Setting Button , choose the Option' Add Extension'" );
                back.setVisibility ( view.GONE );
                break;
            case 1:
                ind1.setImageResource ( R.drawable.unselected );
                ind2.setImageResource ( R.drawable.selected );
                ind3.setImageResource ( R.drawable.unselected );

                tiletxt.setText ( "Step of Add Extensions" );
                desc.setText ( "Copy Extension url , and paste on it" );
                back.setVisibility ( view.GONE );
                break;
            case 2:
                ind1.setImageResource ( R.drawable.unselected );
                ind2.setImageResource ( R.drawable.unselected );
                ind3.setImageResource ( R.drawable.selected );

                tiletxt.setText ( "Step of Add Extensions" );
                desc.setText ( "Ready To Go..." );
                back.setVisibility ( view.GONE );
                break;

        }

        container.addView ( view );
        return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((View) object);
    }
}
