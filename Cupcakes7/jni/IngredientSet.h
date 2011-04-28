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
    void addIngredient(string name_e, string bigName_e, string smallName_e, string type_e, int amount_e, int conversionFactor_e);
	const char *getName_();
	void setName(string name_e);
    void deleteIngredient( Ingredient &ingrd);
    virtual const char *print();
    static IngredientSet *pantry;

    static IngredientSet* getPantry();
};

#endif /* INGREDIENTSET_H_ */
