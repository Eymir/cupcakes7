/* 
 * File:   Menu.cpp
 * Author: Andrew Shoukry
 * 
 * Created on April 27, 2011, 3:54 AM
 */

#include "Menu.h"

Menu *Menu::recipes = NULL;

Menu::Menu() {
	recipes_ = new vector<Recipe*>;
	name_="default";
}

Menu::Menu(string name) {
	recipes_ = new vector<Recipe*>;
	name_ = name;
}

Menu::Menu(const Menu& orig) {
}

Menu::~Menu() {
}
/* vector<Recipe>& Menu::getRecipes(){
     return recipes_;
 }*/
const char* Menu::print() {
	string temp_ = "";

	for (int i = 0; i < recipes_->size(); i++) {
	temp_ = temp_ + (*recipes_)[i]->getName_() + "\n";
	//temp_ = temp_ + "blah";
	}

	//moreTemp = temp_.c_str();
	sprintf(Ingredient::buffer,"%s",temp_.c_str());
	return Ingredient::buffer;

}

 Menu* Menu::getRecipes()
 {
 	if(Menu::recipes == NULL)
 	{
 		Menu::recipes = new Menu("Recipes");
 	}
 	return Menu::recipes;
 }

 const char* Menu::listRecipes()
 {
 	string temp_ = "";
 	for (int i = 0; i < recipes_->size(); i++)
 	{
 		temp_ = temp_ + (*recipes_)[i]->getName() + "\n";
 		//temp_ = temp_ + "blah";
 	}

 	//moreTemp = temp_.c_str();
 	sprintf(Ingredient::buffer,"%s",temp_.c_str());
 	return Ingredient::buffer;
 }

 void Menu::addRecipe(const char* name_e, const char* type_e)
 {
 	recipes_->push_back(new Recipe(name_e, type_e));
 }

 Recipe* Menu::getRecipe(const char* name)
 {


 	string temp = name;
 	for (int i = 0; i < recipes_->size(); i++)
 	{
 		if ((*recipes_)[i]->getName().compare(name) == 0)
 		{
 			return (*recipes_)[i];
 		}
 	}
 	return NULL;//(*ingredientSet_)[0];
 }
