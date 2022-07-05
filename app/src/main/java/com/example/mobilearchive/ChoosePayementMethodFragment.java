package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.mobilearchive.controllers.NavigationFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

public class ChoosePayementMethodFragment extends Fragment {
    NavigationFragment navigationFragment;
    private TextInputLayout phone_number;
    private MaterialButton btn_pay;
    private ImageView mtn_image;
    private ImageView orange_image;
    private LinearLayoutCompat payment_form;
    private Toolbar toolbar;
    private MaterialButton btn_download;
    private MaterialTextView payement_title;

    public ChoosePayementMethodFragment(NavigationFragment navigationFragment) {
        this.navigationFragment= navigationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.choose_payment_method_fragment,container,false);
        toolbar= view.findViewById(R.id.top_toolbar);
        phone_number= view.findViewById(R.id.phone_number_pay);
        btn_pay= view.findViewById(R.id.btn_pay);
        mtn_image= view.findViewById(R.id.mtn_choose);
        orange_image= view.findViewById(R.id.orange_choose);
        payment_form= view.findViewById(R.id.payement_form);
        btn_download= view.findViewById(R.id.download_btn_payement);
        payement_title= view.findViewById(R.id.payment_variable_text);
        mtn_image.setImageResource(R.drawable.book_logo);
        orange_image.setImageResource(R.drawable.books_on_table);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        switchBetweenMethod();
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mtn_image.getVisibility()){
                    case View.GONE:
                        break;
                    case View.VISIBLE:
                        payment_form.setVisibility(View.GONE);
                        mtn_image.setVisibility(View.GONE);
                        orange_image.setVisibility(View.GONE);
                        payement_title.setText("Payement Confirmed!!!");
                        btn_download.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    private void switchBetweenMethod() {
        mtn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orange_image.setVisibility(View.GONE);
                payment_form.setVisibility(View.VISIBLE);
            }
        });
        orange_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtn_image.setVisibility(View.GONE);
                payment_form.setVisibility(View.VISIBLE);
            }
        });
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationFragment.succesDownload();
            }
        });
    }
}
