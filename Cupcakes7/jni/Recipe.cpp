/*
 * Recipe.cpp
 *
 *  Created on: Apr 27, 2011
 *      Author: Andrew Shoukry
 */

#include "Recipe.h"

Recipe::Recipe() {
		type_ = "";
	directions_="";

}
Recipe::Recipe(string type_e, string directions_e){
	type_ = type_e;
	directions_=directions_e;
}
Recipe::Recipe(string name_e, string type_e, string directions_e):IngredientSet(name_e){
	type_ = type_e;
	directions_=directions_e;
}
string Recipe::getType(){
	return type_;
}
string Recipe::getDirections(){
	return directions_;
}
const char* Recipe::print(){
	string temp_="";
	temp_ = temp_ + "Type: " + type_ + "Name: " + name_ + " Directions: " + directions_ + "\n";
	for (int i = 0; i < ingredientSet_->size(); i++) {
		temp_ = temp_ + (*ingredientSet_)[i]->print() + "\n";

	}
        
	return temp_.c_str();
}
void Recipe::setType(string type_e){
	type_ = type_e;
}
void Recipe::setDirections(string directions_e){
	directions_=directions_e;
}
Recipe::~Recipe(){
}
