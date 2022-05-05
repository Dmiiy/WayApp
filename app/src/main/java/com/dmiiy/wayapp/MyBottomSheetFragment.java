package com.dmiiy.wayapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

private RecyclerView recyclerView;
private List<ItemObject> itemObjects;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog =(BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet,null);
        bottomSheetDialog.setContentView(view);
        recyclerView=view.findViewById(R.id.rcv_data);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        cargarLista();
        //ProgramAdapter programAdapter = new ProgramAdapter(programNameList, programDescriptionList, programImages);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        return bottomSheetDialog;
    }

    private void cargarLista() {
        itemObjects=new ArrayList<ItemObject>();
        itemObjects.add(new ItemObject("Google","COMPANY",R.drawable.google,"22"));
        itemObjects.add(new ItemObject("C","Language",R.drawable.c,"23"));
        itemObjects.add(new ItemObject("Google","COMPANY",R.drawable.css3,"25"));
        itemObjects.add(new ItemObject("Google","COMPANY",R.drawable.github,"31"));
        ProgramAdapter programAdapter = new ProgramAdapter(itemObjects);
        recyclerView.setAdapter(programAdapter);
    }

}
