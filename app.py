from flask import Flask, request, redirect
from flask import render_template

app = Flask(__name__)

@app.route("/mypage")
def warehouse():
    return render_template("mypage.html")


@app.route("/mypage/me")
def me():
    return render_template("me.html")


@app.route("/mypage/contact", methods=['GET', 'POST'])
def contact():
    if request.method == 'GET':
        return render_template("contact.html")
    elif request.method == 'POST':
        print("We received POST")
        print(request.form)
        return redirect("/mypage/contact")

if __name__ == '__main__':
    app.run()