#!/usr/bin/env python
# coding: utf-8

import pandas as pd
import numpy as np
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import GridSearchCV
import joblib  # for saving the model

# Load the processed data
X_train = pd.read_csv("../data/X_train.csv")
X_val = pd.read_csv("../data/X_val.csv")
y_train = pd.read_csv("../data/y_train.csv").values.ravel()  # Ensure y is 1-dimensional
y_val = pd.read_csv("../data/y_val.csv").values.ravel()

# Tune logistic regression model with GridSearchCV
param_grid = {
    'C': [0.1, 1, 10],
    'penalty': ['l2'],
    'solver': ['liblinear', 'lbfgs']
}

logistic_model = LogisticRegression()
grid_search = GridSearchCV(logistic_model, param_grid, cv=5, scoring='accuracy', verbose=2)
grid_search.fit(X_train, y_train)

# Get the best model from grid search
best_logistic_model = grid_search.best_estimator_

# Evaluate the best logistic regression model
y_val_pred = best_logistic_model.predict(X_val)
print("Tuned Logistic Regression Model Evaluation:")
print(confusion_matrix(y_val, y_val_pred))
print(classification_report(y_val, y_val_pred))

# Save the best logistic regression model
joblib.dump(best_logistic_model, '../models/best_logistic_regression_model.joblib')
