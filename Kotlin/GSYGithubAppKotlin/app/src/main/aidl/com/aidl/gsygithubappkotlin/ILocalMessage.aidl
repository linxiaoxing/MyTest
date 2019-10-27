// ILocalMessage.aidl
package com.aidl.gsygithubappkotlin;

// Declare any non-default types here with import statement

import com.aidl.gsygithubappkotlin.ILocalMessageCallBack;

interface ILocalMessage {

    void sendMessage(in String message);

    int getVersion();

	void registerCallBack(in ILocalMessageCallBack callback);
}