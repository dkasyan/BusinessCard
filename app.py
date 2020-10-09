from flask import Flask

app = Flask(__name__)

@app.route('/hello')
def hello():
    my_name = "Johns"
    return f'Hello, {my_name}!'

@app.route('/home')    
def home():
    my_name = "Damian"
    return f'Hello, {my_name}!'

@app.route('/blog/<id>')
def blog(id):
    return f"This is blog entry #{id}"

@app.route('/message', methods=['POST'])
def post_message():
    return "OK"