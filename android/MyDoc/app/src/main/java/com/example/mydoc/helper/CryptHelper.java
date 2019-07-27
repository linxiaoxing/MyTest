package com.example.mydoc.helper;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.example.mydoc.MyDocApplication;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CryptHelper {

    private final static String TAG = "CryptHelper";
    public  static final String BASIC_ALGORITHM = "AES";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM_SECRETKEY = "AES/CBC/PKCS7Padding";

    private MyDocApplication app;

    private byte[] deviceIdByte = new byte[32];

    public CryptHelper(final Context context) {
        TelephonyManager telephonyManager =
                (TelephonyManager) context.
                        getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            String deviceId = "";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String permission = Manifest.permission.READ_PHONE_STATE;
                int result = context.checkSelfPermission(permission);
                if (result == PackageManager.PERMISSION_GRANTED) {
                    deviceId = telephonyManager.getDeviceId();
                }
            } else {
                deviceId = telephonyManager.getDeviceId();
            }


            if (deviceId != null && deviceId.length() > 0) {
                for (int i = 0; i < deviceIdByte.length; i++) {
                    deviceIdByte[i] ^=
                            (byte) deviceId.charAt(i % deviceId.length());
                }
            } else {
                for (int i = 0; i < deviceIdByte.length; i++) {
                    deviceIdByte[i] = 0x00;
                }
            }
        }

        app = (MyDocApplication) context.getApplicationContext();
    }

    /**
     * アプリ内鍵で指定した文字列を暗号化.
     * @param data 暗号化する文字列
     * @return 暗号化したデータ
     */
    public final byte[] encode(final String data) {
        String targetData = data;
        if (targetData == null) {
            targetData = "";
        }
        return encodeByKey(targetData.getBytes(), getKey());
    }

    /**
     * 指定した鍵でバイナリを暗号化.
     * @param data 暗号化するデータ
     * @param secretKey 暗号化鍵(SecretKey)
     * @return 暗号化したデータ
     */
    public final byte[] encodeByKey(final byte[] data, final SecretKey secretKey) {
        if (secretKey == null) {
            return null;
        }

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM_SECRETKEY);

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] iv = cipher.getIV();
            byte[] encryptedData = cipher.doFinal(data);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.write(iv);
            dos.write(encryptedData);
            return baos.toByteArray();

        } catch (GeneralSecurityException e) {
        } catch (IOException e) {
        } catch (IllegalArgumentException e) {
        }

        return null;
    }

    /**
     * アプリ内鍵で暗号化済みバイナリを文字列として復号化.
     * @param data 暗号化済みデータ
     * @return 復号化した文字列
     */
    public final String decode(final byte[] data) {
        if (data == null) {
            return "";
        }
        byte[] ret = decodeByKey(data, getKey());
        if (ret == null) {
            return null;
        }

        return new String(ret);
    }

    /**
     * アプリ内鍵で暗号化済みバイナリを整数として復号化.
     * @param data 暗号化済みデータ
     * @return 復号化した整数
     */
    public final Integer decodeToInt(final byte[] data) {
        if (data == null) {
            return null;
        }
        byte[] ret = decodeByKey(data, getKey());
        if (ret == null) {
            return null;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(ret);
        DataInputStream dis = new DataInputStream(bais);

        Integer retInt = null;
        try {
            retInt = dis.readInt();
        } catch (IOException e) {
        }

        return retInt;
    }

    /**
     * アプリ内鍵で暗号化済みバイナリをbyte配列として復号化.
     * @param data 暗号化済みデータ
     * @return 復号化したbyte配列
     */
    public final byte[] decodeToByte(final byte[] data) {
        if (data == null) {
            return null;
        }
        byte[] ret = decodeByKey(data, getKey());
        if (ret == null) {
            return null;
        }
        return ret;
    }

    /**
     * 指定した鍵で暗号化済みバイナリをbyte配列として復号化.
     * @param data 暗号化済みデータa
     * @param secretKey 複合化鍵
     * @return 復号化したデータ
     */
    public final byte[] decodeByKey(final byte[] data, final SecretKey secretKey) {
        if (secretKey == null) {
            return null;
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM_SECRETKEY);

            final int blockSize = cipher.getBlockSize();

            byte[] iv = new byte[blockSize];
            dis.read(iv);

            byte[] encryptedData = new byte[data.length - blockSize];
            dis.read(encryptedData);


            cipher.init(Cipher.DECRYPT_MODE, secretKey,
                    new IvParameterSpec(iv));
            byte[] decodedData = cipher.doFinal(encryptedData);

            return decodedData;
        } catch (GeneralSecurityException e) {
        } catch (IOException e) {
        } catch (NegativeArraySizeException e) {
        } catch (IllegalArgumentException e) {
        }

        return null;
    }

    /**
     * アプリ内鍵を取得.
     * @return アプリ内鍵
     */
    private SecretKey getKey() {
        final byte[] seed = {
                (byte) 0x40, (byte) 0x35, (byte) 0xFF, (byte) 0x32, (byte) 0x64,
                (byte) 0xA4, (byte) 0x10, (byte) 0x53, (byte) 0x54, (byte) 0x65,
                (byte) 0x90, (byte) 0xAB, (byte) 0x9F, (byte) 0xCC, (byte) 0x95,
                (byte) 0x03, (byte) 0x74, (byte) 0x4A, (byte) 0x8B, (byte) 0x73,
                (byte) 0xCF, (byte) 0x87, (byte) 0xD7, (byte) 0x0C, (byte) 0xB1,
                (byte) 0x63, (byte) 0x96, (byte) 0xDC, (byte) 0x3C, (byte) 0x68,
                (byte) 0x8C, (byte) 0xF0};

        final byte[] seed2 = ALGORITHM.getBytes();

        byte[] key = new byte[32];

        for (int i = 0; i < key.length; i++) {
            key[i] = (byte)
                    (seed[i] ^ seed2[i % seed2.length] ^ deviceIdByte[i]);
        }

        byte[] trueKey;

        try {
            if (app.getKey() == null) {
                // 内部用の鍵を生成
                SecureRandom random;
                random = new SecureRandom();
                KeyGenerator keyGenerator =
                        KeyGenerator.getInstance(BASIC_ALGORITHM);
                keyGenerator.init(256, random);

                trueKey = keyGenerator.generateKey().getEncoded();
                app.setKey(encodeByKey(trueKey, new SecretKeySpec(key, BASIC_ALGORITHM)));
            } else {
                trueKey = decodeByKey(app.getKey(), new SecretKeySpec(key, BASIC_ALGORITHM));
            }
        } catch (NoSuchAlgorithmException e) {
            trueKey = key;
        }

        try {
            return new SecretKeySpec(trueKey, BASIC_ALGORITHM);
        } catch (IllegalArgumentException e) {
        }
        return null;
    }
}

