/*
 * Recipe.h
 *
 *  Created on: Apr 27, 2011
 *      Author: Andrew Shoukry
 */

#ifndef RECIPE_H_
#define RECIPE_H_

#include "IngredientSet.h"

class Recipe: public IngredientSet {
protected:
	string type_;
public:
	Recipe();
	Recipe(string name_e, string type_e);
	string getType();
	void setType(string type_e);
    virtual ~Recipe();

};

#endif /* RECIPE_H_ */
