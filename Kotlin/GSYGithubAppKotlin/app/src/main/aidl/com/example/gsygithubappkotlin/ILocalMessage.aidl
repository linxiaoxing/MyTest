// ILocalMessage.aidl
package com.example.gsygithubappkotlin;

// Declare any non-default types here with import statement

import com.example.gsygithubappkotlin.ILocalMessageCallBack;

interface ILocalMessage {

    void sendMessage(in String message);

    int getVersion();

	void registerCallBack(in ILocalMessageCallBack callback);
}