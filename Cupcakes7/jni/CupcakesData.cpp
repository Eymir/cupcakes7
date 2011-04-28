#include <jni.h>
#include <iostream>
#include <android/log.h>

#include "Ingredient.h"
#include "IngredientSet.h"
#include "Recipe.h"
#include "Menu.h"

using namespace std;

#define DEBUG_TAG "NDK_Cupcakes"
extern "C"
{
	void Java_com_cs474_MainMenu_initialize(JNIEnv * env, jobject obj, jstring logThis)
	{
		jboolean isCopy;
		//const char * szLogThis = env->GetStringUTFChars(logThis, &isCopy);
		IngredientSet *pantry = IngredientSet::getPantry();

	//	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->getName_());

		pantry->addIngredient("Peppers", "Pieces", "Pounds", "Vegetable", 50, 16);
		__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->print());

		//env->ReleaseStringUTFChars(logThis, szLogThis);
	}
}
