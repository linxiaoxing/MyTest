// ILocalMessageCallBack.aidl
package com.example.gsygithubappkotlin;

// Declare any non-default types here with import statements

import com.example.gsygithubappkotlin.model.AIDLResultModel;

interface ILocalMessageCallBack {

    void sendResult(in AIDLResultModel result);

}
