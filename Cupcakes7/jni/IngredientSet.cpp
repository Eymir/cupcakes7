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
void IngredientSet::addIngredient(const char* name_e, const char* type_e, int amount_e)
{
	ingredientSet_->push_back(new Ingredient(name_e, type_e, amount_e));
}

Ingredient* IngredientSet::getIngredient(const char* name)
{
	string temp = name;
	for (int i = 0; i < ingredientSet_->size(); i++)
	{
		if ((*ingredientSet_)[i]->getName().compare(name) == 0)
		{
			return (*ingredientSet_)[i];
		}
	}
	return NULL;//(*ingredientSet_)[0];
}

const char* IngredientSet::listIngredients()
{
	string temp_ = "";
	for (int i = 0; i < ingredientSet_->size(); i++)
	{
		temp_ = temp_ + (*ingredientSet_)[i]->getName() + "\n";
		//temp_ = temp_ + "blah";
	}

	//moreTemp = temp_.c_str();
	sprintf(Ingredient::buffer,"%s",temp_.c_str());
	return Ingredient::buffer;
}

const char* IngredientSet::print() {
	string temp_ = "";

	for (int i = 0; i < ingredientSet_->size(); i++) {
	temp_ = temp_ + (*ingredientSet_)[i]->print() + "\n";
	//temp_ = temp_ + "blah";
	}

	//moreTemp = temp_.c_str();
	sprintf(Ingredient::buffer,"%s",temp_.c_str());
	return Ingredient::buffer;

}
void IngredientSet::deleteIngredient( Ingredient &ingrd){
    string temp_=ingrd.getName();
    for (int i = 0; i < ingredientSet_->size(); i++) {
        if(temp_.compare((*ingredientSet_)[i]->getName())==0){
        	ingredientSet_->erase(ingredientSet_->begin()+i);
        return;
        }
	}
}
void IngredientSet::deleteIngredient(const char* name_e){
    string temp1 = name_e;
    string temp;
	for (int i = 0; i < ingredientSet_->size(); i++) {
		temp = (*ingredientSet_)[i]->getName();
		if(temp1.compare(temp)==0){
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

