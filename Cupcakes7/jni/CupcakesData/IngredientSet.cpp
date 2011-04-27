/*
 * IngredientSet.cpp
 *
 *  Created on: Apr 26, 2011
 *      Author: Andrew Shoukry
 */
#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include "IngredientSet.h"

IngredientSet::IngredientSet() {
	name_ = "";

}
IngredientSet::IngredientSet(string name_e) {
	name_ = name_e;

}
vector<Ingredient>& IngredientSet::getIngredientSet() {
	return ingredientSet_;

}

string IngredientSet::print() {
	string temp_ = "";
	for (int i = 0; i < ingredientSet_.size(); i++) {
		temp_ = temp_ + ingredientSet_[i].print() + "\n";

	}
	return temp_;

}

string IngredientSet::getName_() {
	return name_;
}
void IngredientSet::setName(string name_e){
	name_= name_e;
}

IngredientSet::~IngredientSet(){
    
}