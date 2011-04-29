/*
 * Recipe.cpp
 *
 *  Created on: Apr 27, 2011
 *      Author: Andrew Shoukry
 */

#include "Recipe.h"

Recipe::Recipe():IngredientSet("default"){
	type_ = "default";
}

Recipe::Recipe(string name_e, string type_e):IngredientSet(name_e){
	type_ = type_e;
}

string Recipe::getType(){
	return type_;
}

void Recipe::setType(string type_e){
	type_ = type_e;
}

Recipe::~Recipe(){
}
