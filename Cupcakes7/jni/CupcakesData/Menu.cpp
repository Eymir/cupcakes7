/* 
 * File:   Menu.cpp
 * Author: Andrew Shoukry
 * 
 * Created on April 27, 2011, 3:54 AM
 */

#include "Menu.h"

Menu::Menu() {
}

Menu::Menu(const Menu& orig) {
}

Menu::~Menu() {
}
 vector<Recipe>& Menu::getRecipes(){
     return recipes_;
 }
 string Menu::print(){
     	string temp_="";
	
	for (int i = 0; i < recipes_.size(); i++) {
		temp_ = temp_ + recipes_[i].print() + "\n";

	}
        
	return temp_;
     
 }
