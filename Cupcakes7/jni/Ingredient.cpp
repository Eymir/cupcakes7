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

		string Ingredient::getType(){
			return type_;
		}
		int Ingredient::getAmount(){
			return amount_;
		}
		int Ingredient::getConversionFactor(){
			return conversionFactor_;
		}
		string Ingredient::print(){
			string temp_;


				temp_ = ("Name: "+ name_+ " " +  " " + smallName_ + " Type: " + type_ );
 				return temp_;

		}
                
