from flask import Flask, request, jsonify
import joblib
import numpy as np
import pandas as pd

app = Flask(__name__)

# Load the model and scaler
model = joblib.load('../models/best_logistic_regression_model.pkl')
scaler = joblib.load('../models/scaler.pkl')

@app.route('/')
def home():
    return "Welcome to the Device Price Classification API!"

@app.route('/predict', methods=['POST'])
def predict():
    # Get the data from the request
    data = request.get_json()

    # Convert data to DataFrame for processing
    df = pd.DataFrame(data, index=[0])

    # List of expected features
    expected_features = ['battery_power', 'blue', 'clock_speed', 'dual_sim', 'fc', 'four_g', 'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height', 'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time', 'three_g', 'touch_screen', 'wifi']

    # Ensure all expected features are present in the input
    if not all(feature in df.columns for feature in expected_features):
        return jsonify({'error': 'Missing features in input data'}), 400

    # Scale the features
    X = scaler.transform(df[expected_features])

    # Predict the price range
    prediction = model.predict(X)

    # Return the prediction
    return jsonify({'predicted_price_range': int(prediction[0])})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
