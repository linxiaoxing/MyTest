package com.example.musicplayersam.repository.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.musicplayersam.repository.db.dao.KeyValueDao;
import com.example.musicplayersam.repository.db.dao.KeyValueDao_Impl;
import com.example.musicplayersam.repository.db.dao.LocalMusicDao;
import com.example.musicplayersam.repository.db.dao.LocalMusicDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class QuietDatabase_Impl extends QuietDatabase {
  private volatile LocalMusicDao _localMusicDao;

  private volatile KeyValueDao _keyValueDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `local_music` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fileUri` TEXT NOT NULL, `title` TEXT, `albumString` TEXT NOT NULL, `artistString` TEXT NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX `index_local_music_fileUri` ON `local_music` (`fileUri`)");
        _db.execSQL("CREATE  INDEX `index_local_music_albumString` ON `local_music` (`albumString`)");
        _db.execSQL("CREATE  INDEX `index_local_music_artistString` ON `local_music` (`artistString`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `objects` (`key` TEXT NOT NULL, `data` TEXT NOT NULL, PRIMARY KEY(`key`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"d552641335e3ceb33e86f88207172282\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `local_music`");
        _db.execSQL("DROP TABLE IF EXISTS `objects`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLocalMusic = new HashMap<String, TableInfo.Column>(5);
        _columnsLocalMusic.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsLocalMusic.put("fileUri", new TableInfo.Column("fileUri", "TEXT", true, 0));
        _columnsLocalMusic.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsLocalMusic.put("albumString", new TableInfo.Column("albumString", "TEXT", true, 0));
        _columnsLocalMusic.put("artistString", new TableInfo.Column("artistString", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocalMusic = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocalMusic = new HashSet<TableInfo.Index>(3);
        _indicesLocalMusic.add(new TableInfo.Index("index_local_music_fileUri", true, Arrays.asList("fileUri")));
        _indicesLocalMusic.add(new TableInfo.Index("index_local_music_albumString", false, Arrays.asList("albumString")));
        _indicesLocalMusic.add(new TableInfo.Index("index_local_music_artistString", false, Arrays.asList("artistString")));
        final TableInfo _infoLocalMusic = new TableInfo("local_music", _columnsLocalMusic, _foreignKeysLocalMusic, _indicesLocalMusic);
        final TableInfo _existingLocalMusic = TableInfo.read(_db, "local_music");
        if (! _infoLocalMusic.equals(_existingLocalMusic)) {
          throw new IllegalStateException("Migration didn't properly handle local_music(com.example.musicplayersam.repository.db.entity.LocalMusic).\n"
                  + " Expected:\n" + _infoLocalMusic + "\n"
                  + " Found:\n" + _existingLocalMusic);
        }
        final HashMap<String, TableInfo.Column> _columnsObjects = new HashMap<String, TableInfo.Column>(2);
        _columnsObjects.put("key", new TableInfo.Column("key", "TEXT", true, 1));
        _columnsObjects.put("data", new TableInfo.Column("data", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysObjects = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesObjects = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoObjects = new TableInfo("objects", _columnsObjects, _foreignKeysObjects, _indicesObjects);
        final TableInfo _existingObjects = TableInfo.read(_db, "objects");
        if (! _infoObjects.equals(_existingObjects)) {
          throw new IllegalStateException("Migration didn't properly handle objects(com.example.musicplayersam.repository.db.entity.KeyValueEntity).\n"
                  + " Expected:\n" + _infoObjects + "\n"
                  + " Found:\n" + _existingObjects);
        }
      }
    }, "d552641335e3ceb33e86f88207172282", "14fc0e43ae51ff71516348b589bd190a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "local_music","objects");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `local_music`");
      _db.execSQL("DELETE FROM `objects`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public LocalMusicDao localMusicDao() {
    if (_localMusicDao != null) {
      return _localMusicDao;
    } else {
      synchronized(this) {
        if(_localMusicDao == null) {
          _localMusicDao = new LocalMusicDao_Impl(this);
        }
        return _localMusicDao;
      }
    }
  }

  @Override
  public KeyValueDao keyValueDao() {
    if (_keyValueDao != null) {
      return _keyValueDao;
    } else {
      synchronized(this) {
        if(_keyValueDao == null) {
          _keyValueDao = new KeyValueDao_Impl(this);
        }
        return _keyValueDao;
      }
    }
  }
}
