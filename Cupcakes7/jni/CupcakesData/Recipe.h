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
	string directions_;

public:
	Recipe();
	Recipe(string type_e, string directions_e);
	Recipe(string name_e, string type_e, string directions_e);
	string getType();
	string getDirections();
	string print();
	void setType(string type_e);
	void setDirections(string directions_e);
         virtual ~Recipe();

};

#endif /* RECIPE_H_ */
