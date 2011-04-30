/* 
 * File:   Menu.cpp
 * Author: Andrew Shoukry
 * 
 * Created on April 27, 2011, 3:54 AM
 */

#include "Menu.h"

Menu *Menu::recipes = NULL;
Menu *Menu::smenu = NULL;

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
 void Menu::deleteRecipe(const char* name_e){
	string temp1 = name_e;
	string temp;
	for (int i = 0; i < recipes_->size(); i++) {
		temp = (*recipes_)[i]->getName();
		if(temp1.compare(temp)==0){
			recipes_->erase(recipes_->begin()+i);
		return;
		}
	}
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


 Menu* Menu::getSMenu()
 {
	if(Menu::smenu == NULL)
	{
		Menu::smenu = new Menu("smenu");
	}
	return Menu::smenu;
 }
 void Menu::smenuSet()
 {
	 if(Menu::smenu == NULL)
	 	{
	 		Menu::smenu = new Menu("smenu");
	 	}
	 else{
		 smenu->recipes_->clear();
	 }
 }

 void Menu::copyOverRecipe(int i)
 {
	//Recipe* ptr = (*(recipes->recipes_))[i];
	smenu->recipes_->push_back(   (*(recipes->recipes_))[i]    );
 }

const char* Menu::calculateMethod(){
	 IngredientSet* pantry__ = IngredientSet::getPantry();
	 vector<Ingredient> tempIngs;
	 string toBeReturned = "";
	 bool flag=false;
	 for (int i = 0; i < smenu->recipes_->size(); i++) {

		 Recipe* temp = (*smenu->recipes_)[i];
		 for (int j = 0; j < temp->ingredientSet_->size(); j++) {

			 	 flag=false;
			 	for (int k = 0; k < tempIngs.size(); k++)
			 	{


			 		if(tempIngs[k].getName().compare((*temp->ingredientSet_)[j]->getName()) != 0)
			 		{


			 		}
			 		else{

			 			 flag == true;
			 			tempIngs[k].editAmount(0,( (*temp->ingredientSet_)[j]->getAmount() ));
			 		}
			 	}
			 	if(flag == false){
			 		tempIngs.push_back(Ingredient(*(*temp->ingredientSet_)[j]));
			 	}


		 }
	 }
	 for(int i = 0; i < tempIngs.size(); i++)
	 {

		 const char* str = tempIngs[i].getName().c_str();
		 if(pantry__->getIngredient(str) != NULL)
		 {

			 tempIngs[i].editSmallAmount(-1 * pantry__->getIngredient(str)->getAmount());
		 }
	 }
	 for(int i = 0; i < tempIngs.size(); i++)
	 {

		 if(tempIngs[i].getAmount() > 0)
		 {
			 string moreTemp="";
			char str[12];
			sprintf(str, "%d", tempIngs[i].getAmount());
			//str[11] = "/0";
			//temp_ = ("Name: "+ name_+ " ");
			moreTemp.append(str);
			 toBeReturned = toBeReturned + tempIngs[i].getName() + " " + moreTemp + " "
					 + tempIngs[i].getSmallName() + "\n";
		 }
	}
	sprintf(Ingredient::buffer,"%s",toBeReturned.c_str());
	return Ingredient::buffer;
 }

