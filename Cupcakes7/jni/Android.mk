LOCAL_PATH := $(call my-dir)
MY_PATH := $(LOCAL_PATH)
include $(call all-subdir-makefiles)

include $(CLEAR_VARS)

LOCAL_PATH := $(MY_PATH)

LOCAL_LDLIBS := -llog -ldl
LOCAL_MODULE    := rmsdk
LOCAL_SRC_FILES := \
	native.c \
	Ingredient.cpp \
	IngredientSet.cpp \
	Menu.cpp \
	Recipe.cpp \
	CupcakesData.cpp

include $(BUILD_SHARED_LIBRARY)