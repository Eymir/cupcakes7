/* 
 * File:   Ingredient.h
 * Author: Andrew Shoukry
 *
 * Created on April 27, 2011, 3:26 AM
 */

#ifndef INGREDIENT_H
#define	INGREDIENT_H

#include <jni.h>
#include <iostream>
#include <string.h>
using namespace std;

class Ingredient {
    	protected:
		string name_, bigName_, smallName_, type_;
		int amount_, conversionFactor_;
public:
    Ingredient();
    Ingredient(const Ingredient& orig);
    virtual ~Ingredient();
    Ingredient(const char* name, const char* type, int amount);
	Ingredient(string name_e, string bigName_e, string smallName_e, string type_e, int amount_e, int conversionFactor_e);
	void editAmount(int bigValue_e, int smallValue_e);
	void editSmallAmount(int smallValue_e);
	void editBigAmount(int bigValue_e);
	void changeAmount(int amount_e);
	void editName( string name_e);
	void editCoversionFactor(int conversionFactor_e);
	void editBigName(string bigName_e);
	void editSmallName(string smallName_e);
	void editType(string type_e);
			string getName();
	string getBigName();
	string getSmallName();
	string getType();
	string print();
	int getAmount();
	int getConversionFactor();
private:

};

#endif	/* INGREDIENT_H */

