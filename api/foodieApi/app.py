from flask import Flask, jsonify
from pymongo import MongoClient
# from dotenv import load_dotenv
# import os

# Load environment variables
# load_dotenv()

app = Flask(__name__)

# MongoDB's configuration
# MONGODB_CONNECTION_STRING = os.getenv("MONGODB_CONNECTION_STRING")
# DATABASE_NAME = os.getenv("DATABASE_NAME")

MONGODB_CONNECTION_STRING = ("mongodb+srv://pimghosh2000:F0aWzHGi3yQ35aVw@selfdevelopment.e8dj5.mongodb.net"
                             "/?retryWrites=true&w=majority&appName=SelfDevelopment")
DATABASE_NAME = "foodie_app"

# MongoDB client
client = MongoClient(MONGODB_CONNECTION_STRING)
db = client[DATABASE_NAME]
food_menu_collection = db['food_details']  # Collection name in your database


@app.route('/mongo/get-all-food-menu', methods=['GET'])
def get_all_food_menu():
    try:
        # Fetch all documents from the collection
        food_menu = list(food_menu_collection.find({}, {"_id": 0}))  # Exclude the MongoDB ObjectId
        return jsonify(food_menu)
    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == '__main__':
    app.run(debug=True)
