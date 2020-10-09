from flask import Flask
from flask import render_template
from flask import request
from flask import redirect

app = Flask(__name__)

@app.route('/')
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

@app.route('/greeting', methods=['GET', 'POST'])
def greeting():
    if request.method == 'GET':
        print("Wyslano GET")
        return render_template("greeting.html")
    elif request.method == 'POST':

        print("Wysłano POST")
        print("We received POST")
        print(request.form)
        return redirect("/greeting")
 #   print('ITS NOT GET NOR POST')
 

       # print(request.greeting)
        #return redirect("/greeting")
 #   return text



#@app.route('/message', methods=['POST'])
#def message():
#    print(request.form)
#    return redirect("/message")