package com.example.musicplayersam.repository.db.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.musicplayersam.repository.db.entity.KeyValueEntity;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class KeyValueDao_Impl extends KeyValueDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKeyValueEntity;

  public KeyValueDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKeyValueEntity = new EntityInsertionAdapter<KeyValueEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `objects`(`key`,`data`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KeyValueEntity value) {
        if (value.getKey() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKey());
        }
        if (value.getData() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getData());
        }
      }
    };
  }

  @Override
  protected void insert(KeyValueEntity objectWrapperEntity) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKeyValueEntity.insert(objectWrapperEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected KeyValueEntity findEntity(String key) {
    final String _sql = "select * from objects where `key` == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfKey = _cursor.getColumnIndexOrThrow("key");
      final int _cursorIndexOfData = _cursor.getColumnIndexOrThrow("data");
      final KeyValueEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfKey);
        final String _tmpData;
        _tmpData = _cursor.getString(_cursorIndexOfData);
        _result = new KeyValueEntity(_tmpKey,_tmpData);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
