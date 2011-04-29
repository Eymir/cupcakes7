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
	void Java_com_cs474_NewIngredient_addIngredient(JNIEnv * env, jobject obj, jstring ingr, jstring type,
			jint amt, jboolean isSmall)
	{
		jboolean isCopy;
		const char * cingr = env->GetStringUTFChars(ingr, &isCopy);
		const char * ctype = env->GetStringUTFChars(type, &isCopy);
		IngredientSet *pantry = IngredientSet::getPantry();

	//	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->getName_());
		//const char* cstr = pantry->print();
		pantry->addIngredient(cingr,ctype,0);
		if (isSmall) pantry->getIngredient(cingr)->editSmallAmount(amt);
		else pantry->getIngredient(cingr)->editBigAmount(amt);
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

	jint Java_com_cs474_AnIngredientAct_getAmount(JNIEnv * env, jobject obj, jstring name)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		jboolean isCopy;
		const char * cname = env->GetStringUTFChars(name, &isCopy);
		Ingredient *ingr = pantry->getIngredient(cname);
		if(ingr != NULL) return ingr->getAmount();
		return -1;
	}

	jstring Java_com_cs474_AnIngredientAct_getType(JNIEnv * env, jobject obj, jstring name)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		jboolean isCopy;
		const char * cname = env->GetStringUTFChars(name, &isCopy);
		Ingredient *ingr = pantry->getIngredient(cname);
		if(ingr != NULL)
		{
			return env->NewStringUTF(ingr->getTypeUTF());
		}
		return NULL;
	}

	void Java_com_cs474_AnIngredientAct_addAmount(JNIEnv * env, jobject obj, jstring name, jint amt,
			jboolean isSmall)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		jboolean isCopy;
		const char * cname = env->GetStringUTFChars(name, &isCopy);
		Ingredient *ingr = pantry->getIngredient(cname);
		if(ingr != NULL)
		{
			if(isSmall) ingr->editSmallAmount(amt);
			else ingr->editBigAmount(amt);
		}
	}

	void Java_com_cs474_AnIngredientAct_useAmount(JNIEnv * env, jobject obj, jstring name, jint amt,
			jboolean isSmall)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		jboolean isCopy;
		const char * cname = env->GetStringUTFChars(name, &isCopy);
		Ingredient *ingr = pantry->getIngredient(cname);
		amt = amt * -1;
		if(ingr != NULL)
		{
			if(isSmall) ingr->editSmallAmount(amt);
			else ingr->editBigAmount(amt);
		}
	}

	void Java_com_cs474_AnIngredientAct_deleteIngredient(JNIEnv * env, jobject obj, jstring name)
	{
		IngredientSet *pantry = IngredientSet::getPantry();
		jboolean isCopy;
		const char * cname = env->GetStringUTFChars(name, &isCopy);
		Ingredient *ingr = pantry->getIngredient(cname);
		if(ingr != NULL)
		{
			pantry->deleteIngredient(cname);
		}
	}

	jstring Java_com_cs474_RecipesActivity_listRecipes(JNIEnv * env, jobject obj)
	{
		Menu *recipes = Menu::getRecipes();
		const char * str = recipes->listRecipes();
		jstring js = env->NewStringUTF(str);
		return js;
	}

	void Java_com_cs474_NewRecipe_addRecipe(JNIEnv * env, jobject obj, jstring ingr, jstring type)
	{
		jboolean isCopy;
		const char * cingr = env->GetStringUTFChars(ingr, &isCopy);
		const char * ctype = env->GetStringUTFChars(type, &isCopy);
		Menu *recipes = Menu::getRecipes();

	//	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", pantry->getName_());
		//const char* cstr = pantry->print();
		recipes->addRecipe(cingr,ctype);

		__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "NDK:LC: [%s]", recipes->print());

		//env->ReleaseStringUTFChars(logThis, szLogThis);
	}
}
