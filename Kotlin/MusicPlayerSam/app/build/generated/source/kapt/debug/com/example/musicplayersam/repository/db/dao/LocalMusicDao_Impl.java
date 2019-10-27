package com.example.musicplayersam.repository.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.musicplayersam.repository.db.entity.LocalMusic;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class LocalMusicDao_Impl extends LocalMusicDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLocalMusic;

  public LocalMusicDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalMusic = new EntityInsertionAdapter<LocalMusic>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `local_music`(`id`,`fileUri`,`title`,`albumString`,`artistString`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalMusic value) {
        stmt.bindLong(1, value.getId());
        if (value.getFileUri() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFileUri());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getAlbumString() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAlbumString());
        }
        if (value.getArtistString() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getArtistString());
        }
      }
    };
  }

  @Override
  public long insertMusic(LocalMusic music) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfLocalMusic.insertAndReturnId(music);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<LocalMusic>> getAllMusics() {
    final String _sql = "select * from local_music";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<LocalMusic>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<LocalMusic> compute() {
        if (_observer == null) {
          _observer = new Observer("local_music") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfFileUri = _cursor.getColumnIndexOrThrow("fileUri");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfAlbumString = _cursor.getColumnIndexOrThrow("albumString");
          final int _cursorIndexOfArtistString = _cursor.getColumnIndexOrThrow("artistString");
          final List<LocalMusic> _result = new ArrayList<LocalMusic>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalMusic _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFileUri;
            _tmpFileUri = _cursor.getString(_cursorIndexOfFileUri);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpAlbumString;
            _tmpAlbumString = _cursor.getString(_cursorIndexOfAlbumString);
            final String _tmpArtistString;
            _tmpArtistString = _cursor.getString(_cursorIndexOfArtistString);
            _item = new LocalMusic(_tmpId,_tmpFileUri,_tmpTitle,_tmpAlbumString,_tmpArtistString);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<LocalMusic>> getMusicsByArtist(String artist) {
    final String _sql = "select * from local_music where artistString = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (artist == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, artist);
    }
    return new ComputableLiveData<List<LocalMusic>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<LocalMusic> compute() {
        if (_observer == null) {
          _observer = new Observer("local_music") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfFileUri = _cursor.getColumnIndexOrThrow("fileUri");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfAlbumString = _cursor.getColumnIndexOrThrow("albumString");
          final int _cursorIndexOfArtistString = _cursor.getColumnIndexOrThrow("artistString");
          final List<LocalMusic> _result = new ArrayList<LocalMusic>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalMusic _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFileUri;
            _tmpFileUri = _cursor.getString(_cursorIndexOfFileUri);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpAlbumString;
            _tmpAlbumString = _cursor.getString(_cursorIndexOfAlbumString);
            final String _tmpArtistString;
            _tmpArtistString = _cursor.getString(_cursorIndexOfArtistString);
            _item = new LocalMusic(_tmpId,_tmpFileUri,_tmpTitle,_tmpAlbumString,_tmpArtistString);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<LocalMusic>> getMusicsByAlbum(String album) {
    final String _sql = "select * from local_music where albumString = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (album == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, album);
    }
    return new ComputableLiveData<List<LocalMusic>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<LocalMusic> compute() {
        if (_observer == null) {
          _observer = new Observer("local_music") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfFileUri = _cursor.getColumnIndexOrThrow("fileUri");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfAlbumString = _cursor.getColumnIndexOrThrow("albumString");
          final int _cursorIndexOfArtistString = _cursor.getColumnIndexOrThrow("artistString");
          final List<LocalMusic> _result = new ArrayList<LocalMusic>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalMusic _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFileUri;
            _tmpFileUri = _cursor.getString(_cursorIndexOfFileUri);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpAlbumString;
            _tmpAlbumString = _cursor.getString(_cursorIndexOfAlbumString);
            final String _tmpArtistString;
            _tmpArtistString = _cursor.getString(_cursorIndexOfArtistString);
            _item = new LocalMusic(_tmpId,_tmpFileUri,_tmpTitle,_tmpAlbumString,_tmpArtistString);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
