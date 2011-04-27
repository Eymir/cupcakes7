//============================================================================
// Name        : CupcakesData.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "Ingredient.h"
#include "IngredientSet.h"
#include "Recipe.h"
#include "Menu.h"
using namespace std;

int main() {
        Menu* myMenu;
        Menu supMenu;
        myMenu = &supMenu;
 
	Ingredient *cool;
	Ingredient awesome("Peppers", "Pieces", "Pounds", "Vegetable", 50, 16);
	Ingredient *cool2;
	Ingredient awesome2("Pepperoni", "Pieces", "Pounds", "Meat", 40, 12);
	cool = &awesome;
	cool2 = &awesome2;
        Recipe* ultraCool;
	Recipe superMegaCool;
	ultraCool = &superMegaCool;
	ultraCool->setName("Cheese Pizza");
	ultraCool->setDirections("First make pizza, then eat it");
	ultraCool->getIngredientSet().push_back(*cool);
	ultraCool->getIngredientSet().push_back(*cool2);
        
        Ingredient *cool3;
	Ingredient awesome3("Peppers", "Pieces", "Pounds", "Vegetable", 50, 16);
	Ingredient *cool4;
	Ingredient awesome4("Pepperoni", "Pieces", "Pounds", "Meat", 40, 12);
	cool3 = &awesome3;
	cool4 = &awesome4;
        Recipe* ultraCool2;
	Recipe superMegaCool2;
	ultraCool2 = &superMegaCool2;
	ultraCool2->setName("Noodles");
	ultraCool2->setDirections("First make Ramen, then eat it");
	ultraCool2->getIngredientSet().push_back(*cool3);
	ultraCool2->getIngredientSet().push_back(*cool4);
        
        
        myMenu->getRecipes().push_back(*ultraCool);
        myMenu->getRecipes().push_back(*ultraCool2);
	cout << myMenu->print()<< endl; // prints 
	
     

	return 0;
}
