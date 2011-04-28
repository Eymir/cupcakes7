/*
 * IngredientSet.cpp
 *
 *  Created on: Apr 26, 2011
 *      Author: Andrew Shoukry
 */
#include <iostream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "IngredientSet.h"

IngredientSet *IngredientSet::pantry = NULL;

IngredientSet::IngredientSet() {
	name_ = "";
	ingredientSet_ = new vector<Ingredient*>;
}

IngredientSet::IngredientSet(string name_e) {
	name_ = name_e;
	ingredientSet_ = new vector<Ingredient*>;
}
//vector<Ingredient>& IngredientSet::getIngredientSet() {
//	return ingredientSet_;
//}
void IngredientSet::addIngredient(string name_e, string bigName_e, string smallName_e, string type_e, int amount_e, int conversionFactor_e)
{
	ingredientSet_->push_back(new Ingredient(name_e, bigName_e, smallName_e, type_e, amount_e, conversionFactor_e));
}

const char* IngredientSet::print() {
	string temp_ = " ";
	for (int i = 0; i < ingredientSet_->size(); i++) {
	//temp_ = temp_ + (*ingredientSet_)[i]->print() + "\n";
	temp_ = temp_ + "blah";
	}
	return temp_.c_str();

}
void IngredientSet::deleteIngredient( Ingredient &ingrd){
    string temp_=ingrd.getName();
    for (int i = 0; i < ingredientSet_->size(); i++) {
        if(temp_.compare((*ingredientSet_)[i]->getName())){
        ingredientSet_->erase(ingredientSet_->begin()+i);
        return;
        }
	}
}

const char* IngredientSet::getName_() {
	return name_.c_str();
}
void IngredientSet::setName(string name_e){
	name_= name_e;
}

IngredientSet* IngredientSet::getPantry()
{
	if(IngredientSet::pantry == NULL)
	{
		IngredientSet::pantry = new IngredientSet("Pantry");
	}
	return IngredientSet::pantry;
}

IngredientSet::~IngredientSet(){
    
}

