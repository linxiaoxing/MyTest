/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.aidl.gsygithubappkotlin;
public interface ILocalMessage extends android.os.IInterface
{
  /** Default implementation for ILocalMessage. */
  public static class Default implements com.aidl.gsygithubappkotlin.ILocalMessage
  {
    @Override public void sendMessage(java.lang.String message) throws android.os.RemoteException
    {
    }
    @Override public int getVersion() throws android.os.RemoteException
    {
      return 0;
    }
    @Override public void registerCallBack(com.aidl.gsygithubappkotlin.ILocalMessageCallBack callback) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.aidl.gsygithubappkotlin.ILocalMessage
  {
    private static final java.lang.String DESCRIPTOR = "com.aidl.gsygithubappkotlin.ILocalMessage";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.aidl.gsygithubappkotlin.ILocalMessage interface,
     * generating a proxy if needed.
     */
    public static com.aidl.gsygithubappkotlin.ILocalMessage asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.aidl.gsygithubappkotlin.ILocalMessage))) {
        return ((com.aidl.gsygithubappkotlin.ILocalMessage)iin);
      }
      return new com.aidl.gsygithubappkotlin.ILocalMessage.Stub.Proxy(obj);
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
        case TRANSACTION_sendMessage:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.sendMessage(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_getVersion:
        {
          data.enforceInterface(descriptor);
          int _result = this.getVersion();
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        case TRANSACTION_registerCallBack:
        {
          data.enforceInterface(descriptor);
          com.aidl.gsygithubappkotlin.ILocalMessageCallBack _arg0;
          _arg0 = com.aidl.gsygithubappkotlin.ILocalMessageCallBack.Stub.asInterface(data.readStrongBinder());
          this.registerCallBack(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.aidl.gsygithubappkotlin.ILocalMessage
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
      @Override public void sendMessage(java.lang.String message) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(message);
          boolean _status = mRemote.transact(Stub.TRANSACTION_sendMessage, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().sendMessage(message);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public int getVersion() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getVersion, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getVersion();
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void registerCallBack(com.aidl.gsygithubappkotlin.ILocalMessageCallBack callback) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_registerCallBack, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().registerCallBack(callback);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static com.aidl.gsygithubappkotlin.ILocalMessage sDefaultImpl;
    }
    static final int TRANSACTION_sendMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_registerCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static boolean setDefaultImpl(com.aidl.gsygithubappkotlin.ILocalMessage impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.aidl.gsygithubappkotlin.ILocalMessage getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void sendMessage(java.lang.String message) throws android.os.RemoteException;
  public int getVersion() throws android.os.RemoteException;
  public void registerCallBack(com.aidl.gsygithubappkotlin.ILocalMessageCallBack callback) throws android.os.RemoteException;
}
