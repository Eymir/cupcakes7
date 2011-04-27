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
	vector<Ingredient> ingredientSet_;
	string name_;
public:
	IngredientSet();
	IngredientSet(string name_e);
        virtual ~IngredientSet();
	vector<Ingredient>& getIngredientSet();
	string getName_();
	void setName(string name_e);
        void deleteIngredient( Ingredient &ingrd);
        virtual string print();
};


#endif /* INGREDIENTSET_H_ */
