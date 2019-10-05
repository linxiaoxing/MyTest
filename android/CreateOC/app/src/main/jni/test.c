//
// Created by 林小興 on 2019-09-23.
//

#include "jni.h"
#include "com_brotherd_jnihelloworld_MyJni.h"

JNIEXPORT jstring JNICALL Java_com_brotherd_jnihelloworld_MyJni_getString
  (JNIEnv *env, jclass jz){

  return (*env)->NewStringUTF(env,"this is the first time for me to use jni");

  }