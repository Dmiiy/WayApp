package com.dmiiy.wayapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {
    private List<ItemObject> mListItems;
    private IClickListner iClickListner;

    public MyBottomSheetFragment(List<ItemObject> mListItems, IClickListner iClickListner) {
        this.mListItems = mListItems;
        this.iClickListner = iClickListner;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog =(BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet,null);
        bottomSheetDialog.setContentView(view);
        RecyclerView rcvData=view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rcvData.setLayoutManager(linearLayoutManager);
        ItemAdapter itemAdapter=new ItemAdapter(mListItems, new IClickListner() {
            @Override
            public void clickItem(ItemObject itemObject) {
               iClickListner.clickItem(itemObject);
            }
        });
        rcvData.setAdapter(itemAdapter);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);
        return bottomSheetDialog;
    }
}
