//
// Created by 林小興 on 2019-09-23.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

/**
*
*/
jstring Java_com_example_jnisam_JNI_sayHello(JNIEnv* env, jobject jobj) {

  char* text = "I am from c";
  return (*env)->NewStringUTF(env, text);
}

