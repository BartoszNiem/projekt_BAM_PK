package com.example.projekt_bam;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __updateAdapterOfUserEntity;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`email`,`password`,`password_IV`,`first_name`,`last_name`,`pesel`,`pesel_IV`,`address`,`address_IV`,`id_number`,`id_nubmer_IV`,`phone_number`,`phone_number_IV`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getPasswordIV() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindBlob(4, value.getPasswordIV());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLastName());
        }
        if (value.getPesel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPesel());
        }
        if (value.getPeselIV() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getPeselIV());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAddress());
        }
        if (value.getAddressIV() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindBlob(10, value.getAddressIV());
        }
        if (value.getIdNumber() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getIdNumber());
        }
        if (value.getIdNumberIV() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindBlob(12, value.getIdNumberIV());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhoneNumber());
        }
        if (value.getPhoneNumberIV() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindBlob(14, value.getPhoneNumberIV());
        }
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`email` = ?,`password` = ?,`password_IV` = ?,`first_name` = ?,`last_name` = ?,`pesel` = ?,`pesel_IV` = ?,`address` = ?,`address_IV` = ?,`id_number` = ?,`id_nubmer_IV` = ?,`phone_number` = ?,`phone_number_IV` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getPasswordIV() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindBlob(4, value.getPasswordIV());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLastName());
        }
        if (value.getPesel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPesel());
        }
        if (value.getPeselIV() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getPeselIV());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAddress());
        }
        if (value.getAddressIV() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindBlob(10, value.getAddressIV());
        }
        if (value.getIdNumber() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getIdNumber());
        }
        if (value.getIdNumberIV() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindBlob(12, value.getIdNumberIV());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhoneNumber());
        }
        if (value.getPhoneNumberIV() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindBlob(14, value.getPhoneNumberIV());
        }
        stmt.bindLong(15, value.getId());
      }
    };
  }

  @Override
  public void insertUser(final UserEntity user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserEntity.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final UserEntity user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUserEntity.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public UserEntity getUserByEmail(final String email) {
    final String _sql = "SELECT * FROM users WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPasswordIV = CursorUtil.getColumnIndexOrThrow(_cursor, "password_IV");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfPesel = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel");
      final int _cursorIndexOfPeselIV = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel_IV");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAddressIV = CursorUtil.getColumnIndexOrThrow(_cursor, "address_IV");
      final int _cursorIndexOfIdNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "id_number");
      final int _cursorIndexOfIdNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "id_nubmer_IV");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfPhoneNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number_IV");
      final UserEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpPasswordIV;
        if (_cursor.isNull(_cursorIndexOfPasswordIV)) {
          _tmpPasswordIV = null;
        } else {
          _tmpPasswordIV = _cursor.getBlob(_cursorIndexOfPasswordIV);
        }
        final String _tmpFirstName;
        if (_cursor.isNull(_cursorIndexOfFirstName)) {
          _tmpFirstName = null;
        } else {
          _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        }
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpPesel;
        if (_cursor.isNull(_cursorIndexOfPesel)) {
          _tmpPesel = null;
        } else {
          _tmpPesel = _cursor.getString(_cursorIndexOfPesel);
        }
        final byte[] _tmpPeselIV;
        if (_cursor.isNull(_cursorIndexOfPeselIV)) {
          _tmpPeselIV = null;
        } else {
          _tmpPeselIV = _cursor.getBlob(_cursorIndexOfPeselIV);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final byte[] _tmpAddressIV;
        if (_cursor.isNull(_cursorIndexOfAddressIV)) {
          _tmpAddressIV = null;
        } else {
          _tmpAddressIV = _cursor.getBlob(_cursorIndexOfAddressIV);
        }
        final String _tmpIdNumber;
        if (_cursor.isNull(_cursorIndexOfIdNumber)) {
          _tmpIdNumber = null;
        } else {
          _tmpIdNumber = _cursor.getString(_cursorIndexOfIdNumber);
        }
        final byte[] _tmpIdNumberIV;
        if (_cursor.isNull(_cursorIndexOfIdNumberIV)) {
          _tmpIdNumberIV = null;
        } else {
          _tmpIdNumberIV = _cursor.getBlob(_cursorIndexOfIdNumberIV);
        }
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final byte[] _tmpPhoneNumberIV;
        if (_cursor.isNull(_cursorIndexOfPhoneNumberIV)) {
          _tmpPhoneNumberIV = null;
        } else {
          _tmpPhoneNumberIV = _cursor.getBlob(_cursorIndexOfPhoneNumberIV);
        }
        _result = new UserEntity(_tmpId,_tmpEmail,_tmpPassword,_tmpPasswordIV,_tmpFirstName,_tmpLastName,_tmpPesel,_tmpPeselIV,_tmpAddress,_tmpAddressIV,_tmpIdNumber,_tmpIdNumberIV,_tmpPhoneNumber,_tmpPhoneNumberIV);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserEntity> getAllUsers() {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPasswordIV = CursorUtil.getColumnIndexOrThrow(_cursor, "password_IV");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfPesel = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel");
      final int _cursorIndexOfPeselIV = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel_IV");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAddressIV = CursorUtil.getColumnIndexOrThrow(_cursor, "address_IV");
      final int _cursorIndexOfIdNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "id_number");
      final int _cursorIndexOfIdNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "id_nubmer_IV");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfPhoneNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number_IV");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpPasswordIV;
        if (_cursor.isNull(_cursorIndexOfPasswordIV)) {
          _tmpPasswordIV = null;
        } else {
          _tmpPasswordIV = _cursor.getBlob(_cursorIndexOfPasswordIV);
        }
        final String _tmpFirstName;
        if (_cursor.isNull(_cursorIndexOfFirstName)) {
          _tmpFirstName = null;
        } else {
          _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        }
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpPesel;
        if (_cursor.isNull(_cursorIndexOfPesel)) {
          _tmpPesel = null;
        } else {
          _tmpPesel = _cursor.getString(_cursorIndexOfPesel);
        }
        final byte[] _tmpPeselIV;
        if (_cursor.isNull(_cursorIndexOfPeselIV)) {
          _tmpPeselIV = null;
        } else {
          _tmpPeselIV = _cursor.getBlob(_cursorIndexOfPeselIV);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final byte[] _tmpAddressIV;
        if (_cursor.isNull(_cursorIndexOfAddressIV)) {
          _tmpAddressIV = null;
        } else {
          _tmpAddressIV = _cursor.getBlob(_cursorIndexOfAddressIV);
        }
        final String _tmpIdNumber;
        if (_cursor.isNull(_cursorIndexOfIdNumber)) {
          _tmpIdNumber = null;
        } else {
          _tmpIdNumber = _cursor.getString(_cursorIndexOfIdNumber);
        }
        final byte[] _tmpIdNumberIV;
        if (_cursor.isNull(_cursorIndexOfIdNumberIV)) {
          _tmpIdNumberIV = null;
        } else {
          _tmpIdNumberIV = _cursor.getBlob(_cursorIndexOfIdNumberIV);
        }
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final byte[] _tmpPhoneNumberIV;
        if (_cursor.isNull(_cursorIndexOfPhoneNumberIV)) {
          _tmpPhoneNumberIV = null;
        } else {
          _tmpPhoneNumberIV = _cursor.getBlob(_cursorIndexOfPhoneNumberIV);
        }
        _item = new UserEntity(_tmpId,_tmpEmail,_tmpPassword,_tmpPasswordIV,_tmpFirstName,_tmpLastName,_tmpPesel,_tmpPeselIV,_tmpAddress,_tmpAddressIV,_tmpIdNumber,_tmpIdNumberIV,_tmpPhoneNumber,_tmpPhoneNumberIV);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserEntity getUserByEmailAndPassword(final String email, final String password) {
    final String _sql = "SELECT * FROM users where email = ? and password = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPasswordIV = CursorUtil.getColumnIndexOrThrow(_cursor, "password_IV");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfPesel = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel");
      final int _cursorIndexOfPeselIV = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel_IV");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAddressIV = CursorUtil.getColumnIndexOrThrow(_cursor, "address_IV");
      final int _cursorIndexOfIdNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "id_number");
      final int _cursorIndexOfIdNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "id_nubmer_IV");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfPhoneNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number_IV");
      final UserEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpPasswordIV;
        if (_cursor.isNull(_cursorIndexOfPasswordIV)) {
          _tmpPasswordIV = null;
        } else {
          _tmpPasswordIV = _cursor.getBlob(_cursorIndexOfPasswordIV);
        }
        final String _tmpFirstName;
        if (_cursor.isNull(_cursorIndexOfFirstName)) {
          _tmpFirstName = null;
        } else {
          _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        }
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpPesel;
        if (_cursor.isNull(_cursorIndexOfPesel)) {
          _tmpPesel = null;
        } else {
          _tmpPesel = _cursor.getString(_cursorIndexOfPesel);
        }
        final byte[] _tmpPeselIV;
        if (_cursor.isNull(_cursorIndexOfPeselIV)) {
          _tmpPeselIV = null;
        } else {
          _tmpPeselIV = _cursor.getBlob(_cursorIndexOfPeselIV);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final byte[] _tmpAddressIV;
        if (_cursor.isNull(_cursorIndexOfAddressIV)) {
          _tmpAddressIV = null;
        } else {
          _tmpAddressIV = _cursor.getBlob(_cursorIndexOfAddressIV);
        }
        final String _tmpIdNumber;
        if (_cursor.isNull(_cursorIndexOfIdNumber)) {
          _tmpIdNumber = null;
        } else {
          _tmpIdNumber = _cursor.getString(_cursorIndexOfIdNumber);
        }
        final byte[] _tmpIdNumberIV;
        if (_cursor.isNull(_cursorIndexOfIdNumberIV)) {
          _tmpIdNumberIV = null;
        } else {
          _tmpIdNumberIV = _cursor.getBlob(_cursorIndexOfIdNumberIV);
        }
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final byte[] _tmpPhoneNumberIV;
        if (_cursor.isNull(_cursorIndexOfPhoneNumberIV)) {
          _tmpPhoneNumberIV = null;
        } else {
          _tmpPhoneNumberIV = _cursor.getBlob(_cursorIndexOfPhoneNumberIV);
        }
        _result = new UserEntity(_tmpId,_tmpEmail,_tmpPassword,_tmpPasswordIV,_tmpFirstName,_tmpLastName,_tmpPesel,_tmpPeselIV,_tmpAddress,_tmpAddressIV,_tmpIdNumber,_tmpIdNumberIV,_tmpPhoneNumber,_tmpPhoneNumberIV);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserEntity getUserById(final long userId) {
    final String _sql = "SELECT * FROM users WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPasswordIV = CursorUtil.getColumnIndexOrThrow(_cursor, "password_IV");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfPesel = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel");
      final int _cursorIndexOfPeselIV = CursorUtil.getColumnIndexOrThrow(_cursor, "pesel_IV");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAddressIV = CursorUtil.getColumnIndexOrThrow(_cursor, "address_IV");
      final int _cursorIndexOfIdNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "id_number");
      final int _cursorIndexOfIdNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "id_nubmer_IV");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfPhoneNumberIV = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number_IV");
      final UserEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpPasswordIV;
        if (_cursor.isNull(_cursorIndexOfPasswordIV)) {
          _tmpPasswordIV = null;
        } else {
          _tmpPasswordIV = _cursor.getBlob(_cursorIndexOfPasswordIV);
        }
        final String _tmpFirstName;
        if (_cursor.isNull(_cursorIndexOfFirstName)) {
          _tmpFirstName = null;
        } else {
          _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        }
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpPesel;
        if (_cursor.isNull(_cursorIndexOfPesel)) {
          _tmpPesel = null;
        } else {
          _tmpPesel = _cursor.getString(_cursorIndexOfPesel);
        }
        final byte[] _tmpPeselIV;
        if (_cursor.isNull(_cursorIndexOfPeselIV)) {
          _tmpPeselIV = null;
        } else {
          _tmpPeselIV = _cursor.getBlob(_cursorIndexOfPeselIV);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final byte[] _tmpAddressIV;
        if (_cursor.isNull(_cursorIndexOfAddressIV)) {
          _tmpAddressIV = null;
        } else {
          _tmpAddressIV = _cursor.getBlob(_cursorIndexOfAddressIV);
        }
        final String _tmpIdNumber;
        if (_cursor.isNull(_cursorIndexOfIdNumber)) {
          _tmpIdNumber = null;
        } else {
          _tmpIdNumber = _cursor.getString(_cursorIndexOfIdNumber);
        }
        final byte[] _tmpIdNumberIV;
        if (_cursor.isNull(_cursorIndexOfIdNumberIV)) {
          _tmpIdNumberIV = null;
        } else {
          _tmpIdNumberIV = _cursor.getBlob(_cursorIndexOfIdNumberIV);
        }
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final byte[] _tmpPhoneNumberIV;
        if (_cursor.isNull(_cursorIndexOfPhoneNumberIV)) {
          _tmpPhoneNumberIV = null;
        } else {
          _tmpPhoneNumberIV = _cursor.getBlob(_cursorIndexOfPhoneNumberIV);
        }
        _result = new UserEntity(_tmpId,_tmpEmail,_tmpPassword,_tmpPasswordIV,_tmpFirstName,_tmpLastName,_tmpPesel,_tmpPeselIV,_tmpAddress,_tmpAddressIV,_tmpIdNumber,_tmpIdNumberIV,_tmpPhoneNumber,_tmpPhoneNumberIV);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
