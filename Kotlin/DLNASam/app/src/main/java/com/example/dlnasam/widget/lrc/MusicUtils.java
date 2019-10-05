package com.example.dlnasam.widget.lrc;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.didi365.dlnasupport.util.CommonLog;
import com.didi365.dlnasupport.util.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MusicUtils {

    private static final CommonLog log = LogFactory.createLog();

    private static final String TAG = "MusicUtils";

    private static final String LYRICS_DIR = "/geniusgithub/lyrics";

    public static String getLyricDir() {
        File file = Environment.getExternalStorageDirectory();
        if (file == null) {
            return null;
        }
        File f = new File(file.getAbsolutePath() + LYRICS_DIR);
        if (!f.exists()) {
            f.mkdirs();
        }

        return f.getAbsolutePath();
    }

    public static String createLyricName(String song, String artist) {
        StringBuilder sb = new StringBuilder();
        if (artist != null && artist.length() > 0
                && !MediaStore.UNKNOWN_STRING.equals(artist)) {
            sb.append(artist);
            sb.append(" - ");
        }
        sb.append(song);
        sb.append(".lrc");
        return sb.toString();
    }

    public static String getLyricFile(String song, String artist) {
        String lyricDir = getLyricDir();
        log.e("getLyricDir = " + getLyricDir());
        if (lyricDir == null) {
            return null;
        }
        return getLyricDir() + "/" + createLyricName(song, artist);
    }

    public static boolean saveFile(String filePath, InputStream inputStream)
            throws IOException {
        boolean result = false;
        if (filePath != null && inputStream != null) {
            Log.d(TAG, "filePath:" + filePath);
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                FileOutputStream fos = new FileOutputStream(
                        file.getAbsolutePath());
                byte[] buf = new byte[1024];
                int size = 0;
                while ((size = inputStream.read(buf, 0, 1024)) != -1) {
                    fos.write(buf, 0, size);
                }

                fos.flush();
                fos.close();
                inputStream.close();
                result = true;
            }
        }
        return result;
    }

    public static boolean saveFile(String filePath, String str)
            throws IOException {
        boolean result = false;
        if (filePath != null && str != null) {
            Log.d(TAG, "filePath:" + filePath);
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                FileOutputStream fos = new FileOutputStream(
                        file.getAbsolutePath());
                fos.write(str.getBytes("gb18030"));
                fos.flush();
                fos.close();
                result = true;
            }
        }
        return result;
    }
}