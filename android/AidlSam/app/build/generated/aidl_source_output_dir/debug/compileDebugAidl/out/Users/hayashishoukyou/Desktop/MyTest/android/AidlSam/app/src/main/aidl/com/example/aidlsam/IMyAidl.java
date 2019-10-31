/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.aidlsam;
public interface IMyAidl extends android.os.IInterface
{
  /** Default implementation for IMyAidl. */
  public static class Default implements com.example.aidlsam.IMyAidl
  {
    /**
         * 除了基本数据类型，其他类型的参数都需要标上方向类型：in(输入), out(输出), inout(输入输出)
         */
    @Override public void addPerson(com.example.aidlsam.bean.Person person) throws android.os.RemoteException
    {
    }
    @Override public java.util.List<com.example.aidlsam.bean.Person> getPersonList() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.aidlsam.IMyAidl
  {
    private static final java.lang.String DESCRIPTOR = "com.example.aidlsam.IMyAidl";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.aidlsam.IMyAidl interface,
     * generating a proxy if needed.
     */
    public static com.example.aidlsam.IMyAidl asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.aidlsam.IMyAidl))) {
        return ((com.example.aidlsam.IMyAidl)iin);
      }
      return new com.example.aidlsam.IMyAidl.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_addPerson:
        {
          data.enforceInterface(descriptor);
          com.example.aidlsam.bean.Person _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.aidlsam.bean.Person.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.addPerson(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_getPersonList:
        {
          data.enforceInterface(descriptor);
          java.util.List<com.example.aidlsam.bean.Person> _result = this.getPersonList();
          reply.writeNoException();
          reply.writeTypedList(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.aidlsam.IMyAidl
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * 除了基本数据类型，其他类型的参数都需要标上方向类型：in(输入), out(输出), inout(输入输出)
           */
      @Override public void addPerson(com.example.aidlsam.bean.Person person) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((person!=null)) {
            _data.writeInt(1);
            person.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_addPerson, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().addPerson(person);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public java.util.List<com.example.aidlsam.bean.Person> getPersonList() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<com.example.aidlsam.bean.Person> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getPersonList, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getPersonList();
          }
          _reply.readException();
          _result = _reply.createTypedArrayList(com.example.aidlsam.bean.Person.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.aidlsam.IMyAidl sDefaultImpl;
    }
    static final int TRANSACTION_addPerson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getPersonList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(com.example.aidlsam.IMyAidl impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.example.aidlsam.IMyAidl getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * 除了基本数据类型，其他类型的参数都需要标上方向类型：in(输入), out(输出), inout(输入输出)
       */
  public void addPerson(com.example.aidlsam.bean.Person person) throws android.os.RemoteException;
  public java.util.List<com.example.aidlsam.bean.Person> getPersonList() throws android.os.RemoteException;
}
