package com.twentyfour.chavel.activity.MainTab;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.Bind;

import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

import static android.app.Activity.RESULT_OK;


public class AddPinFragment extends Fragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    ImageView btn_expand_toggle;
    private ExpandableLayout expandableLayout0;
    private ExpandableLayout expandableLayout1;


    ImageView img_next;
    LinearLayout ls_map;
    ImageButton btnEditPinImage;


    public static AddPinFragment newInstance() {
        return new AddPinFragment();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_pin_activity, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        img_next = (ImageView) rootView.findViewById(R.id.img_next);
        expandableLayout0 = (ExpandableLayout) rootView.findViewById(R.id.expandable_layout_0);
        expandableLayout1 = (ExpandableLayout) rootView.findViewById(R.id.expandable_layout_1);
        btn_expand_toggle = (ImageView) rootView.findViewById(R.id.btn_expand_toggle);
        ls_map = (LinearLayout) rootView.findViewById(R.id.ls_map);
        btnEditPinImage = (ImageButton) rootView.findViewById(R.id.btnEditPinImage);

        toolbar.setTitle("Add Pin");
        //  setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableLayout0.isExpanded()) {
                    expandableLayout0.collapse();
                    btn_expand_toggle.setImageResource(R.drawable.down_icon);
                } else {
                    expandableLayout0.expand();
                    btn_expand_toggle.setImageResource(R.drawable.up_icon);

                }
            }
        });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditPinFragment editPinActivity = new EditPinFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container8, editPinActivity);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnEditPinImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogOne();
            }
        });

        return rootView;
    }

    private void showAlertDialogOne() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setMessage("เลือกรูปภาพ")
                .setPositiveButton("แกลอรี่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do something on Share
                        chooseImage();
                    }
                })
                .setNegativeButton("กล้อง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do something on Cancel
                        chooseCamera();
                    }
                });
        builder.show();
    }


    public void chooseImage() {
        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.GALLERY;
        config.exportingSize = 900;
        EZPhotoPick.startPhotoPickActivity(getActivity(), config);
    }

    public void chooseCamera() {
        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.CAMERA;
        config.exportingSize = 900;
        EZPhotoPick.startPhotoPickActivity(getActivity(), config);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }


        if (requestCode == EZPhotoPick.PHOTO_PICK_GALLERY_REQUEST_CODE &&
                resultCode == RESULT_OK) {
            try {
                Bitmap pickedPhoto = new EZPhotoPickStorage(getActivity()).loadLatestStoredPhotoBitmap();
                btnEditPinImage.setImageBitmap(pickedPhoto);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                pickedPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);



            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        if (requestCode == EZPhotoPick.PHOTO_PICK_CAMERA_REQUEST_CODE &&
                resultCode == RESULT_OK) {
            try {
                Bitmap pickedCamera = new EZPhotoPickStorage(getActivity()).loadLatestStoredPhotoBitmap();
                btnEditPinImage.setImageBitmap(pickedCamera);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                pickedCamera.compress(Bitmap.CompressFormat.PNG, 100, stream);


            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add_pin_activity);
//        ButterKnife.bind(this);
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_phone_email, menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//    }

}
