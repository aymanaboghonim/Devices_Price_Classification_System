from sklearn.preprocessing import StandardScaler
import joblib

# Load the scaler that was used during training
scaler = joblib.load('../models/scaler.pkl')

def preprocess_input(data):
    return scaler.transform(data)
