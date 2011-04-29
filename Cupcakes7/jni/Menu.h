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
    vector<Recipe*> *recipes_;
    string name_;
public:
    Menu();
    Menu(string name);
    Menu(const Menu& orig);
    virtual ~Menu();
    //vector<Recipe>& getRecipes();
    const char* print();
    static Menu *recipes;
    static Menu* getRecipes();
    static Menu *smenu;
    static Menu* getSMenu();
    void smenuSet();
    void copyOverRecipe(int i);
    Recipe* getRecipe(const char* name);
    void deleteRecipe(const char* name_e);
    const char* listRecipes();
    void addRecipe(const char* name_e, const char* type_e);

};

#endif	/* MENU_H */

