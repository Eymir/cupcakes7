/*
 * IngredientSet.h
 *
 *  Created on: Apr 26, 2011
 *      Author: Andrew Shoukry
 */



#ifndef INGREDIENTSET_H_
#define INGREDIENTSET_H_

#include <jni.h>
#include <vector>
#include "Ingredient.h"
#include <string.h>
using namespace std;

class IngredientSet{
protected:
	vector<Ingredient*> * ingredientSet_;
	string name_;
public:
	IngredientSet();
	IngredientSet(string name_e);
    virtual ~IngredientSet();
	//vector<Ingredient>& getIngredientSet();
    void addIngredient(const char* name_e, const char* type_e, int amount_e);
	const char *getName_();
	string getName();
	void setName(string name_e);
	Ingredient* getIngredient(const char* name);
	const char* listIngredients();
    void deleteIngredient(Ingredient &ingrd);
    void deleteIngredient(const char* name_e);
    virtual const char *print();
    static IngredientSet *pantry;
    static IngredientSet* getPantry();
	friend class Menu;
};

#endif /* INGREDIENTSET_H_ */
