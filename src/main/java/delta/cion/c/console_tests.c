#include <jni.h>
#include <stdio.h>
#include "../delta_cion_Main.h"

JNIEXPORT void JNICALL Java_delta_cion_Main_dc(JNIEnv *env, jobject obj) {
    printf("Success!!!\n");
    printf("Pepe a frog!\n");
}