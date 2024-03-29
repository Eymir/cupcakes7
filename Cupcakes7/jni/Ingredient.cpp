/* 
 * File:   Ingredient.cpp
 * Author: Andrew Shoukry
 * 
 * Created on April 27, 2011, 3:26 AM
 */
#include <jni.h>
#include <iostream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "Ingredient.h"
using namespace std;

char Ingredient::buffer[10000];

Ingredient::Ingredient(){
			name_="";
			bigName_="";
			smallName_="";
			type_="";
			 amount_=0;
			conversionFactor_=1;

		}

Ingredient::Ingredient(const Ingredient& orig) {
    		name_=orig.name_;
			bigName_=orig.bigName_;
			smallName_=orig.smallName_;
			type_=orig.type_;
			amount_=orig.amount_;
			conversionFactor_=orig.conversionFactor_;
}

Ingredient::~Ingredient() {
}
Ingredient::Ingredient(string name_e, string bigName_e, string smallName_e, string type_e, int amount_e, int conversionFactor_e){

	name_=name_e;
	bigName_=bigName_e;
	smallName_=smallName_e;
	type_=type_e;
	amount_=amount_e;
	conversionFactor_=conversionFactor_e;

}
Ingredient::Ingredient(const char* name, const char* type, int amount)
{
	name_= name;
	type_=type;
	amount_=amount;
	if (type_.compare("Liquid") == 0)
	{
		smallName_ = "teaspoons";
		bigName_ = "fluid oz";
		conversionFactor_ = 16;
	}
	else if (type_.compare("Whole") == 0)
	{
		smallName_ = "units";
		bigName_ = "lbs";
		conversionFactor_ = 4;
	}
	else if (type_.compare("Powdered") == 0)
	{
		smallName_ = "teaspoons";
		bigName_ = "lbs";
		conversionFactor_ = 96;
	}
}

void Ingredient::changeAmount(int amount_e){
	amount_=amount_e;

}
void Ingredient::editAmount(int bigValue_e, int smallValue_e){
	amount_ += ((bigValue_e * conversionFactor_)+smallValue_e);
}
void Ingredient::editSmallAmount(int smallValue_e){
	editAmount(0,smallValue_e);
}
void Ingredient::editBigAmount(int bigValue_e){
	editAmount(bigValue_e,0);
}
void Ingredient::editName( string name_e){
	name_=name_e;
}
void Ingredient::editCoversionFactor(int conversionFactor_e){
	conversionFactor_ = conversionFactor_e;
}
void Ingredient::editBigName(string bigName_e){
	bigName_ = bigName_e;
}
void Ingredient::editSmallName(string smallName_e){
	smallName_ = smallName_e;
}
void Ingredient::editType(string type_e){
	type_=type_e;
}
string Ingredient::getName(){
	return name_;

}
string Ingredient::getBigName(){
	return bigName_;
}

string Ingredient::getSmallName(){
	return smallName_;
}
const char* Ingredient::getTypeUTF() {
	//const char* temp_ = IngredientSet::moreTemp;
	//moreTemp = temp_.c_str();
	sprintf(buffer,"%s",getType().c_str());
	return buffer;

}
string Ingredient::getType(){
	return type_;
}
int Ingredient::getAmount(){
	return amount_;
}
int Ingredient::getConversionFactor(){
	return conversionFactor_;
}
string Ingredient::print()
{
	string temp_;
	string moreTemp="";
	char str[12];
	sprintf(str, "%d", amount_);
	//str[11] = "/0";
	//temp_ = ("Name: "+ name_+ " ");
	moreTemp.append(str);
	temp_ = ("Name: "+ name_+ " " + moreTemp + " " + smallName_ + " Type: " + type_ );
		return temp_;

}

