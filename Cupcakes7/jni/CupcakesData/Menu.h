/* 
 * File:   Menu.h
 * Author: Andrew Shoukry
 *
 * Created on April 27, 2011, 3:54 AM
 */

#ifndef MENU_H
#define	MENU_H
#include <vector>
#include "Recipe.h"
class Menu {
protected:
    vector<Recipe> recipes_;
public:
    Menu();
    Menu(const Menu& orig);
    virtual ~Menu();
    vector<Recipe>& getRecipes();
    string print();

};

#endif	/* MENU_H */

