package com.twentyfour.chavel.activity.LoginRegister;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.twentyfour.chavel.R;
import com.twentyfour.chavel.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class SettingsAddPhotoActivity extends BaseActivity {
//    EZPhotoPickStorage ezPhotoPickStorage;
//    Bitmap bitmap;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.add_camera)
    ImageView add_camera;

    @Bind(R.id.add_photo_btn)
    TextView add_photo_btn;

    @Bind(R.id.add_photo)
    CircleImageView add_photo;

    @OnClick(R.id.add_photo_btn)
    void next(View view) {
        if (view.getId() == R.id.action_skip) {
            Toast.makeText(this, "Skiped", Toast.LENGTH_SHORT).show();

        } else if(view.getId() == R.id.add_photo_btn) {
            Toast.makeText(this, "Photo uploaded", Toast.LENGTH_SHORT).show();
        }
        toMainTab();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_photo);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorTitle));
        toolbar.setBackgroundColor(getResources().getColor(R.color.whitePrimary));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsAddPhotoActivity.this);
                builder.setMessage("Picture")
                        .setPositiveButton("GALLERY", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Share
                                chooseImage();
                            }
                        })
                        .setNegativeButton("CAMERA", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Cancel
                                chooseCamera();
                            }
                        });
                builder.show();
            }
        });

        add_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsAddPhotoActivity.this);
                builder.setMessage("Picture")
                        .setPositiveButton("GALLERY", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Share
                                chooseImage();
                            }
                        })
                        .setNegativeButton("CAMERA", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Cancel
                                chooseCamera();
                            }
                        });
                builder.show();
            }
        });

    }

    private void chooseImage() {
        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.GALLERY;
        config.exportingSize = 900;
        EZPhotoPick.startPhotoPickActivity(this, config);
    }

    private void chooseCamera() {
        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.CAMERA;
        config.exportingSize = 900;
        EZPhotoPick.startPhotoPickActivity(this, config);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == EZPhotoPick.PHOTO_PICK_GALLERY_REQUEST_CODE &&
                resultCode == RESULT_OK) {
            try {
                Bitmap pickedPhoto = new EZPhotoPickStorage(this).loadLatestStoredPhotoBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                pickedPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);

                Glide.with(getApplicationContext())
                        .load(stream.toByteArray())
                        .crossFade()
                        .into(add_photo);

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        if (requestCode == EZPhotoPick.PHOTO_PICK_CAMERA_REQUEST_CODE &&
                resultCode == RESULT_OK) {
            try {
                Bitmap pickedCamera = new EZPhotoPickStorage(this).loadLatestStoredPhotoBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                pickedCamera.compress(Bitmap.CompressFormat.PNG, 100, stream);

                Glide.with(getApplicationContext())
                        .load(stream.toByteArray())
                        .crossFade()
                        .into(add_photo);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_skip, menu);
        //menu.getItem(0).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_skip: {
                toMainTab();
                break;
            }
            // case blocks for other MenuItems (if any)
        }
        return false;
    }
}
