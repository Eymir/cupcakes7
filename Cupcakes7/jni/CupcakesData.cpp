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
	void Java_com_cs474_NewIngredient_addIngredient(JNIEnv * env, jobject obj, jstring ingr, jstring type, jint amt)
	{
		jboolean isCopy;
		const char * cingr = env->GetStringUTFChars(ingr, &isCopy);
		const char * ctype = env->GetStringUTFChars(type, &isCopy);
		IngredientSet *pantry = IngredientSet::getPantry();

	//	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->getName_());
		//const char* cstr = pantry->print();
		pantry->addIngredient(cingr,ctype,amt);
		__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->print());

		//env->ReleaseStringUTFChars(logThis, szLogThis);
	}

	jstring Java_com_cs474_IngredientsActivity_listIngredients(JNIEnv * env, jobject obj)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		const char * str = pantry->listIngredients();
		jstring js = env->NewStringUTF(str);
		return js;
	}
}
