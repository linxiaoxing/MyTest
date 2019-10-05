package com.example.camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

        private ImageView ivTest;

        private File cameraSavePath;//������Ƭ·��
        private Uri uri;
        private String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btnGetPicFromCamera = findViewById(R.id.btn_get_pic_from_camera);
            Button btnGetPicFromPhotoAlbum = findViewById(R.id.btn_get_pic_form_photo_album);
            Button btnGetPermission = findViewById(R.id.btn_get_Permission);
            ivTest = findViewById(R.id.iv_test);

            btnGetPicFromCamera.setOnClickListener(this);
            btnGetPicFromPhotoAlbum.setOnClickListener(this);
            btnGetPermission.setOnClickListener(this);

            cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btn_get_pic_from_camera:
                    goCamera();
                    break;
                case R.id.btn_get_pic_form_photo_album:
                    goPhotoAlbum();
                    break;
                case R.id.btn_get_Permission:
                    getPermission();
                    break;
            }
        }

        //��ȡȨ��
        private void getPermission() {
            if (EasyPermissions.hasPermissions(this, permissions)) {
                //�Ѿ���Ȩ��
                Toast.makeText(this, "�Ѿ��������Ȩ��", Toast.LENGTH_SHORT).show();
            } else {
                //û�д����Ȩ�ޡ�����Ȩ��
                EasyPermissions.requestPermissions(this, "��Ҫ��ȡ������ᡢ����ʹ��Ȩ��", 1, permissions);
            }

        }


        //����������
        private void goPhotoAlbum() {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 2);
        }

        //�����������
        private void goCamera() {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                uri = FileProvider.getUriForFile(MainActivity.this, "com.example.hxd.pictest.fileprovider", cameraSavePath);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                uri = Uri.fromFile(cameraSavePath);
            }
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            MainActivity.this.startActivityForResult(intent, 1);
        }


        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            //���Ҫ�������ôд
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        }


        //�ɹ���Ȩ��
        @Override
        public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

            Toast.makeText(this, "���Ȩ�޻�ȡ�ɹ�", Toast.LENGTH_SHORT).show();
        }
        //�û�δͬ��Ȩ��
        @Override
        public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
            Toast.makeText(this, "��ͬ�����Ȩ�ޣ��������޷�ʹ��", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            String photoPath;
            if (requestCode == 1 && resultCode == RESULT_OK) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    photoPath = String.valueOf(cameraSavePath);
                } else {
                    photoPath = uri.getEncodedPath();
                }
                Log.d("���շ���ͼƬ·��:", photoPath);
                Glide.with(MainActivity.this).load(photoPath).into(ivTest);
            } else if (requestCode == 2 && resultCode == RESULT_OK) {
                photoPath = getPhotoFromPhotoAlbum.getRealPathFromUri(this, data.getData());
                Glide.with(MainActivity.this).load(photoPath).into(ivTest);
            }

            super.onActivityResult(requestCode, resultCode, data);
        }


    }
