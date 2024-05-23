#!/usr/bin/env python
# coding: utf-8

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler

# Load the dataset
train_df = pd.read_csv("../data/train.csv")
test_df = pd.read_csv("../data/test.csv")

# Display the first few rows of the dataset
print(train_df.head())

# Check for missing values
print(train_df.isnull().sum())

# Summary statistics
print(train_df.describe())

# Correlation matrix
plt.figure(figsize=(12, 10))
correlation_matrix = train_df.corr()
sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm')
plt.title("Correlation Matrix")
plt.show()

# Distribution of target variable
sns.countplot(train_df['price_range'])
plt.title("Distribution of Price Range")
plt.show()

# Feature engineering: Add any feature engineering steps here
# Example: Create a new feature
train_df['battery_to_weight'] = train_df['battery_power'] / train_df['mobile_wt']
test_df['battery_to_weight'] = test_df['battery_power'] / test_df['mobile_wt']

# Split the dataset into training and validation sets
X = train_df.drop(columns=['id', 'price_range'])
y = train_df['price_range']
X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

# Standardize the features
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_val = scaler.transform(X_val)
X_test = scaler.transform(test_df.drop(columns=['id']))

# Save the processed data for later use
train_df.to_csv("../data/processed_train.csv", index=False)
test_df.to_csv("../data/processed_test.csv", index=False)
pd.DataFrame(X_train, columns=X.columns).to_csv("../data/X_train.csv", index=False)
pd.DataFrame(X_val, columns=X.columns).to_csv("../data/X_val.csv", index=False)
pd.DataFrame(X_test, columns=X.columns).to_csv("../data/X_test.csv", index=False)
pd.DataFrame(y_train).to_csv("../data/y_train.csv", index=False)
pd.DataFrame(y_val).to_csv("../data/y_val.csv", index=False)
