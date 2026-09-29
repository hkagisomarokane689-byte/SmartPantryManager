Smart Pantry Manager
Overview
Smart Pantry Manager is an Android application developed in Java using Android Studio. The application helps users manage pantry ingredients, reduce food waste, and discover recipes that can be prepared using ingredients already available in their pantry.
The app provides a simple and user-friendly way to track pantry items while offering recipe suggestions through a strict ingredient-matching system. Users can add, edit, update, and delete ingredients, view available recipes, and manage application preferences through a settings screen.

Problem Statement
Many people struggle to keep track of the ingredients they have at home. This often leads to duplicate purchases, unnecessary spending, and food being wasted when ingredients expire before they are used.
Smart Pantry Manager addresses this problem by allowing users to maintain a digital pantry and receive recipe suggestions based on the ingredients they currently have available.

Features
Pantry Management
•	Add ingredients to the pantry
•	View stored ingredients
•	Edit ingredient information
•	Delete ingredients
•	Store ingredient quantities, units, and expiry dates
Recipe Suggestions
•	Displays recipes that match pantry contents
•	Uses strict ingredient matching
•	Excludes recipes with missing ingredients

Recipe Details
•	View recipe name
•	View complete ingredient list
•	View preparation method
Recipe Details
•	View recipe name
•	View complete ingredient list
•	View preparation method

Database Choice
The application uses Room Database for local storage.
Why Room Database?
Room was selected because it:
•	Provides efficient local data persistence
•	Simplifies SQLite database operations
•	Uses Data Access Objects (DAOs) for database interaction
•	Integrates easily with Android applications
•	Supports CRUD functionality efficiently

Application Screens
1. Pantry List Screen
Displays all pantry ingredients stored in the database.
2. Add/Edit Ingredient Screen
Allows the user to add new ingredients and update existing records.
3. Suggested Recipes Screen
Displays recipes that can be prepared using the available pantry ingredients.
4. Recipe Detail Screen
Displays full recipe details including ingredients and preparation steps.
5. Settings Screen
Provides application preference settings.

Setup and Installation

Requirements
•	Android Studio
•	Android SDK
•	Android Emulator or Android Device

Steps
1.	Clone the repository:
Shell
git clone https://github.com/YOUR_USERNAME/SmartPantryManager.git

1.	Open the project in Android Studio.
2.	Allow Gradle to sync.
3.	Build the project:

Plain Text
Build → Rebuild Project

1.	Run the application on an emulator or physical Android device.

Project Structure
Plain Text
activities
PantryActivity
AddIngredient
RecipeActivity
RecipeDetailActivity
SettingActivity
 
adapters
PantryAdapter
RecipeAdapter
 
database
AppDatabase
IngredientDao
RecipeDao
 
entities
PantryItem
 Recipe
